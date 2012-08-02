package com.nzonly.tb.taobao.util;

import java.util.Date;

import com.alibaba.fastjson.JSONArray;
import com.nzonly.tb.entity.Logistics;
import com.nzonly.tb.entity.TaobaoTrade;
import com.taobao.api.domain.Location;
import com.taobao.api.domain.Shipping;
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
	
	/**
	 * 转换淘宝 Shipping 对象为 Logistics 对象
	 * 
	 * @param sh
	 * @param lg
	 * @author yinheli
	 * @date 2012-8-2 上午12:14:10
	 */
	public static void taobaoShipping2Logistics(Shipping sh, Logistics lg) {
		lg.setBuyerNick(sh.getBuyerNick());
		lg.setCompanyName(sh.getCompanyName());
		lg.setCreated(sh.getCreated());
		lg.setItemTitle(sh.getItemTitle());
		lg.setOutSid(sh.getOutSid());
		lg.setStatus(sh.getStatus());
		
		lg.setReceiverName(sh.getReceiverName());
		lg.setReceiverMobile(sh.getReceiverMobile());
		lg.setReceiverPhone(sh.getReceiverPhone());
		
		if (sh.getLocation() != null) {
			Location location = sh.getLocation();
			StringBuilder lsb = new StringBuilder();
			if (location.getState() != null) {
				lsb.append(location.getState()).append(", ");
			}
			
			if (location.getCity() != null) {
				lsb.append(location.getCity()).append(", ");
			}
			
			if (location.getDistrict() != null) {
				lsb.append(location.getDistrict()).append(", ");
			}
			
			if (location.getAddress() != null) {
				lsb.append(location.getAddress()).append(", ");
			}
			
			if (location.getZip() != null) {
				lsb.append("[").append(location.getZip()).append("]");
			}
			
			if (lsb.length() > 0) {
				lg.setReceiverLocation(lsb.toString());
			}
		}
		
		lg.setTid(sh.getTid());
	}

}
