package com.nzonly.tb.web;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nzonly.tb.Constants;
import com.nzonly.tb.entity.AuthInfo;
import com.nzonly.tb.entity.User;
import com.nzonly.tb.security.OpenAuthenticationToken;
import com.nzonly.tb.security.ShiroDbRealm;
import com.nzonly.tb.security.ShiroDbRealm.HashPassword;
import com.nzonly.tb.service.UserService;
import com.nzonly.tb.taobao.AuthService;

/**
 * 应用授权
 * 
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-21 上午10:47:40
 * @version V1.0
 */
@Controller
@RequestMapping("/open/")
public class AuthController extends BaseController {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = "auth", method = RequestMethod.GET)
	public String auth(@RequestParam String code, @RequestParam String state) throws Exception {
		log.debug("code: {}", code);
		if (code == null || StringUtils.isEmpty(code)) {
			return "redirect:/login";
		}
		
		AuthInfo info = authService.auth(code, state);
		
		// 用户信息处理
		User user = userService.getByAuthUserId(info.getTaobaoUserId(), Constants.FromChannel.TAOBAO);
		if (user == null) {
			user = new User();
			user.setUid(info.getTaobaoUserNick());
			user.setNickname(info.getTaobaoUserNick());
			HashPassword pwd = ShiroDbRealm.encrypt(info.getAccessToken());
			user.setPwd(pwd.password);
			user.setSalt(pwd.salt);
			
			user.setAuthId(info.getId());
			user.setAuthUserId(info.getTaobaoUserId());
			user.setFromChannel(Constants.FromChannel.TAOBAO);
			
			userService.save(user);
		}

		SecurityUtils.getSubject().login(new OpenAuthenticationToken(user.getUid()));
		
		return "redirect:/";
	}

}
