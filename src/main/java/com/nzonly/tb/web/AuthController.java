package com.nzonly.tb.web;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.nzonly.tb.Constants;
import com.nzonly.tb.dto.AuthDTO;
import com.nzonly.tb.entity.AuthInfo;
import com.nzonly.tb.entity.User;
import com.nzonly.tb.security.OpenAuthenticationToken;
import com.nzonly.tb.security.ShiroDbRealm;
import com.nzonly.tb.security.ShiroDbRealm.HashPassword;
import com.nzonly.tb.service.AuthInfoService;
import com.nzonly.tb.service.UserService;
import com.taobao.api.internal.util.WebUtils;

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

	@Value("${app.token_uri}")
	private String tokenUri;

	@Value("${app.key}")
	private String appKey;

	@Value("${app.secret}")
	private String appSecret;
	
	@Value("${app.success_callback}")
	private String redirectUri;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthInfoService authInfoService;

	@RequestMapping(value = "auth", method = RequestMethod.GET)
	public String auth(@RequestParam String code, @RequestParam String state) throws Exception {
		log.debug("code: {}", code);
		if (code == null || StringUtils.isEmpty(code)) {
			return "redirect:/login";
		}
		Map<String, String> params = new HashMap<String, String>();
		params.put("client_id", appKey);
		params.put("client_secret", appSecret);
		params.put("grant_type", "authorization_code");
		params.put("code", code);
		params.put("redirect_uri", URLEncoder.encode(redirectUri, "UTF-8"));
		params.put("state", state);

		String resp = WebUtils.doPost(tokenUri, params, "UTF-8", 8000, 8000);
		if (log.isDebugEnabled()) {
			log.debug("auth code resp: {}",  resp);
		}
		
		AuthDTO auth = JSONObject.parseObject(resp, AuthDTO.class);
		auth.setTaobaoUserNick(URLDecoder.decode(auth.getTaobaoUserNick(), "UTF-8"));
		
		// 授权信息信息处理
		AuthInfo info = authInfoService.getByTaobaoUserId(auth.getTaobaoUserId());
		Date now = new Date();
		if (info == null) {
			info = new AuthInfo();
			info.setCreateTime(now);
		}
		auth.copyProperties(info);

		info.setLastUpdateTime(now);
		authInfoService.save(info);
		
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
