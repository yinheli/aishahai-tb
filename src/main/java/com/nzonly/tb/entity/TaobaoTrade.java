package com.nzonly.tb.entity;

import java.util.Date;

/**
 * 订单信息
 * 
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-20 下午9:52:25
 * @version V1.0
 */
public class TaobaoTrade extends BaseEntity {

	private static final long serialVersionUID = -6260772131747681081L;

	/**
	 * 主键
	 *
	 * Table:     taobao_trade
	 * Column:    id
	 * Nullable:  false
	 */
	private Long id;

	/**
	 * 淘宝订单信息
	 *
	 * Table:     taobao_trade
	 * Column:    tid
	 * Nullable:  true
	 */
	private Long tid;

	/**
	 * 授权信息id
	 *
	 * Table:     taobao_trade
	 * Column:    auth_id
	 * Nullable:  true
	 */
	private Long authId;

	/**
	 * 运单号
	 *
	 * Table:     taobao_trade
	 * Column:    out_sid
	 * Nullable:  true
	 */
	private String outSid;

	/**
	 * 物流公司
	 *
	 * Table:     taobao_trade
	 * Column:    company_name
	 * Nullable:  true
	 */
	private String companyName;

	/**
	 * 物流信息状态, 订单的物流状态 * 等候发送给物流公司 *已提交给物流公司,等待物流公司接单 *已经确认消息接收，等待物流公司接单 *物流公司已接单 *物流公司不接单 *物流公司揽收失败 *物流公司揽收成功 *签收失败 *对方已签收 *对方拒绝签收
	 *
	 * Table:     taobao_trade
	 * Column:    out_status
	 * Nullable:  true
	 */
	private String outStatus;

	/**
	 * 买家昵称
	 *
	 * Table:     taobao_trade
	 * Column:    buyer_nick
	 * Nullable:  true
	 */
	private String buyerNick;

	/**
	 * 买家支付宝账号
	 *
	 * Table:     taobao_trade
	 * Column:    buyer_alipay_no
	 * Nullable:  true
	 */
	private String buyerAlipayNo;

	/**
	 * 支付金额
	 *
	 * Table:     taobao_trade
	 * Column:    payment
	 * Nullable:  true
	 */
	private Double payment;

	/**
	 * 物流信息跟踪
	 *
	 * Table:     taobao_trade
	 * Column:    delivery_track
	 * Nullable:  true
	 */
	private String deliveryTrack;

	/**
	 * 业务处理时间
	 *
	 * Table:     taobao_trade
	 * Column:    last_update_time
	 * Nullable:  true
	 */
	private Date lastUpdateTime;

	/**
	 * 备注(本地, 不是淘宝提供的)
	 *
	 * Table:     taobao_trade
	 * Column:    note
	 * Nullable:  true
	 */
	private String note;

	/**
	 * 订单详细, JSON 格式
	 *
	 * Table:     taobao_trade
	 * Column:    orders
	 * Nullable:  true
	 */
	private String orders;

	/**
	 * 主键
	 *
	 * Table:     taobao_trade
	 * Column:    id
	 * Nullable:  false
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 主键
	 *
	 * Table:     taobao_trade
	 * Column:    id
	 * Nullable:  false
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 淘宝订单信息
	 *
	 * Table:     taobao_trade
	 * Column:    tid
	 * Nullable:  true
	 */
	public Long getTid() {
		return tid;
	}

	/**
	 * 淘宝订单信息
	 *
	 * Table:     taobao_trade
	 * Column:    tid
	 * Nullable:  true
	 */
	public void setTid(Long tid) {
		this.tid = tid;
	}

	/**
	 * 授权信息id
	 *
	 * Table:     taobao_trade
	 * Column:    auth_id
	 * Nullable:  true
	 */
	public Long getAuthId() {
		return authId;
	}

	/**
	 * 授权信息id
	 *
	 * Table:     taobao_trade
	 * Column:    auth_id
	 * Nullable:  true
	 */
	public void setAuthId(Long authId) {
		this.authId = authId;
	}

	/**
	 * 运单号
	 *
	 * Table:     taobao_trade
	 * Column:    out_sid
	 * Nullable:  true
	 */
	public String getOutSid() {
		return outSid;
	}

	/**
	 * 运单号
	 *
	 * Table:     taobao_trade
	 * Column:    out_sid
	 * Nullable:  true
	 */
	public void setOutSid(String outSid) {
		this.outSid = outSid;
	}

	/**
	 * 物流公司
	 *
	 * Table:     taobao_trade
	 * Column:    company_name
	 * Nullable:  true
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 物流公司
	 *
	 * Table:     taobao_trade
	 * Column:    company_name
	 * Nullable:  true
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 物流信息状态, 订单的物流状态 * 等候发送给物流公司 *已提交给物流公司,等待物流公司接单 *已经确认消息接收，等待物流公司接单 *物流公司已接单 *物流公司不接单 *物流公司揽收失败 *物流公司揽收成功 *签收失败 *对方已签收 *对方拒绝签收
	 *
	 * Table:     taobao_trade
	 * Column:    out_status
	 * Nullable:  true
	 */
	public String getOutStatus() {
		return outStatus;
	}

	/**
	 * 物流信息状态, 订单的物流状态 * 等候发送给物流公司 *已提交给物流公司,等待物流公司接单 *已经确认消息接收，等待物流公司接单 *物流公司已接单 *物流公司不接单 *物流公司揽收失败 *物流公司揽收成功 *签收失败 *对方已签收 *对方拒绝签收
	 *
	 * Table:     taobao_trade
	 * Column:    out_status
	 * Nullable:  true
	 */
	public void setOutStatus(String outStatus) {
		this.outStatus = outStatus;
	}

	/**
	 * 买家昵称
	 *
	 * Table:     taobao_trade
	 * Column:    buyer_nick
	 * Nullable:  true
	 */
	public String getBuyerNick() {
		return buyerNick;
	}

	/**
	 * 买家昵称
	 *
	 * Table:     taobao_trade
	 * Column:    buyer_nick
	 * Nullable:  true
	 */
	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}

	/**
	 * 买家支付宝账号
	 *
	 * Table:     taobao_trade
	 * Column:    buyer_alipay_no
	 * Nullable:  true
	 */
	public String getBuyerAlipayNo() {
		return buyerAlipayNo;
	}

	/**
	 * 买家支付宝账号
	 *
	 * Table:     taobao_trade
	 * Column:    buyer_alipay_no
	 * Nullable:  true
	 */
	public void setBuyerAlipayNo(String buyerAlipayNo) {
		this.buyerAlipayNo = buyerAlipayNo;
	}

	/**
	 * 支付金额
	 *
	 * Table:     taobao_trade
	 * Column:    payment
	 * Nullable:  true
	 */
	public Double getPayment() {
		return payment;
	}

	/**
	 * 支付金额
	 *
	 * Table:     taobao_trade
	 * Column:    payment
	 * Nullable:  true
	 */
	public void setPayment(Double payment) {
		this.payment = payment;
	}

	/**
	 * 物流信息跟踪
	 *
	 * Table:     taobao_trade
	 * Column:    delivery_track
	 * Nullable:  true
	 */
	public String getDeliveryTrack() {
		return deliveryTrack;
	}

	/**
	 * 物流信息跟踪
	 *
	 * Table:     taobao_trade
	 * Column:    delivery_track
	 * Nullable:  true
	 */
	public void setDeliveryTrack(String deliveryTrack) {
		this.deliveryTrack = deliveryTrack;
	}

	/**
	 * 业务处理时间
	 *
	 * Table:     taobao_trade
	 * Column:    last_update_time
	 * Nullable:  true
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 * 业务处理时间
	 *
	 * Table:     taobao_trade
	 * Column:    last_update_time
	 * Nullable:  true
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * 备注(本地, 不是淘宝提供的)
	 *
	 * Table:     taobao_trade
	 * Column:    note
	 * Nullable:  true
	 */
	public String getNote() {
		return note;
	}

	/**
	 * 备注(本地, 不是淘宝提供的)
	 *
	 * Table:     taobao_trade
	 * Column:    note
	 * Nullable:  true
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * 订单详细, JSON 格式
	 *
	 * Table:     taobao_trade
	 * Column:    orders
	 * Nullable:  true
	 */
	public String getOrders() {
		return orders;
	}

	/**
	 * 订单详细, JSON 格式
	 *
	 * Table:     taobao_trade
	 * Column:    orders
	 * Nullable:  true
	 */
	public void setOrders(String orders) {
		this.orders = orders;
	}

}
