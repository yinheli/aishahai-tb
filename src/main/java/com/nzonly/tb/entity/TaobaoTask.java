package com.nzonly.tb.entity;

import java.util.Date;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-21 下午5:00:24
 * @version V1.0
 */
public class TaobaoTask extends BaseEntity {

	private static final long serialVersionUID = -444457915370292974L;
	/**
	 * 异步任务id。创建异步任务时返回的任务id号
	 * Database column taobao_task.task_id
	 */
	private Long taskId;

	/**
	 * 任务创建时间
	 * Database column taobao_task.created
	 */
	private Date created;

	/**
	 * 任务提交时的参数
	 * Database column taobao_task.params
	 */
	private String params;

	/**
	 * 响应 body
	 * Database column taobao_task.body
	 */
	private String body;

	/**
	 * 此任务是由哪个api产生的
	 * Database column taobao_task.method
	 */
	private String method;

	/**
	 * 异步任务处理状态。new（还未开始处理），doing（处理中），done（处理结束）。
	 * Database column taobao_task.status
	 */
	private String status;

	/**
	 * 大任务结果下载地址。当创建的认任务是大数据量的任务时，获取结果会返回此字段，同时subtasks列表会为空。
	 * Database column taobao_task.download_url
	 */
	private String downloadUrl;

	/**
	 * 下载文件的MD5校验码，通过此校验码可以检查下载的文件是否是完整的
	 * Database column taobao_task.check_code
	 */
	private String checkCode;

	/**
	 * 任务最后一次检查时间
	 * Database column taobao_task.last_check_time
	 */
	private Date lastCheckTime;

	/**
	 * 异步任务id。创建异步任务时返回的任务id号
	 * This method returns the value of the database column taobao_task.task_id
	 *
	 * @return the value of taobao_task.task_id
	 */
	public Long getTaskId() {
		return taskId;
	}

	/**
	 * 异步任务id。创建异步任务时返回的任务id号
	 * Database column taobao_task.task_id
	 *
	 * @param taskId the value for taobao_task.task_id
	 */
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	/**
	 * 任务创建时间
	 * This method returns the value of the database column taobao_task.created
	 *
	 * @return the value of taobao_task.created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * 任务创建时间
	 * Database column taobao_task.created
	 *
	 * @param created the value for taobao_task.created
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * 任务提交时的参数
	 * This method returns the value of the database column taobao_task.params
	 *
	 * @return the value of taobao_task.params
	 */
	public String getParams() {
		return params;
	}

	/**
	 * 任务提交时的参数
	 * Database column taobao_task.params
	 *
	 * @param params the value for taobao_task.params
	 */
	public void setParams(String params) {
		this.params = params;
	}

	/**
	 * 响应 body
	 * This method returns the value of the database column taobao_task.body
	 *
	 * @return the value of taobao_task.body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * 响应 body
	 * Database column taobao_task.body
	 *
	 * @param body the value for taobao_task.body
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * 此任务是由哪个api产生的
	 * This method returns the value of the database column taobao_task.method
	 *
	 * @return the value of taobao_task.method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * 此任务是由哪个api产生的
	 * Database column taobao_task.method
	 *
	 * @param method the value for taobao_task.method
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * 异步任务处理状态。new（还未开始处理），doing（处理中），done（处理结束）。
	 * This method returns the value of the database column taobao_task.status
	 *
	 * @return the value of taobao_task.status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 异步任务处理状态。new（还未开始处理），doing（处理中），done（处理结束）。
	 * Database column taobao_task.status
	 *
	 * @param status the value for taobao_task.status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 大任务结果下载地址。当创建的认任务是大数据量的任务时，获取结果会返回此字段，同时subtasks列表会为空。
	 * This method returns the value of the database column taobao_task.download_url
	 *
	 * @return the value of taobao_task.download_url
	 */
	public String getDownloadUrl() {
		return downloadUrl;
	}

	/**
	 * 大任务结果下载地址。当创建的认任务是大数据量的任务时，获取结果会返回此字段，同时subtasks列表会为空。
	 * Database column taobao_task.download_url
	 *
	 * @param downloadUrl the value for taobao_task.download_url
	 */
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	/**
	 * 下载文件的MD5校验码，通过此校验码可以检查下载的文件是否是完整的
	 * This method returns the value of the database column taobao_task.check_code
	 *
	 * @return the value of taobao_task.check_code
	 */
	public String getCheckCode() {
		return checkCode;
	}

	/**
	 * 下载文件的MD5校验码，通过此校验码可以检查下载的文件是否是完整的
	 * Database column taobao_task.check_code
	 *
	 * @param checkCode the value for taobao_task.check_code
	 */
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	/**
	 * 任务最后一次检查时间
	 * This method returns the value of the database column taobao_task.last_check_time
	 *
	 * @return the value of taobao_task.last_check_time
	 */
	public Date getLastCheckTime() {
		return lastCheckTime;
	}

	/**
	 * 任务最后一次检查时间
	 * Database column taobao_task.last_check_time
	 *
	 * @param lastCheckTime the value for taobao_task.last_check_time
	 */
	public void setLastCheckTime(Date lastCheckTime) {
		this.lastCheckTime = lastCheckTime;
	}

}
