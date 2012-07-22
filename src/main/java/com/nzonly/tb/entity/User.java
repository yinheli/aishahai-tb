package com.nzonly.tb.entity;

/**
 * 系统用户
 * 
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-20 下午9:53:47
 * @version V1.0
 */
public class User extends BaseEntity {

	private static final long serialVersionUID = 1795083589235034286L;
	
	/**
	 * 
	 * Database column user.id
	 */
	private Integer id;

	/**
	 * 登录名
	 * Database column user.uid
	 */
	private String uid;

	/**
	 * 昵称
	 * Database column user.nickname
	 */
	private String nickname;

	/**
	 * 邮箱
	 * Database column user.email
	 */
	private String email;

	/**
	 * 来源(渠道) 如: 淘宝,新浪微博等
	 * Database column user.from_channel
	 */
	private String fromChannel;

	/**
	 * 授权信息
	 * Database column user.auth_id
	 */
	private Long authId;

	/**
	 * 授权用户id, 如淘宝 id
	 * Database column user.auth_user_id
	 */
	private String authUserId;

	/**
	 * 登录密码
	 * Database column user.pwd
	 */
	private String pwd;

	/**
	 * 盐值
	 * Database column user.salt
	 */
	private String salt;

	/**
	 * 
	 * This method returns the value of the database column user.id
	 *
	 * @return the value of user.id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * Database column user.id
	 *
	 * @param id the value for user.id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 登录名
	 * This method returns the value of the database column user.uid
	 *
	 * @return the value of user.uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * 登录名
	 * Database column user.uid
	 *
	 * @param uid the value for user.uid
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * 昵称
	 * This method returns the value of the database column user.nickname
	 *
	 * @return the value of user.nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * 昵称
	 * Database column user.nickname
	 *
	 * @param nickname the value for user.nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * 邮箱
	 * This method returns the value of the database column user.email
	 *
	 * @return the value of user.email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 邮箱
	 * Database column user.email
	 *
	 * @param email the value for user.email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 来源(渠道) 如: 淘宝,新浪微博等
	 * This method returns the value of the database column user.from_channel
	 *
	 * @return the value of user.from_channel
	 */
	public String getFromChannel() {
		return fromChannel;
	}

	/**
	 * 来源(渠道) 如: 淘宝,新浪微博等
	 * Database column user.from_channel
	 *
	 * @param fromChannel the value for user.from_channel
	 */
	public void setFromChannel(String fromChannel) {
		this.fromChannel = fromChannel;
	}

	/**
	 * 授权信息
	 * This method returns the value of the database column user.auth_id
	 *
	 * @return the value of user.auth_id
	 */
	public Long getAuthId() {
		return authId;
	}

	/**
	 * 授权信息
	 * Database column user.auth_id
	 *
	 * @param authId the value for user.auth_id
	 */
	public void setAuthId(Long authId) {
		this.authId = authId;
	}

	/**
	 * 授权用户id, 如淘宝 id
	 * This method returns the value of the database column user.auth_user_id
	 *
	 * @return the value of user.auth_user_id
	 */
	public String getAuthUserId() {
		return authUserId;
	}

	/**
	 * 授权用户id, 如淘宝 id
	 * Database column user.auth_user_id
	 *
	 * @param authUserId the value for user.auth_user_id
	 */
	public void setAuthUserId(String authUserId) {
		this.authUserId = authUserId;
	}

	/**
	 * 登录密码
	 * This method returns the value of the database column user.pwd
	 *
	 * @return the value of user.pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * 登录密码
	 * Database column user.pwd
	 *
	 * @param pwd the value for user.pwd
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * 盐值
	 * This method returns the value of the database column user.salt
	 *
	 * @return the value of user.salt
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * 盐值
	 * Database column user.salt
	 *
	 * @param salt the value for user.salt
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

}
