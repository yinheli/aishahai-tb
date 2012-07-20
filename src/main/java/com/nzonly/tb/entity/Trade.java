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
public class Trade extends BaseEntity {

	private static final long serialVersionUID = -6260772131747681081L;

	/**
	 * Database column trade.id
	 */
	private Long id;

	/**
	 * 淘宝订单信息
	 * Database column trade.tid
	 */
	private Long tid;

	/**
	 * 买家昵称
	 * Database column trade.buyer_nick
	 */
	private String buyerNick;

	/**
	 * 支付信息
	 * Database column trade.payment
	 */
	private String payment;

	/**
	 * 物流信息跟踪, 更新时间
	 * Database column trade.delivery_track_time
	 */
	private Date deliveryTrackTime;

	/**
	 * 业务处理时间
	 * Database column trade.operation_time
	 */
	private Date operationTime;

	/**
	 * 业务处理备注
	 * Database column trade.operation_note
	 */
	private String operationNote;

	/**
	 * 物流信息跟踪
	 * Database column trade.delivery_track
	 */
	private String deliveryTrack;

	/**
	 * 
	 * This method returns the value of the database column trade.id
	 *
	 * @return the value of trade.id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * Database column trade.id
	 *
	 * @param id the value for trade.id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 淘宝订单信息
	 * This method returns the value of the database column trade.tid
	 *
	 * @return the value of trade.tid
	 */
	public Long getTid() {
		return tid;
	}

	/**
	 * 淘宝订单信息
	 * Database column trade.tid
	 *
	 * @param tid the value for trade.tid
	 */
	public void setTid(Long tid) {
		this.tid = tid;
	}

	/**
	 * 买家昵称
	 * This method returns the value of the database column trade.buyer_nick
	 *
	 * @return the value of trade.buyer_nick
	 */
	public String getBuyerNick() {
		return buyerNick;
	}

	/**
	 * 买家昵称
	 * Database column trade.buyer_nick
	 *
	 * @param buyerNick the value for trade.buyer_nick
	 */
	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}

	/**
	 * 支付信息
	 * This method returns the value of the database column trade.payment
	 *
	 * @return the value of trade.payment
	 */
	public String getPayment() {
		return payment;
	}

	/**
	 * 支付信息
	 * Database column trade.payment
	 *
	 * @param payment the value for trade.payment
	 */
	public void setPayment(String payment) {
		this.payment = payment;
	}

	/**
	 * 物流信息跟踪, 更新时间
	 * This method returns the value of the database column trade.delivery_track_time
	 *
	 * @return the value of trade.delivery_track_time
	 */
	public Date getDeliveryTrackTime() {
		return deliveryTrackTime;
	}

	/**
	 * 物流信息跟踪, 更新时间
	 * Database column trade.delivery_track_time
	 *
	 * @param deliveryTrackTime the value for trade.delivery_track_time
	 */
	public void setDeliveryTrackTime(Date deliveryTrackTime) {
		this.deliveryTrackTime = deliveryTrackTime;
	}

	/**
	 * 业务处理时间
	 * This method returns the value of the database column trade.operation_time
	 *
	 * @return the value of trade.operation_time
	 */
	public Date getOperationTime() {
		return operationTime;
	}

	/**
	 * 业务处理时间
	 * Database column trade.operation_time
	 *
	 * @param operationTime the value for trade.operation_time
	 */
	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}

	/**
	 * 业务处理备注
	 * This method returns the value of the database column trade.operation_note
	 *
	 * @return the value of trade.operation_note
	 */
	public String getOperationNote() {
		return operationNote;
	}

	/**
	 * 业务处理备注
	 * Database column trade.operation_note
	 *
	 * @param operationNote the value for trade.operation_note
	 */
	public void setOperationNote(String operationNote) {
		this.operationNote = operationNote;
	}

	/**
	 * 物流信息跟踪
	 * This method returns the value of the database column trade.delivery_track
	 *
	 * @return the value of trade.delivery_track
	 */
	public String getDeliveryTrack() {
		return deliveryTrack;
	}

	/**
	 * 物流信息跟踪
	 * Database column trade.delivery_track
	 *
	 * @param deliveryTrack the value for trade.delivery_track
	 */
	public void setDeliveryTrack(String deliveryTrack) {
		this.deliveryTrack = deliveryTrack;
	}

}
