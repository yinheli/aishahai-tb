package com.nzonly.tb.taobao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.nzonly.tb.entity.AuthInfo;
import com.nzonly.tb.service.AuthInfoService;
import com.nzonly.tb.test.BaseTestNoWeb;

/**
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-8-1 上午12:27:16
 * @version V1.0
 */
public class AuthServiceTest extends BaseTestNoWeb {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private AuthInfoService authInfoService;
	
	@Test
	public void testRefreshToken() throws Exception {
		AuthInfo info = authInfoService.getByTaobaoUserId("60565416");
		authService.refreshToken(info);
	}

}
