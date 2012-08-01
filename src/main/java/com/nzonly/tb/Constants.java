package com.nzonly.tb;

import java.util.HashMap;
import java.util.Map;

import com.nzonly.tb.Constants.TradeStatus;


/**
 * 系统常量
 * 
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-21 上午11:01:20
 * @version V1.0
 */
public interface Constants {
	
	/**
	 * web 前端分页大小
	 */
	int PAGE_SIZE = 15;
	
	/**
	 * 异步任务结果存放地址
	 */
	String TASK_BASE_RESULT_DIR = "/tmp/tb/task";
	
	interface FromChannel {
		String TAOBAO = "taobao";
	}
	
	/**
	 * 淘宝任务处理状态, 封装淘宝的处理状态和本地的处理状态
	 * 
	 * @author yinheli
	 * @link yinheli@gmail.com
	 * @date 2012-7-21 下午10:51:17
	 * @version V1.0
	 */
	interface TaskStatus {
		/**
		 * 淘宝还未开始处理
		 */
		String NEW = "new";
		
		/**
		 * 淘宝处理中
		 */
		String DOING = "doing";
		
		/**
		 * 淘宝处理结束 (可以下载)
		 */
		String DONE = "done";
		
		/**
		 * 本地处理中
		 */
		String HANDING = "local_handing";
		
		/**
		 * 本地处理完成
		 */
		String FINISH = "local_finish";
	}
	
	interface TradeStatus {
		/**
		 * 没有创建支付宝交
		 */
		String TRADE_NO_CREATE_PAY = "TRADE_NO_CREATE_PAY";
		
		/**
		 * 等待买家付款
		 */
		String WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
		
		/**
		 * 等待卖家发货,即:买家已付款
		 */
		String WAIT_SELLER_SEND_GOODS = "WAIT_SELLER_SEND_GOODS";
		
		/**
		 * 已发货
		 */
		String WAIT_BUYER_CONFIRM_GOODS = "WAIT_BUYER_CONFIRM_GOODS";
		
		/**
		 * 买家已签收,货到付款专用
		 */
		String TRADE_BUYER_SIGNED = "TRADE_BUYER_SIGNED";
		
		/**
		 * 交易成功
		 */
		String TRADE_FINISHED = "TRADE_FINISHED";
		
		/**
		 * 付款以后用户退款成功，交易自动关闭
		 */
		String TRADE_CLOSED = "TRADE_CLOSED";
		
		/**
		 * 付款以前，卖家或买家主动关闭交易
		 */
		String TRADE_CLOSED_BY_TAOBAO = "TRADE_CLOSED_BY_TAOBAO";
		
		/**
		 * 状态代码key, 中文说明 value
		 */
		Map<String, String> STATUS_MAP = _ConstatusInitHelper.initTradeStatus();
		
	}


}

class _ConstatusInitHelper {

	/**
	 * @return
	 * @author yinheli
	 * @date 2012-7-30 下午11:18:58
	 */
	public static Map<String, String> initTradeStatus() {
		Map<String, String> status = new HashMap<String, String>();
		
		status.put(TradeStatus.TRADE_NO_CREATE_PAY, "未支付");
		status.put(TradeStatus.WAIT_BUYER_PAY, "等待付款");
		status.put(TradeStatus.WAIT_SELLER_SEND_GOODS, "等待发货");
		status.put(TradeStatus.WAIT_BUYER_CONFIRM_GOODS, "已发货");
		status.put(TradeStatus.TRADE_BUYER_SIGNED, "已签收");
		status.put(TradeStatus.TRADE_FINISHED, "交易成功");
		status.put(TradeStatus.TRADE_CLOSED, "交易关闭");
		status.put(TradeStatus.TRADE_CLOSED_BY_TAOBAO, "主动关闭");
		status.put(null, "");
		
		return status;
		
	}
	
}
