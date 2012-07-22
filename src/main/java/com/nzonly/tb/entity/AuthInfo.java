package com.nzonly.tb.entity;

import java.util.Date;

/**
 * 授权信息
 * 
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-20 下午9:49:35
 * @version V1.0
 */
public class AuthInfo extends BaseEntity {

	private static final long serialVersionUID = -4966597915254195763L;

	/**
	 * 主键
	 * Database column auth_info.id
	 */
	private Long id;

	/**
	 * 淘宝用户 id
	 * Database column auth_info.taobao_user_id
	 */
	private String taobaoUserId;

	/**
	 * 淘宝用户昵称
	 * Database column auth_info.taobao_user_nick
	 */
	private String taobaoUserNick;

	/**
	 * Access token
	 * Database column auth_info.access_token
	 */
	private String accessToken;

	/**
	 * Access token的类型目前只支持bearer
	 * Database column auth_info.token_type
	 */
	private String tokenType;

	/**
	 * Access token过期时间 单位秒
	 * Database column auth_info.expires_in
	 */
	private Long expiresIn;

	/**
	 * Refresh token
	 * Database column auth_info.refresh_token
	 */
	private String refreshToken;

	/**
	 * Refresh token过期时间 单位秒
	 * Database column auth_info.re_expires_in
	 */
	private Long reExpiresIn;

	/**
	 * r1级别API或字段的访问过期时间
	 * Database column auth_info.r1_expires_in
	 */
	private Long r1ExpiresIn;

	/**
	 * r2级别API或字段的访问过期时间
	 * Database column auth_info.r2_expires_in
	 */
	private Long r2ExpiresIn;

	/**
	 * w1级别API或字段的访问过期时间
	 * Database column auth_info.w1_expires_in
	 */
	private Long w1ExpiresIn;

	/**
	 * w2级别API或字段的访问过期时间
	 * Database column auth_info.w2_expires_in
	 */
	private Long w2ExpiresIn;

	/**
	 * w2级别API或字段的访问过期时间
	 * Database column auth_info.create_time
	 */
	private Date createTime;

	/**
	 * w2级别API或字段的访问过期时间
	 * Database column auth_info.last_update_time
	 */
	private Date lastUpdateTime;

	/**
	 * 主键
	 * This method returns the value of the database column auth_info.id
	 *
	 * @return the value of auth_info.id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 主键
	 * Database column auth_info.id
	 *
	 * @param id the value for auth_info.id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 淘宝用户 id
	 * This method returns the value of the database column auth_info.taobao_user_id
	 *
	 * @return the value of auth_info.taobao_user_id
	 */
	public String getTaobaoUserId() {
		return taobaoUserId;
	}

	/**
	 * 淘宝用户 id
	 * Database column auth_info.taobao_user_id
	 *
	 * @param taobaoUserId the value for auth_info.taobao_user_id
	 */
	public void setTaobaoUserId(String taobaoUserId) {
		this.taobaoUserId = taobaoUserId;
	}

	/**
	 * 淘宝用户昵称
	 * This method returns the value of the database column auth_info.taobao_user_nick
	 *
	 * @return the value of auth_info.taobao_user_nick
	 */
	public String getTaobaoUserNick() {
		return taobaoUserNick;
	}

	/**
	 * 淘宝用户昵称
	 * Database column auth_info.taobao_user_nick
	 *
	 * @param taobaoUserNick the value for auth_info.taobao_user_nick
	 */
	public void setTaobaoUserNick(String taobaoUserNick) {
		this.taobaoUserNick = taobaoUserNick;
	}

	/**
	 * Access token
	 * This method returns the value of the database column auth_info.access_token
	 *
	 * @return the value of auth_info.access_token
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * Access token
	 * Database column auth_info.access_token
	 *
	 * @param accessToken the value for auth_info.access_token
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * Access token的类型目前只支持bearer
	 * This method returns the value of the database column auth_info.token_type
	 *
	 * @return the value of auth_info.token_type
	 */
	public String getTokenType() {
		return tokenType;
	}

	/**
	 * Access token的类型目前只支持bearer
	 * Database column auth_info.token_type
	 *
	 * @param tokenType the value for auth_info.token_type
	 */
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	/**
	 * Access token过期时间 单位秒
	 * This method returns the value of the database column auth_info.expires_in
	 *
	 * @return the value of auth_info.expires_in
	 */
	public Long getExpiresIn() {
		return expiresIn;
	}

	/**
	 * Access token过期时间 单位秒
	 * Database column auth_info.expires_in
	 *
	 * @param expiresIn the value for auth_info.expires_in
	 */
	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

	/**
	 * Refresh token
	 * This method returns the value of the database column auth_info.refresh_token
	 *
	 * @return the value of auth_info.refresh_token
	 */
	public String getRefreshToken() {
		return refreshToken;
	}

	/**
	 * Refresh token
	 * Database column auth_info.refresh_token
	 *
	 * @param refreshToken the value for auth_info.refresh_token
	 */
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	/**
	 * Refresh token过期时间 单位秒
	 * This method returns the value of the database column auth_info.re_expires_in
	 *
	 * @return the value of auth_info.re_expires_in
	 */
	public Long getReExpiresIn() {
		return reExpiresIn;
	}

	/**
	 * Refresh token过期时间 单位秒
	 * Database column auth_info.re_expires_in
	 *
	 * @param reExpiresIn the value for auth_info.re_expires_in
	 */
	public void setReExpiresIn(Long reExpiresIn) {
		this.reExpiresIn = reExpiresIn;
	}

	/**
	 * r1级别API或字段的访问过期时间
	 * This method returns the value of the database column auth_info.r1_expires_in
	 *
	 * @return the value of auth_info.r1_expires_in
	 */
	public Long getR1ExpiresIn() {
		return r1ExpiresIn;
	}

	/**
	 * r1级别API或字段的访问过期时间
	 * Database column auth_info.r1_expires_in
	 *
	 * @param r1ExpiresIn the value for auth_info.r1_expires_in
	 */
	public void setR1ExpiresIn(Long r1ExpiresIn) {
		this.r1ExpiresIn = r1ExpiresIn;
	}

	/**
	 * r2级别API或字段的访问过期时间
	 * This method returns the value of the database column auth_info.r2_expires_in
	 *
	 * @return the value of auth_info.r2_expires_in
	 */
	public Long getR2ExpiresIn() {
		return r2ExpiresIn;
	}

	/**
	 * r2级别API或字段的访问过期时间
	 * Database column auth_info.r2_expires_in
	 *
	 * @param r2ExpiresIn the value for auth_info.r2_expires_in
	 */
	public void setR2ExpiresIn(Long r2ExpiresIn) {
		this.r2ExpiresIn = r2ExpiresIn;
	}

	/**
	 * w1级别API或字段的访问过期时间
	 * This method returns the value of the database column auth_info.w1_expires_in
	 *
	 * @return the value of auth_info.w1_expires_in
	 */
	public Long getW1ExpiresIn() {
		return w1ExpiresIn;
	}

	/**
	 * w1级别API或字段的访问过期时间
	 * Database column auth_info.w1_expires_in
	 *
	 * @param w1ExpiresIn the value for auth_info.w1_expires_in
	 */
	public void setW1ExpiresIn(Long w1ExpiresIn) {
		this.w1ExpiresIn = w1ExpiresIn;
	}

	/**
	 * w2级别API或字段的访问过期时间
	 * This method returns the value of the database column auth_info.w2_expires_in
	 *
	 * @return the value of auth_info.w2_expires_in
	 */
	public Long getW2ExpiresIn() {
		return w2ExpiresIn;
	}

	/**
	 * w2级别API或字段的访问过期时间
	 * Database column auth_info.w2_expires_in
	 *
	 * @param w2ExpiresIn the value for auth_info.w2_expires_in
	 */
	public void setW2ExpiresIn(Long w2ExpiresIn) {
		this.w2ExpiresIn = w2ExpiresIn;
	}

	/**
	 * w2级别API或字段的访问过期时间
	 * This method returns the value of the database column auth_info.create_time
	 *
	 * @return the value of auth_info.create_time
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * w2级别API或字段的访问过期时间
	 * Database column auth_info.create_time
	 *
	 * @param createTime the value for auth_info.create_time
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * w2级别API或字段的访问过期时间
	 * This method returns the value of the database column auth_info.last_update_time
	 *
	 * @return the value of auth_info.last_update_time
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 * w2级别API或字段的访问过期时间
	 * Database column auth_info.last_update_time
	 *
	 * @param lastUpdateTime the value for auth_info.last_update_time
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}
