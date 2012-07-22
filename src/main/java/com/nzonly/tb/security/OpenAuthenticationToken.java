package com.nzonly.tb.security;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-21 下午3:29:08
 * @version V1.0
 */
public class OpenAuthenticationToken implements AuthenticationToken {
	
	private static final long serialVersionUID = 3203437080270072598L;

	private String loginName;
	
	public static final String EMPTY_PASS = "";
	
	/**
	 * TODO
	 * @param loginName
	 * @author yinheli
	 * @date 2012-7-21 下午3:30:11
	 */
	public OpenAuthenticationToken(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * getPrincipal 
	 * @see org.apache.shiro.authc.AuthenticationToken#getPrincipal()   
	 */
	@Override
	public Object getPrincipal() {
		return loginName;
	}

	/**
	 * getCredentials 
	 * @see org.apache.shiro.authc.AuthenticationToken#getCredentials()   
	 */
	@Override
	public Object getCredentials() {
		return EMPTY_PASS;
	}

}
