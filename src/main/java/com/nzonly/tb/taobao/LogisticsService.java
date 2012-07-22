package com.nzonly.tb.taobao;

import org.springframework.stereotype.Component;

import com.nzonly.tb.taobao.exception.TaobaoApiException;
import com.nzonly.tb.taobao.exception.TaobaoException;
import com.taobao.api.ApiException;
import com.taobao.api.request.LogisticsTraceSearchRequest;
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
	
	public void traceSearch(Long tid, String sellerNick) throws TaobaoException {
		LogisticsTraceSearchRequest req = new LogisticsTraceSearchRequest();
		req.setTid(tid);
		req.setSellerNick(sellerNick);
		try {
			LogisticsTraceSearchResponse resp = client.execute(req);
			log.debug("resp:{}", dump(resp));
		} catch (ApiException e) {
			throw new TaobaoApiException(e);
		}
	}

}
