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
	 *
	 * Table:     auth_info
	 * Column:    id
	 * Nullable:  false
	 */
	private Long id;

	/**
	 * 淘宝用户 id
	 *
	 * Table:     auth_info
	 * Column:    taobao_user_id
	 * Nullable:  true
	 */
	private String taobaoUserId;

	/**
	 * 淘宝用户昵称
	 *
	 * Table:     auth_info
	 * Column:    taobao_user_nick
	 * Nullable:  true
	 */
	private String taobaoUserNick;

	/**
	 * Access token
	 *
	 * Table:     auth_info
	 * Column:    access_token
	 * Nullable:  true
	 */
	private String accessToken;

	/**
	 * Access token的类型目前只支持bearer
	 *
	 * Table:     auth_info
	 * Column:    token_type
	 * Nullable:  true
	 */
	private String tokenType;

	/**
	 * Access token过期时间 单位秒
	 *
	 * Table:     auth_info
	 * Column:    expires_in
	 * Nullable:  true
	 */
	private Long expiresIn;

	/**
	 * Refresh token
	 *
	 * Table:     auth_info
	 * Column:    refresh_token
	 * Nullable:  true
	 */
	private String refreshToken;

	/**
	 * Refresh token过期时间 单位秒
	 *
	 * Table:     auth_info
	 * Column:    re_expires_in
	 * Nullable:  true
	 */
	private Long reExpiresIn;

	/**
	 * r1级别API或字段的访问过期时间
	 *
	 * Table:     auth_info
	 * Column:    r1_expires_in
	 * Nullable:  true
	 */
	private Long r1ExpiresIn;

	/**
	 * r2级别API或字段的访问过期时间
	 *
	 * Table:     auth_info
	 * Column:    r2_expires_in
	 * Nullable:  true
	 */
	private Long r2ExpiresIn;

	/**
	 * w1级别API或字段的访问过期时间
	 *
	 * Table:     auth_info
	 * Column:    w1_expires_in
	 * Nullable:  true
	 */
	private Long w1ExpiresIn;

	/**
	 * w2级别API或字段的访问过期时间
	 *
	 * Table:     auth_info
	 * Column:    w2_expires_in
	 * Nullable:  true
	 */
	private Long w2ExpiresIn;

	/**
	 * w2级别API或字段的访问过期时间
	 *
	 * Table:     auth_info
	 * Column:    create_time
	 * Nullable:  true
	 */
	private Date createTime;

	/**
	 * 最近一次更新时间
	 *
	 * Table:     auth_info
	 * Column:    last_update_time
	 * Nullable:  true
	 */
	private Date lastUpdateTime;

	/**
	 * 上次授权, IP地址
	 *
	 * Table:     auth_info
	 * Column:    last_auth_ip
	 * Nullable:  true
	 */
	private String lastAuthIp;

	/**
	 * 主键
	 *
	 * Table:     auth_info
	 * Column:    id
	 * Nullable:  false
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 主键
	 *
	 * Table:     auth_info
	 * Column:    id
	 * Nullable:  false
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 淘宝用户 id
	 *
	 * Table:     auth_info
	 * Column:    taobao_user_id
	 * Nullable:  true
	 */
	public String getTaobaoUserId() {
		return taobaoUserId;
	}

	/**
	 * 淘宝用户 id
	 *
	 * Table:     auth_info
	 * Column:    taobao_user_id
	 * Nullable:  true
	 */
	public void setTaobaoUserId(String taobaoUserId) {
		this.taobaoUserId = taobaoUserId;
	}

	/**
	 * 淘宝用户昵称
	 *
	 * Table:     auth_info
	 * Column:    taobao_user_nick
	 * Nullable:  true
	 */
	public String getTaobaoUserNick() {
		return taobaoUserNick;
	}

	/**
	 * 淘宝用户昵称
	 *
	 * Table:     auth_info
	 * Column:    taobao_user_nick
	 * Nullable:  true
	 */
	public void setTaobaoUserNick(String taobaoUserNick) {
		this.taobaoUserNick = taobaoUserNick;
	}

	/**
	 * Access token
	 *
	 * Table:     auth_info
	 * Column:    access_token
	 * Nullable:  true
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * Access token
	 *
	 * Table:     auth_info
	 * Column:    access_token
	 * Nullable:  true
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * Access token的类型目前只支持bearer
	 *
	 * Table:     auth_info
	 * Column:    token_type
	 * Nullable:  true
	 */
	public String getTokenType() {
		return tokenType;
	}

	/**
	 * Access token的类型目前只支持bearer
	 *
	 * Table:     auth_info
	 * Column:    token_type
	 * Nullable:  true
	 */
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	/**
	 * Access token过期时间 单位秒
	 *
	 * Table:     auth_info
	 * Column:    expires_in
	 * Nullable:  true
	 */
	public Long getExpiresIn() {
		return expiresIn;
	}

	/**
	 * Access token过期时间 单位秒
	 *
	 * Table:     auth_info
	 * Column:    expires_in
	 * Nullable:  true
	 */
	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

	/**
	 * Refresh token
	 *
	 * Table:     auth_info
	 * Column:    refresh_token
	 * Nullable:  true
	 */
	public String getRefreshToken() {
		return refreshToken;
	}

	/**
	 * Refresh token
	 *
	 * Table:     auth_info
	 * Column:    refresh_token
	 * Nullable:  true
	 */
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	/**
	 * Refresh token过期时间 单位秒
	 *
	 * Table:     auth_info
	 * Column:    re_expires_in
	 * Nullable:  true
	 */
	public Long getReExpiresIn() {
		return reExpiresIn;
	}

	/**
	 * Refresh token过期时间 单位秒
	 *
	 * Table:     auth_info
	 * Column:    re_expires_in
	 * Nullable:  true
	 */
	public void setReExpiresIn(Long reExpiresIn) {
		this.reExpiresIn = reExpiresIn;
	}

	/**
	 * r1级别API或字段的访问过期时间
	 *
	 * Table:     auth_info
	 * Column:    r1_expires_in
	 * Nullable:  true
	 */
	public Long getR1ExpiresIn() {
		return r1ExpiresIn;
	}

	/**
	 * r1级别API或字段的访问过期时间
	 *
	 * Table:     auth_info
	 * Column:    r1_expires_in
	 * Nullable:  true
	 */
	public void setR1ExpiresIn(Long r1ExpiresIn) {
		this.r1ExpiresIn = r1ExpiresIn;
	}

	/**
	 * r2级别API或字段的访问过期时间
	 *
	 * Table:     auth_info
	 * Column:    r2_expires_in
	 * Nullable:  true
	 */
	public Long getR2ExpiresIn() {
		return r2ExpiresIn;
	}

	/**
	 * r2级别API或字段的访问过期时间
	 *
	 * Table:     auth_info
	 * Column:    r2_expires_in
	 * Nullable:  true
	 */
	public void setR2ExpiresIn(Long r2ExpiresIn) {
		this.r2ExpiresIn = r2ExpiresIn;
	}

	/**
	 * w1级别API或字段的访问过期时间
	 *
	 * Table:     auth_info
	 * Column:    w1_expires_in
	 * Nullable:  true
	 */
	public Long getW1ExpiresIn() {
		return w1ExpiresIn;
	}

	/**
	 * w1级别API或字段的访问过期时间
	 *
	 * Table:     auth_info
	 * Column:    w1_expires_in
	 * Nullable:  true
	 */
	public void setW1ExpiresIn(Long w1ExpiresIn) {
		this.w1ExpiresIn = w1ExpiresIn;
	}

	/**
	 * w2级别API或字段的访问过期时间
	 *
	 * Table:     auth_info
	 * Column:    w2_expires_in
	 * Nullable:  true
	 */
	public Long getW2ExpiresIn() {
		return w2ExpiresIn;
	}

	/**
	 * w2级别API或字段的访问过期时间
	 *
	 * Table:     auth_info
	 * Column:    w2_expires_in
	 * Nullable:  true
	 */
	public void setW2ExpiresIn(Long w2ExpiresIn) {
		this.w2ExpiresIn = w2ExpiresIn;
	}

	/**
	 * w2级别API或字段的访问过期时间
	 *
	 * Table:     auth_info
	 * Column:    create_time
	 * Nullable:  true
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * w2级别API或字段的访问过期时间
	 *
	 * Table:     auth_info
	 * Column:    create_time
	 * Nullable:  true
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 最近一次更新时间
	 *
	 * Table:     auth_info
	 * Column:    last_update_time
	 * Nullable:  true
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 * 最近一次更新时间
	 *
	 * Table:     auth_info
	 * Column:    last_update_time
	 * Nullable:  true
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * 上次授权, IP地址
	 *
	 * Table:     auth_info
	 * Column:    last_auth_ip
	 * Nullable:  true
	 */
	public String getLastAuthIp() {
		return lastAuthIp;
	}

	/**
	 * 上次授权, IP地址
	 *
	 * Table:     auth_info
	 * Column:    last_auth_ip
	 * Nullable:  true
	 */
	public void setLastAuthIp(String lastAuthIp) {
		this.lastAuthIp = lastAuthIp;
	}

}
