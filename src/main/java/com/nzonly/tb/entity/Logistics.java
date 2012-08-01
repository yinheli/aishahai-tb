package com.nzonly.tb.entity;

import java.util.Date;

/**
 * 物流信息
 * 
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-8-1 下午11:06:42
 * @version V1.0
 */
public class Logistics extends BaseEntity {

	private static final long serialVersionUID = -6301244285599908635L;
	/**
	 * 交易ID
	 *
	 * Table:     logistics
	 * Column:    tid
	 * Nullable:  false
	 */
	private Long tid;

	/**
	 * 买家昵称
	 *
	 * Table:     logistics
	 * Column:    buyer_nick
	 * Nullable:  true
	 */
	private String buyerNick;

	/**
	 * 收件人姓名
	 *
	 * Table:     logistics
	 * Column:    receiver_name
	 * Nullable:  true
	 */
	private String receiverName;

	/**
	 * 收件人电话
	 *
	 * Table:     logistics
	 * Column:    receiver_phone
	 * Nullable:  true
	 */
	private String receiverPhone;

	/**
	 * 收件人手机号码
	 *
	 * Table:     logistics
	 * Column:    receiver_mobile
	 * Nullable:  true
	 */
	private String receiverMobile;

	/**
	 * 物流公司名称
	 *
	 * Table:     logistics
	 * Column:    company_name
	 * Nullable:  true
	 */
	private String companyName;

	/**
	 * 运单号.具体一个物流公司的运单号码.
	 *
	 * Table:     logistics
	 * Column:    out_sid
	 * Nullable:  true
	 */
	private String outSid;

	/**
	 * 运单创建时间
	 *
	 * Table:     logistics
	 * Column:    created
	 * Nullable:  true
	 */
	private Date created;

	/**
	 * 货物名称
	 *
	 * Table:     logistics
	 * Column:    item_title
	 * Nullable:  true
	 */
	private String itemTitle;

	/**
	 * 物流跟踪信息
	 *
	 * Table:     logistics
	 * Column:    trace
	 * Nullable:  true
	 */
	private String trace;

	/**
	 * 本地记录创建时间
	 *
	 * Table:     logistics
	 * Column:    create_time
	 * Nullable:  true
	 */
	private Date createTime;

	/**
	 * 本地记录最后更新时间
	 *
	 * Table:     logistics
	 * Column:    last_update_time
	 * Nullable:  true
	 */
	private Date lastUpdateTime;

	/**
	 * 本地备注信息
	 *
	 * Table:     logistics
	 * Column:    note
	 * Nullable:  true
	 */
	private String note;

	/**
	 * 交易ID
	 *
	 * Table:     logistics
	 * Column:    tid
	 * Nullable:  false
	 */
	public Long getTid() {
		return tid;
	}

	/**
	 * 交易ID
	 *
	 * Table:     logistics
	 * Column:    tid
	 * Nullable:  false
	 */
	public void setTid(Long tid) {
		this.tid = tid;
	}

	/**
	 * 买家昵称
	 *
	 * Table:     logistics
	 * Column:    buyer_nick
	 * Nullable:  true
	 */
	public String getBuyerNick() {
		return buyerNick;
	}

	/**
	 * 买家昵称
	 *
	 * Table:     logistics
	 * Column:    buyer_nick
	 * Nullable:  true
	 */
	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}

	/**
	 * 收件人姓名
	 *
	 * Table:     logistics
	 * Column:    receiver_name
	 * Nullable:  true
	 */
	public String getReceiverName() {
		return receiverName;
	}

	/**
	 * 收件人姓名
	 *
	 * Table:     logistics
	 * Column:    receiver_name
	 * Nullable:  true
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	/**
	 * 收件人电话
	 *
	 * Table:     logistics
	 * Column:    receiver_phone
	 * Nullable:  true
	 */
	public String getReceiverPhone() {
		return receiverPhone;
	}

	/**
	 * 收件人电话
	 *
	 * Table:     logistics
	 * Column:    receiver_phone
	 * Nullable:  true
	 */
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	/**
	 * 收件人手机号码
	 *
	 * Table:     logistics
	 * Column:    receiver_mobile
	 * Nullable:  true
	 */
	public String getReceiverMobile() {
		return receiverMobile;
	}

	/**
	 * 收件人手机号码
	 *
	 * Table:     logistics
	 * Column:    receiver_mobile
	 * Nullable:  true
	 */
	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	/**
	 * 物流公司名称
	 *
	 * Table:     logistics
	 * Column:    company_name
	 * Nullable:  true
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 物流公司名称
	 *
	 * Table:     logistics
	 * Column:    company_name
	 * Nullable:  true
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 运单号.具体一个物流公司的运单号码.
	 *
	 * Table:     logistics
	 * Column:    out_sid
	 * Nullable:  true
	 */
	public String getOutSid() {
		return outSid;
	}

	/**
	 * 运单号.具体一个物流公司的运单号码.
	 *
	 * Table:     logistics
	 * Column:    out_sid
	 * Nullable:  true
	 */
	public void setOutSid(String outSid) {
		this.outSid = outSid;
	}

	/**
	 * 运单创建时间
	 *
	 * Table:     logistics
	 * Column:    created
	 * Nullable:  true
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * 运单创建时间
	 *
	 * Table:     logistics
	 * Column:    created
	 * Nullable:  true
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * 货物名称
	 *
	 * Table:     logistics
	 * Column:    item_title
	 * Nullable:  true
	 */
	public String getItemTitle() {
		return itemTitle;
	}

	/**
	 * 货物名称
	 *
	 * Table:     logistics
	 * Column:    item_title
	 * Nullable:  true
	 */
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	/**
	 * 物流跟踪信息
	 *
	 * Table:     logistics
	 * Column:    trace
	 * Nullable:  true
	 */
	public String getTrace() {
		return trace;
	}

	/**
	 * 物流跟踪信息
	 *
	 * Table:     logistics
	 * Column:    trace
	 * Nullable:  true
	 */
	public void setTrace(String trace) {
		this.trace = trace;
	}

	/**
	 * 本地记录创建时间
	 *
	 * Table:     logistics
	 * Column:    create_time
	 * Nullable:  true
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 本地记录创建时间
	 *
	 * Table:     logistics
	 * Column:    create_time
	 * Nullable:  true
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 本地记录最后更新时间
	 *
	 * Table:     logistics
	 * Column:    last_update_time
	 * Nullable:  true
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 * 本地记录最后更新时间
	 *
	 * Table:     logistics
	 * Column:    last_update_time
	 * Nullable:  true
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * 本地备注信息
	 *
	 * Table:     logistics
	 * Column:    note
	 * Nullable:  true
	 */
	public String getNote() {
		return note;
	}

	/**
	 * 本地备注信息
	 *
	 * Table:     logistics
	 * Column:    note
	 * Nullable:  true
	 */
	public void setNote(String note) {
		this.note = note;
	}

}
