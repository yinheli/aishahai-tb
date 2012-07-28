package com.nzonly.tb.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import com.nzonly.tb.test.BaseTestNoWeb;

/**
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-7-24 下午10:22:55
 * @version V1.0
 */
public class TaobaoTradeServiceTest extends BaseTestNoWeb {
	
	@Autowired
	private TaobaoTradeService service;
	
	@Test
	public void testGetByPage() throws Exception {
		service.getByPage(new PageRequest(1, 10));
	}

}
