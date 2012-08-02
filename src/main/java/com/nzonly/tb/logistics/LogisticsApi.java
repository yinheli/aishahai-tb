package com.nzonly.tb.logistics;

import java.io.IOException;

/**
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-8-3 上午12:43:41
 * @version V1.0
 */
public interface LogisticsApi {
	
	/**
	 * 获取物流运单信息
	 * 
	 * @param outId
	 * @return
	 * @throws IOException
	 * @author yinheli
	 * @date 2012-8-3 上午12:45:28
	 */
	String trace(String outId) throws IOException;
	
	/**
	 * 是否通过海关
	 * 
	 * @param trace
	 * @return
	 * @author yinheli
	 * @date 2012-8-3 上午12:45:45
	 */
	boolean isCustomsPass(String trace);

}
