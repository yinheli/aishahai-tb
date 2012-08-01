package com.nzonly.tb.taobao;

import org.springframework.stereotype.Component;

import com.nzonly.tb.taobao.exception.TaobaoApiException;
import com.nzonly.tb.taobao.exception.TaobaoException;
import com.taobao.api.ApiException;
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
public class LogisticsService extends TaobaoService {
	
	/**
	 * 运单跟踪
	 * 
	 * @param tid
	 * @param sellerNick
	 * @throws TaobaoException
	 * @author yinheli
	 * @date 2012-7-31 下午11:54:05
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
	 * @param session 授权 token
	 * @throws TaobaoException
	 * @author yinheli
	 * @date 2012-8-1 下午10:27:12
	 */
	public void logisticsOrdersGet(String session) throws TaobaoException {
		LogisticsOrdersGetRequest req = new LogisticsOrdersGetRequest();
		req.setFields("tid, buyer_nick, receiver_name, receiver_phone, receiver_mobile, created, out_sid, item_title");
		LogisticsOrdersGetResponse resp;
		try {
			resp = client.execute(req, session);
			
			if (log.isDebugEnabled()) {
				log.debug("resp:{}", dump(resp));
			}
		} catch (ApiException e) {
			throw new TaobaoException(e);
		}
	}

}
