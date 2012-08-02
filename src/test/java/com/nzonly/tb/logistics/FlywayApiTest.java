package com.nzonly.tb.logistics;

import org.junit.Test;

/**
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-8-3 上午12:07:37
 * @version V1.0
 */
public class FlywayApiTest {
	
	private FlywayApi api = new FlywayApi();
	
	@Test
	public void testTrace() throws Exception {
		System.out.println(api.trace("DA801700669NZ"));
	}

}
