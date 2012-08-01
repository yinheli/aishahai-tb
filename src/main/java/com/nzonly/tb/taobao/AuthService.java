package com.nzonly.tb.taobao;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.nzonly.tb.dto.AuthDTO;
import com.nzonly.tb.entity.AuthInfo;
import com.nzonly.tb.service.AuthInfoService;
import com.taobao.api.internal.util.WebUtils;

/**
 * 淘宝授权工具
 * 
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-8-1 上午12:07:20
 * @version V1.0
 */
@Component
public class AuthService extends TaobaoService {
	
	@Value("${app.token_uri}")
	private String tokenUri;

	@Value("${app.success_callback}")
	private String redirectUri;
	
	@Autowired
	private AuthInfoService authInfoService;
	
	public AuthInfo auth(String code, String state) throws IOException {
		
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
		
		return info;
		
	}
	
	/**
	 * 刷新 TOKEN
	 * 
	 * 一般被定时服务调用
	 * 
	 * @author yinheli
	 * @throws IOException 
	 * @date 2012-8-1 上午12:07:55
	 */
	public void refreshToken(AuthInfo info) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("client_id", appKey);
		params.put("client_secret", appSecret);
		params.put("grant_type", "refresh_token");
		params.put("refresh_token", info.getRefreshToken());
		
		if (log.isDebugEnabled()) {
			log.debug("Refresh token URI: {}", tokenUri);
			log.debug("Refresh token param: {}", params);
		}
		
		String resp = WebUtils.doPost(tokenUri, params, "UTF-8", 8000, 8000);
		if (log.isDebugEnabled()) {
			log.debug("refresh_token resp: {}",  resp);
		}
		
		AuthDTO auth = JSONObject.parseObject(resp, AuthDTO.class);
		auth.setTaobaoUserNick(URLDecoder.decode(auth.getTaobaoUserNick(), "UTF-8"));
		
		auth.copyProperties(info);
		info.setLastUpdateTime(new Date());
		authInfoService.save(info);
	}

}
