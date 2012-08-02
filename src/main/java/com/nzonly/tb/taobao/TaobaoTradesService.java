package com.nzonly.tb.taobao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.nzonly.tb.Constants;
import com.nzonly.tb.entity.AuthInfo;
import com.nzonly.tb.entity.TaobaoTask;
import com.nzonly.tb.entity.TaobaoTrade;
import com.nzonly.tb.service.AuthInfoService;
import com.nzonly.tb.taobao.exception.TaobaoApiException;
import com.nzonly.tb.taobao.exception.TaobaoException;
import com.nzonly.tb.taobao.util.TaobaoBeanUtil;
import com.taobao.api.ApiException;
import com.taobao.api.domain.Trade;
import com.taobao.api.request.TopatsResultGetRequest;
import com.taobao.api.request.TopatsTradesSoldGetRequest;
import com.taobao.api.request.TradeFullinfoGetRequest;
import com.taobao.api.request.TradesSoldGetRequest;
import com.taobao.api.response.TopatsResultGetResponse;
import com.taobao.api.response.TopatsTradesSoldGetResponse;
import com.taobao.api.response.TradeFullinfoGetResponse;
import com.taobao.api.response.TradesSoldGetResponse;

/**
 * 淘宝交易操作
 * 
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-21 下午4:04:13
 * @version V1.0
 */
@Component
public class TaobaoTradesService extends TaobaoService {
	
	@Autowired
	private AuthInfoService authInfoService;
	
	/**
	 * 搜索当前会话用户作为卖家已卖出的交易数据
	 * 
	 * <p>
	 * 此方法总是查询淘宝 api 数据, 较慢.
	 * 查询完毕后更新/创建 Trade 数据到本地数据库
	 * </p>
	 * 
	 * <p> 该接口为实时获取数据, 需要分页</p>
	 *  
	 * @param start 起始时间
	 * @param end 结束时间
	 * @param pageRequest 分页请求
	 * @param session
	 * @return
	 * @throws TaobaoException
	 * @author yinheli
	 * @date 2012-7-24 上午7:09:06
	 */
	public Page<TaobaoTrade> tradesSoldGet(Date start, Date end, PageRequest pageRequest, String session) throws TaobaoException {
		String fields = "tid, buyer_nick, payment,created, pay_time, status, alipay_id, buyer_email, buyer_alipay_no, consign_time, orders.title, orders.pic_path, orders.price";
		TradesSoldGetRequest req = new TradesSoldGetRequest();
		req.setFields(fields);
		req.setStartCreated(start);
		req.setEndCreated(end);
		req.setPageNo((long)pageRequest.getPageNumber() + 1);
		req.setPageSize((long)pageRequest.getPageSize());
		
		// taobao default max value
		if (req.getPageSize() > 40) {
			req.setPageSize(40L);
		}
		
		try {
			TradesSoldGetResponse resp = client.execute(req, session);
			/*if (log.isDebugEnabled()) {
				log.debug("trades:{}, \nall:{}", dump(resp.getTrades()), dump(resp));
			}*/
			
			if (resp.getTrades() == null || resp.getTrades().isEmpty()) {
				return null;
			}
			
			AuthInfo authInfo = authInfoService.getByAccessToken(session);
			
			List<TaobaoTrade> taobatTs = new ArrayList<TaobaoTrade>();
			List<Trade> ts = resp.getTrades();
			for (Trade trade : ts) {
				/*if (log.isDebugEnabled()) {
					log.debug("trade:{}", dump(trade));
				}*/
				TaobaoTrade tt = tradeService.getByTid(trade.getTid());
				boolean updateFlag = true;
				if (tt == null) {
					updateFlag = false;
					tt = new TaobaoTrade();
				}
				
				// transfer
				TaobaoBeanUtil.taobaoTrade2LocalTrade(trade, tt);
				tt.setAuthId(authInfo.getId());
				
				if (updateFlag) {
					tradeService.update(tt);
				} else {
					tradeService.save(tt);
				}
				taobatTs.add(tt);
			}
			return new PageImpl<TaobaoTrade>(taobatTs, pageRequest, resp.getTotalResults());
		} catch (ApiException e) {
			throw new TaobaoApiException(e);
		}
	}
	
	/**
	 * 异步获取三个月内已卖出的交易详情
	 * 
	 * @param start
	 * @param end
	 * @param session
	 * @return
	 * @author yinheli
	 * @throws ApiException 
	 * @date 2012-7-21 下午4:15:54
	 */
	public TaobaoTask topatsTradesSoldGet(Date start, Date end, String session) throws TaobaoException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String fields = "tid, buyer_nick, payment,created, pay_time, status, alipay_id, buyer_email, buyer_alipay_no, consign_time, orders.title, orders.pic_path, orders.price";
		
		TopatsTradesSoldGetRequest req = new TopatsTradesSoldGetRequest();
		req.setStartTime(sdf.format(start));
		req.setEndTime(sdf.format(end));
		req.setFields(fields);
		
		TopatsTradesSoldGetResponse resp;
		try {
			resp = client.execute(req, session);
		} catch (ApiException e) {
			throw new TaobaoApiException(e);
		}
		
		if (resp.getTask() == null) {
			if ("isv.task-duplicate".equals(resp.getSubCode())) {
				TaobaoTask task = new TaobaoTask();
				// warn! bad code
				task.setTaskId(Long.parseLong(resp.getSubMsg().substring(resp.getSubMsg().indexOf("TaskId=") + 7)));
				task.setParams(resp.getParams().toString());
				taskService.saveOrUpdate(task);
				return task;
			} else {
				log.warn("may be some errors: {}", dump(resp));
				return null;
			}
		}
		
		if (log.isDebugEnabled()) {
			log.debug("resp: task:{}, all:{}", dump(resp.getTask()), dump(resp));
		}
		
		try {
			TaobaoTask task = new TaobaoTask();
			BeanUtils.copyProperties(task, resp.getTask());
			task.setMethod(resp.getTask().getMethod());
			task.setParams(resp.getParams().toString());
			task.setBody(resp.getBody());
			taskService.save(task);
			return task;
		} catch (Exception e) {
			throw new TaobaoException(e);
		}
	}
	
	/**
	 * 获取异步任务结果
	 *  
	 * @param taskId
	 * @return
	 * @author yinheli
	 * @date 2012-7-21 下午4:16:50
	 */
	public TaobaoTask topatsTesultGet(Long taskId) throws TaobaoException {
		// 检查数据库是否存在 task, task 是否在本地已经处理完毕, 或正在处理, 如果是, 不再向淘宝发起请求
		TaobaoTask localTask = taskService.getByTaskId(taskId);
		if (localTask != null ) {
			String status = localTask.getStatus();
			if (Constants.TaskStatus.FINISH.equals(status) || Constants.TaskStatus.HANDING.equals(status)) {
				return localTask;
			}
		}
		
		TopatsResultGetRequest req = new TopatsResultGetRequest();
		req.setTaskId(taskId);
		try {
			TopatsResultGetResponse resp = client.execute(req);
			if (resp.getTask() == null) {
				log.error("task query status mybe exception: code:{}, msg:{}, body:{}", 
						new Object[]{resp.getErrorCode(), resp.getMsg(), resp.getBody()});
				throw new TaobaoException(resp.getSubMsg());
			}
			
			if (log.isDebugEnabled()) {
				log.debug("resp: task:{}, all:{}", dump(resp.getTask()), dump(resp));
			}
			TaobaoTask task = taskService.getByTaskId(taskId);
			task.setStatus(resp.getTask().getStatus());
			task.setLastCheckTime(new Date());
			task.setCheckCode(resp.getTask().getCheckCode());
			task.setDownloadUrl(resp.getTask().getDownloadUrl());
			taskService.saveOrUpdate(task);
			return task;
		} catch (ApiException e) {
			throw new TaobaoApiException(e);
		}
	}
	
	/**
	 * 获取单笔订单详情
	 * 
	 * @param tid
	 * @param session
	 * @throws TaobaoException
	 * @author yinheli
	 * @date 2012-7-22 上午10:24:45
	 */
	public void fullinfoGet(long tid, String session) throws TaobaoException {
		String fields = "tid, buyer_nick, payment,created, pay_time, status, alipay_id, buyer_email, buyer_alipay_no, consign_time, orders.title, orders.pic_path, orders.price";
		TradeFullinfoGetRequest req = new TradeFullinfoGetRequest();
		req.setFields(fields);
		req.setTid(tid);
		
		try {
			TradeFullinfoGetResponse resp = client.execute(req, session);
			if (log.isDebugEnabled()) {
				log.debug("resp:{}, all:{}", dump(resp.getTrade()), dump(resp));
			}
		} catch (ApiException e) {
			throw new TaobaoApiException(e);
		}
		
	}

}
