package com.nzonly.tb.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-21 下午1:41:18
 * @version V1.0
 */
public class AuthDTO extends BaseDTO {

	@JSONField(name = "access_token")
	private String accessToken;

	@JSONField(name = "token_type")
	private String tokenType;

	@JSONField(name = "expires_in")
	private Long expiresIn;

	@JSONField(name = "refresh_token")
	private String refreshToken;

	@JSONField(name = "re_expires_in")
	private Long reExpiresIn;

	@JSONField(name = "r1_expires_in")
	private Long r1ExpiresIn;

	@JSONField(name = "r2_expires_in")
	private Long r2ExpiresIn;

	@JSONField(name = "w1_expires_in")
	private Long w1ExpiresIn;

	@JSONField(name = "w2_expires_in")
	private Long w2ExpiresIn;

	@JSONField(name = "taobao_user_id")
	private String taobaoUserId;

	@JSONField(name = "taobao_user_nick")
	private String taobaoUserNick;

	/**
	 * get accessToken
	 * @return  accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken set accessToken
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * get tokenType
	 * @return  tokenType
	 */
	public String getTokenType() {
		return tokenType;
	}

	/**
	 * @param tokenType set tokenType
	 */
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	/**
	 * get expiresIn
	 * @return  expiresIn
	 */
	public Long getExpiresIn() {
		return expiresIn;
	}

	/**
	 * @param expiresIn set expiresIn
	 */
	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

	/**
	 * get refreshToken
	 * @return  refreshToken
	 */
	public String getRefreshToken() {
		return refreshToken;
	}

	/**
	 * @param refreshToken set refreshToken
	 */
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	/**
	 * get reExpiresIn
	 * @return  reExpiresIn
	 */
	public Long getReExpiresIn() {
		return reExpiresIn;
	}

	/**
	 * @param reExpiresIn set reExpiresIn
	 */
	public void setReExpiresIn(Long reExpiresIn) {
		this.reExpiresIn = reExpiresIn;
	}

	/**
	 * get r1ExpiresIn
	 * @return  r1ExpiresIn
	 */
	public Long getR1ExpiresIn() {
		return r1ExpiresIn;
	}

	/**
	 * @param r1ExpiresIn set r1ExpiresIn
	 */
	public void setR1ExpiresIn(Long r1ExpiresIn) {
		this.r1ExpiresIn = r1ExpiresIn;
	}

	/**
	 * get r2ExpiresIn
	 * @return  r2ExpiresIn
	 */
	public Long getR2ExpiresIn() {
		return r2ExpiresIn;
	}

	/**
	 * @param r2ExpiresIn set r2ExpiresIn
	 */
	public void setR2ExpiresIn(Long r2ExpiresIn) {
		this.r2ExpiresIn = r2ExpiresIn;
	}

	/**
	 * get w1ExpiresIn
	 * @return  w1ExpiresIn
	 */
	public Long getW1ExpiresIn() {
		return w1ExpiresIn;
	}

	/**
	 * @param w1ExpiresIn set w1ExpiresIn
	 */
	public void setW1ExpiresIn(Long w1ExpiresIn) {
		this.w1ExpiresIn = w1ExpiresIn;
	}

	/**
	 * get w2ExpiresIn
	 * @return  w2ExpiresIn
	 */
	public Long getW2ExpiresIn() {
		return w2ExpiresIn;
	}

	/**
	 * @param w2ExpiresIn set w2ExpiresIn
	 */
	public void setW2ExpiresIn(Long w2ExpiresIn) {
		this.w2ExpiresIn = w2ExpiresIn;
	}

	/**
	 * get taobaoUserId
	 * @return  taobaoUserId
	 */
	public String getTaobaoUserId() {
		return taobaoUserId;
	}

	/**
	 * @param taobaoUserId set taobaoUserId
	 */
	public void setTaobaoUserId(String taobaoUserId) {
		this.taobaoUserId = taobaoUserId;
	}

	/**
	 * get taobaoUserNick
	 * @return  taobaoUserNick
	 */
	public String getTaobaoUserNick() {
		return taobaoUserNick;
	}

	/**
	 * @param taobaoUserNick set taobaoUserNick
	 */
	public void setTaobaoUserNick(String taobaoUserNick) {
		this.taobaoUserNick = taobaoUserNick;
	}

}
