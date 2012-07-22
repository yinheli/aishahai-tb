package com.nzonly.tb.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.nzonly.tb.test.BaseTestNoWeb;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-20 下午10:34:49
 * @version V1.0
 */
public class UserServiceTest extends BaseTestNoWeb {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testGetByUid() {
		Assert.assertNull(userService.getByUid("__123456"));
	}
	
	@Test
	public void testGetByAuthUserId() {
		userService.getByAuthUserId("12", "taobao");
	}

}
