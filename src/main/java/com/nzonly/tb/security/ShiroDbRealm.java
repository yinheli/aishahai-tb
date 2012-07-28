package com.nzonly.tb.security;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nzonly.tb.entity.User;
import com.nzonly.tb.service.UserService;
import com.nzonly.tb.util.Digests;
import com.nzonly.tb.util.Encodes;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-20 下午10:29:45
 * @version V1.0
 */
@Component
public class ShiroDbRealm extends AuthorizingRealm {
	
	private static final int INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;
	private static final String ALGORITHM = "SHA-1";
	
	@Autowired
	private UserService userService;

	/**
	 * doGetAuthorizationInfo 
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)   
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		return null;
	}

	/**
	 * doGetAuthenticationInfo 
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)   
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		if (token.getPrincipal() == null) return null;
		
		User user = userService.getByUid((String) token.getPrincipal());
		if (user == null) {
			return null;
		}
		
		if (token instanceof OpenAuthenticationToken) {
			HashPassword pass = encrypt(OpenAuthenticationToken.EMPTY_PASS);
			byte[] salt = Encodes.decodeHex(pass.salt);
			return new SimpleAuthenticationInfo(new ShiroUser(user.getUid(), user.getNickname(), user.getAuthId()), pass.password,
					ByteSource.Util.bytes(salt), getName());
		} else {
			byte[] salt = Encodes.decodeHex(user.getSalt());
			return new SimpleAuthenticationInfo(new ShiroUser(user.getUid(), user.getNickname(), user.getAuthId()), user.getPwd(),
					ByteSource.Util.bytes(salt), getName());
		}
	}
	
	/**
	 * @see org.apache.shiro.realm.AuthenticatingRealm#supports(org.apache.shiro.authc.AuthenticationToken)   
	 */
	@Override
	public boolean supports(AuthenticationToken token) {
		return super.supports(token) || token instanceof OpenAuthenticationToken;
	}
	
	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(new ShiroUser(principal, null, null), getName());
		clearCachedAuthorizationInfo(principals);
	}
	
	public static HashPassword encrypt(String plainText) {
		HashPassword result = new HashPassword();
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		result.salt = Encodes.encodeHex(salt);

		byte[] hashPassword = Digests.sha1(plainText.getBytes(), salt, INTERATIONS);
		result.password = Encodes.encodeHex(hashPassword);
		return result;

	}

	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(ALGORITHM);
		matcher.setHashIterations(INTERATIONS);
		setCredentialsMatcher(matcher);
	}

	public static class HashPassword {
		public String salt;
		public String password;
	}

	public static class ShiroUser implements Serializable {
		private static final long serialVersionUID = -1373760761780840081L;
		public String loginName;
		public String name;
		public Long authId;

		public ShiroUser(String loginName, String name, Long authId) {
			this.loginName = loginName;
			this.name = name;
			this.authId = authId;
		}

		public String getName() {
			return name;
		}

		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString() {
			return loginName;
		}

	}

}
