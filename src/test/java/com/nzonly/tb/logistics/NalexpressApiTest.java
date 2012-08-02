package com.nzonly.tb.logistics;

import org.junit.Test;

/**
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-8-3 上午12:24:51
 * @version V1.0
 */
public class NalexpressApiTest {
	
	@Test
	public void testTrace() throws Exception {
		NalexpressApi api = new NalexpressApi();
		api.trace("8600158192");
	}

}
