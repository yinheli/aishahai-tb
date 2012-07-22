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
public class LogisticsServiceTest extends BaseTestNoWeb {
	
	@Autowired
	private LogisticsService service;
	
	@Test
	public void test() throws Exception {
		service.traceSearch(197520245908547L, "爱莎海");
	}

}
