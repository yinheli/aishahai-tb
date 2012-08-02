package com.nzonly.tb.taobao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.nzonly.tb.entity.AuthInfo;
import com.nzonly.tb.entity.Logistics;
import com.nzonly.tb.service.AuthInfoService;
import com.nzonly.tb.service.LogisticsService;
import com.nzonly.tb.taobao.exception.TaobaoApiException;
import com.nzonly.tb.taobao.exception.TaobaoException;
import com.nzonly.tb.taobao.util.TaobaoBeanUtil;
import com.taobao.api.ApiException;
import com.taobao.api.domain.Shipping;
import com.taobao.api.request.LogisticsOrdersGetRequest;
import com.taobao.api.request.LogisticsTraceSearchRequest;
import com.taobao.api.response.LogisticsOrdersGetResponse;
import com.taobao.api.response.LogisticsTraceSearchResponse;

/**
 * 物流业务查询/处理
 * 
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-21 下午11:58:23
 * @version V1.0
 */
@Component
public class TaobaoLogisticsService extends TaobaoService {
	
	/**
	 * 物流信息, DB service
	 */
	@Autowired
	private LogisticsService logisticsService;
	
	@Autowired
	private AuthInfoService authInfoService;
	
	/**
	 * 运单跟踪
	 * 
	 * @param tid
	 * @param sellerNick
	 * @throws TaobaoException
	 * @author yinheli
	 * @date 2012-7-31 下午11:54:05
	 * @deprecated 暂时不用
	 */
	public void traceSearch(Long tid, String sellerNick) throws TaobaoException {
		LogisticsTraceSearchRequest req = new LogisticsTraceSearchRequest();
		req.setTid(tid);
		req.setSellerNick(sellerNick);
		try {
			LogisticsTraceSearchResponse resp = client.execute(req);
			log.debug("resp:{}, trace:{}", dump(resp), dump(resp.getTraceList()));
		} catch (ApiException e) {
			throw new TaobaoApiException(e);
		}
	}
	
	/**
	 * 批量查询物流订单
	 * 
	 * @param tid 交易号, 可以为空, 不为空时, pageRequest 无效. 只返回一条
	 * @param pageRequest 分页信息
	 * @param session 授权 token 
	 * @return tid 不为空时, 且交易信息存在时, 返回一条, 否则按照分页请求返回
	 * @throws TaobaoException
	 * @author yinheli
	 * @date 2012-8-1 下午11:58:07
	 */
	public Page<Logistics> logisticsOrdersGet(Long tid, Date start, Date end, PageRequest pageRequest, String session) throws TaobaoException {
		LogisticsOrdersGetRequest req = new LogisticsOrdersGetRequest();
		req.setFields("tid, buyer_nick, item_title, receiver_name, receiver_phone, receiver_mobile, receiver_location, created, company_name, out_sid, status");
		if (tid != null) {
			req.setTid(tid);
		} else {
			req.setPageNo((long) pageRequest.getPageNumber());
			req.setPageSize((long) pageRequest.getPageSize());
			
			if (start != null) {
				req.setStartCreated(start);
			}
			
			if (end != null) {
				req.setEndCreated(end);
			}
		}
		LogisticsOrdersGetResponse resp;
		try {
			resp = client.execute(req, session);
			
			List<Shipping> shippings = resp.getShippings();
			
			if (shippings == null || shippings.isEmpty()) {
				return null;
			}
			
			AuthInfo authInfo = authInfoService.getByAccessToken(session);
			
			List<Logistics> logs = new ArrayList<Logistics>();
			for (Shipping sh : shippings) {
				Logistics lg = new Logistics();
				TaobaoBeanUtil.taobaoShipping2Logistics(sh, lg);
				logs.add(lg);
				lg.setAuthId(authInfo.getId());
				logisticsService.saveOuUpdate(lg);
			}
			
			return new PageImpl<Logistics>(logs, pageRequest, resp.getTotalResults());
		} catch (ApiException e) {
			throw new TaobaoException(e);
		}
	}

}
