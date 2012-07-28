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
     * Table:     user
     * Column:    id
     * Nullable:  false
     */
    private Integer id;

    /**
     * 登录名
     *
     * Table:     user
     * Column:    uid
     * Nullable:  true
     */
    private String uid;

    /**
     * 昵称
     *
     * Table:     user
     * Column:    nickname
     * Nullable:  true
     */
    private String nickname;

    /**
     * 邮箱
     *
     * Table:     user
     * Column:    email
     * Nullable:  true
     */
    private String email;

    /**
     * 来源(渠道) 如: 淘宝,新浪微博等
     *
     * Table:     user
     * Column:    from_channel
     * Nullable:  true
     */
    private String fromChannel;

    /**
     * 授权信息
     *
     * Table:     user
     * Column:    auth_id
     * Nullable:  true
     */
    private Long authId;

    /**
     * 授权用户id, 如淘宝 id
     *
     * Table:     user
     * Column:    auth_user_id
     * Nullable:  true
     */
    private String authUserId;

    /**
     * 登录密码
     *
     * Table:     user
     * Column:    pwd
     * Nullable:  true
     */
    private String pwd;

    /**
     * 盐值
     *
     * Table:     user
     * Column:    salt
     * Nullable:  true
     */
    private String salt;

    /**
     * Table:     user
     * Column:    id
     * Nullable:  false
     */
    public Integer getId() {
        return id;
    }

    /**
     * Table:     user
     * Column:    id
     * Nullable:  false
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 登录名
     *
     * Table:     user
     * Column:    uid
     * Nullable:  true
     */
    public String getUid() {
        return uid;
    }

    /**
     * 登录名
     *
     * Table:     user
     * Column:    uid
     * Nullable:  true
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 昵称
     *
     * Table:     user
     * Column:    nickname
     * Nullable:  true
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 昵称
     *
     * Table:     user
     * Column:    nickname
     * Nullable:  true
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 邮箱
     *
     * Table:     user
     * Column:    email
     * Nullable:  true
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     *
     * Table:     user
     * Column:    email
     * Nullable:  true
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 来源(渠道) 如: 淘宝,新浪微博等
     *
     * Table:     user
     * Column:    from_channel
     * Nullable:  true
     */
    public String getFromChannel() {
        return fromChannel;
    }

    /**
     * 来源(渠道) 如: 淘宝,新浪微博等
     *
     * Table:     user
     * Column:    from_channel
     * Nullable:  true
     */
    public void setFromChannel(String fromChannel) {
        this.fromChannel = fromChannel;
    }

    /**
     * 授权信息
     *
     * Table:     user
     * Column:    auth_id
     * Nullable:  true
     */
    public Long getAuthId() {
        return authId;
    }

    /**
     * 授权信息
     *
     * Table:     user
     * Column:    auth_id
     * Nullable:  true
     */
    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    /**
     * 授权用户id, 如淘宝 id
     *
     * Table:     user
     * Column:    auth_user_id
     * Nullable:  true
     */
    public String getAuthUserId() {
        return authUserId;
    }

    /**
     * 授权用户id, 如淘宝 id
     *
     * Table:     user
     * Column:    auth_user_id
     * Nullable:  true
     */
    public void setAuthUserId(String authUserId) {
        this.authUserId = authUserId;
    }

    /**
     * 登录密码
     *
     * Table:     user
     * Column:    pwd
     * Nullable:  true
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 登录密码
     *
     * Table:     user
     * Column:    pwd
     * Nullable:  true
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 盐值
     *
     * Table:     user
     * Column:    salt
     * Nullable:  true
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 盐值
     *
     * Table:     user
     * Column:    salt
     * Nullable:  true
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

}
