package com.nzonly.tb.taobao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.nzonly.tb.test.BaseTestNoWeb;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-22 上午12:19:08
 * @version V1.0
 */
public class LogisticsServiceTest extends BaseTestNoWeb implements TestConstants {
	
	@Autowired
	private LogisticsService service;
	
	@Test
	public void testTraceSearch() throws Exception {
		service.traceSearch(200474609135389L, "爱莎海");
	}
	
	@Test
	public void testLogisticsOrdersGet() throws Exception {
		service.logisticsOrdersGet(session);
	}

}
