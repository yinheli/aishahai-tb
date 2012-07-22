package com.nzonly.tb.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import com.nzonly.tb.test.BaseTestNoWeb;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-22 上午11:01:58
 * @version V1.0
 */
public class TaobaoTaskServiceTest extends BaseTestNoWeb {
	
	@Autowired
	private TaobaoTaskService taskService;
	
	@Test
	public void testGetByPage() throws Exception {
		taskService.getByPage(new PageRequest(0, 10));
	}

}
