package com.nzonly.tb.taobao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.nzonly.tb.entity.TaobaoTask;
import com.nzonly.tb.entity.TaobaoTrade;
import com.nzonly.tb.taobao.exception.TaobaoApiException;
import com.nzonly.tb.taobao.exception.TaobaoException;
import com.taobao.api.ApiException;
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
		String fields = "tid, buyer_nick, payment, alipay_no, buyer_alipay_no, orders.title, orders.pic_path, orders.price";
		TradesSoldGetRequest req = new TradesSoldGetRequest();
		req.setFields(fields);
		req.setStartCreated(start);
		req.setEndCreated(end);
		req.setPageNo((long)pageRequest.getPageNumber());
		req.setPageSize((long)pageRequest.getPageSize());
		try {
			TradesSoldGetResponse resp = client.execute(req, session);
			if (log.isDebugEnabled()) {
				log.debug("trades:{}, \nall:{}", dump(resp.getTrades()), dump(resp));
			}
		} catch (ApiException e) {
			throw new TaobaoApiException(e);
		}
		
		return null;
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
		String fields = "tid, buyer_nick, payment, alipay_no, buyer_alipay_no, orders.title, orders.pic_path, orders.price";
		
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
			log.warn("may be some errors: {}", dump(resp));
			return null;
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
			taskService.update(task);
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
		String fields = "tid, buyer_nick, payment, alipay_no, buyer_alipay_no, orders.title, orders.pic_path, orders.price";
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
