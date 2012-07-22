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
	 * Database column taobao_trade.id
	 */
	private Long id;

	/**
	 * 淘宝订单信息
	 * Database column taobao_trade.tid
	 */
	private Long tid;

	/**
	 * 授权信息id
	 * Database column taobao_trade.auth_id
	 */
	private Long authId;

	/**
	 * 运单号
	 * Database column taobao_trade.out_sid
	 */
	private String outSid;

	/**
	 * 物流公司
	 * Database column taobao_trade.company_name
	 */
	private String companyName;

	/**
	 * 物流信息状态, 订单的物流状态 * 等候发送给物流公司 *已提交给物流公司,等待物流公司接单 *已经确认消息接收，等待物流公司接单 *物流公司已接单 *物流公司不接单 *物流公司揽收失败 *物流公司揽收成功 *签收失败 *对方已签收 *对方拒绝签收
	 * Database column taobao_trade.out_status
	 */
	private String outStatus;

	/**
	 * 买家昵称
	 * Database column taobao_trade.buyer_nick
	 */
	private String buyerNick;

	/**
	 * 买家支付宝账号
	 * Database column taobao_trade.buyer_alipay_no
	 */
	private String buyerAlipayNo;

	/**
	 * 支付金额
	 * Database column taobao_trade.payment
	 */
	private Double payment;

	/**
	 * 物流信息跟踪
	 * Database column taobao_trade.delivery_track
	 */
	private String deliveryTrack;

	/**
	 * 业务处理时间
	 * Database column taobao_trade.last_update_time
	 */
	private Date lastUpdateTime;

	/**
	 * 备注(本地, 不是淘宝提供的)
	 * Database column taobao_trade.note
	 */
	private String note;

	/**
	 * 订单详细, JSON 格式
	 * Database column taobao_trade.orders
	 */
	private String orders;

	/**
	 * 主键
	 * This method returns the value of the database column taobao_trade.id
	 *
	 * @return the value of taobao_trade.id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 主键
	 * Database column taobao_trade.id
	 *
	 * @param id the value for taobao_trade.id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 淘宝订单信息
	 * This method returns the value of the database column taobao_trade.tid
	 *
	 * @return the value of taobao_trade.tid
	 */
	public Long getTid() {
		return tid;
	}

	/**
	 * 淘宝订单信息
	 * Database column taobao_trade.tid
	 *
	 * @param tid the value for taobao_trade.tid
	 */
	public void setTid(Long tid) {
		this.tid = tid;
	}

	/**
	 * 授权信息id
	 * This method returns the value of the database column taobao_trade.auth_id
	 *
	 * @return the value of taobao_trade.auth_id
	 */
	public Long getAuthId() {
		return authId;
	}

	/**
	 * 授权信息id
	 * Database column taobao_trade.auth_id
	 *
	 * @param authId the value for taobao_trade.auth_id
	 */
	public void setAuthId(Long authId) {
		this.authId = authId;
	}

	/**
	 * 运单号
	 * This method returns the value of the database column taobao_trade.out_sid
	 *
	 * @return the value of taobao_trade.out_sid
	 */
	public String getOutSid() {
		return outSid;
	}

	/**
	 * 运单号
	 * Database column taobao_trade.out_sid
	 *
	 * @param outSid the value for taobao_trade.out_sid
	 */
	public void setOutSid(String outSid) {
		this.outSid = outSid;
	}

	/**
	 * 物流公司
	 * This method returns the value of the database column taobao_trade.company_name
	 *
	 * @return the value of taobao_trade.company_name
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 物流公司
	 * Database column taobao_trade.company_name
	 *
	 * @param companyName the value for taobao_trade.company_name
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 物流信息状态, 订单的物流状态 * 等候发送给物流公司 *已提交给物流公司,等待物流公司接单 *已经确认消息接收，等待物流公司接单 *物流公司已接单 *物流公司不接单 *物流公司揽收失败 *物流公司揽收成功 *签收失败 *对方已签收 *对方拒绝签收
	 * This method returns the value of the database column taobao_trade.out_status
	 *
	 * @return the value of taobao_trade.out_status
	 */
	public String getOutStatus() {
		return outStatus;
	}

	/**
	 * 物流信息状态, 订单的物流状态 * 等候发送给物流公司 *已提交给物流公司,等待物流公司接单 *已经确认消息接收，等待物流公司接单 *物流公司已接单 *物流公司不接单 *物流公司揽收失败 *物流公司揽收成功 *签收失败 *对方已签收 *对方拒绝签收
	 * Database column taobao_trade.out_status
	 *
	 * @param outStatus the value for taobao_trade.out_status
	 */
	public void setOutStatus(String outStatus) {
		this.outStatus = outStatus;
	}

	/**
	 * 买家昵称
	 * This method returns the value of the database column taobao_trade.buyer_nick
	 *
	 * @return the value of taobao_trade.buyer_nick
	 */
	public String getBuyerNick() {
		return buyerNick;
	}

	/**
	 * 买家昵称
	 * Database column taobao_trade.buyer_nick
	 *
	 * @param buyerNick the value for taobao_trade.buyer_nick
	 */
	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}

	/**
	 * 买家支付宝账号
	 * This method returns the value of the database column taobao_trade.buyer_alipay_no
	 *
	 * @return the value of taobao_trade.buyer_alipay_no
	 */
	public String getBuyerAlipayNo() {
		return buyerAlipayNo;
	}

	/**
	 * 买家支付宝账号
	 * Database column taobao_trade.buyer_alipay_no
	 *
	 * @param buyerAlipayNo the value for taobao_trade.buyer_alipay_no
	 */
	public void setBuyerAlipayNo(String buyerAlipayNo) {
		this.buyerAlipayNo = buyerAlipayNo;
	}

	/**
	 * 支付金额
	 * This method returns the value of the database column taobao_trade.payment
	 *
	 * @return the value of taobao_trade.payment
	 */
	public Double getPayment() {
		return payment;
	}

	/**
	 * 支付金额
	 * Database column taobao_trade.payment
	 *
	 * @param payment the value for taobao_trade.payment
	 */
	public void setPayment(Double payment) {
		this.payment = payment;
	}

	/**
	 * 物流信息跟踪
	 * This method returns the value of the database column taobao_trade.delivery_track
	 *
	 * @return the value of taobao_trade.delivery_track
	 */
	public String getDeliveryTrack() {
		return deliveryTrack;
	}

	/**
	 * 物流信息跟踪
	 * Database column taobao_trade.delivery_track
	 *
	 * @param deliveryTrack the value for taobao_trade.delivery_track
	 */
	public void setDeliveryTrack(String deliveryTrack) {
		this.deliveryTrack = deliveryTrack;
	}

	/**
	 * 业务处理时间
	 * This method returns the value of the database column taobao_trade.last_update_time
	 *
	 * @return the value of taobao_trade.last_update_time
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 * 业务处理时间
	 * Database column taobao_trade.last_update_time
	 *
	 * @param lastUpdateTime the value for taobao_trade.last_update_time
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * 备注(本地, 不是淘宝提供的)
	 * This method returns the value of the database column taobao_trade.note
	 *
	 * @return the value of taobao_trade.note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * 备注(本地, 不是淘宝提供的)
	 * Database column taobao_trade.note
	 *
	 * @param note the value for taobao_trade.note
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * 订单详细, JSON 格式
	 * This method returns the value of the database column taobao_trade.orders
	 *
	 * @return the value of taobao_trade.orders
	 */
	public String getOrders() {
		return orders;
	}

	/**
	 * 订单详细, JSON 格式
	 * Database column taobao_trade.orders
	 *
	 * @param orders the value for taobao_trade.orders
	 */
	public void setOrders(String orders) {
		this.orders = orders;
	}

}
