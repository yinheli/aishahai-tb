package com.nzonly.tb.taobao.util;

import java.util.Date;

import com.alibaba.fastjson.JSONArray;
import com.nzonly.tb.entity.TaobaoTrade;
import com.taobao.api.domain.Trade;

/**
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-7-31 下午10:38:54
 * @version V1.0
 */
public class TaobaoBeanUtil {
	
	/**
	 * 将淘宝与对象 Trade 属性拷贝为 本地实体 ben TaobaoTrade
	 * @param taobaoTrade taobao SDK domain
	 * @param localTrade 本地实体bean
	 * @author yinheli
	 * @date 2012-7-31 下午10:44:44
	 */
	public static void taobaoTrade2LocalTrade(Trade taobaoTrade, TaobaoTrade localTrade) {
		localTrade.setBuyerNick(taobaoTrade.getBuyerNick());
		localTrade.setBuyerAlipayNo(taobaoTrade.getBuyerAlipayNo());
		localTrade.setConsignTime(taobaoTrade.getConsignTime());
		if (taobaoTrade.getPayment() != null) {
			localTrade.setPayment(Double.parseDouble(taobaoTrade.getPayment()));
		}
		localTrade.setStatus(taobaoTrade.getStatus());
		localTrade.setCodStatus(taobaoTrade.getCodStatus());
		localTrade.setTid(taobaoTrade.getTid());
		localTrade.setPayTime(taobaoTrade.getPayTime());
		localTrade.setCreated(taobaoTrade.getCreated());
		
		localTrade.setOrders(JSONArray.toJSONString(taobaoTrade.getOrders()));
		localTrade.setLastUpdateTime(new Date());
	}

}
