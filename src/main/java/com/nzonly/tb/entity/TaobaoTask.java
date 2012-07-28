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
     *
     * Table:     taobao_task
     * Column:    task_id
     * Nullable:  false
     */
    private Long taskId;

    /**
     * 任务创建时间
     *
     * Table:     taobao_task
     * Column:    created
     * Nullable:  true
     */
    private Date created;

    /**
     * 任务提交时的参数
     *
     * Table:     taobao_task
     * Column:    params
     * Nullable:  true
     */
    private String params;

    /**
     * 响应 body
     *
     * Table:     taobao_task
     * Column:    body
     * Nullable:  true
     */
    private String body;

    /**
     * 此任务是由哪个api产生的
     *
     * Table:     taobao_task
     * Column:    method
     * Nullable:  true
     */
    private String method;

    /**
     * 异步任务处理状态。new（还未开始处理），doing（处理中），done（处理结束）。
     *
     * Table:     taobao_task
     * Column:    status
     * Nullable:  true
     */
    private String status;

    /**
     * 大任务结果下载地址。当创建的认任务是大数据量的任务时，获取结果会返回此字段，同时subtasks列表会为空。
     *
     * Table:     taobao_task
     * Column:    download_url
     * Nullable:  true
     */
    private String downloadUrl;

    /**
     * 下载文件的MD5校验码，通过此校验码可以检查下载的文件是否是完整的
     *
     * Table:     taobao_task
     * Column:    check_code
     * Nullable:  true
     */
    private String checkCode;

    /**
     * 任务最后一次检查时间
     *
     * Table:     taobao_task
     * Column:    last_check_time
     * Nullable:  true
     */
    private Date lastCheckTime;

    /**
     * 异步任务id。创建异步任务时返回的任务id号
     *
     * Table:     taobao_task
     * Column:    task_id
     * Nullable:  false
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * 异步任务id。创建异步任务时返回的任务id号
     *
     * Table:     taobao_task
     * Column:    task_id
     * Nullable:  false
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    /**
     * 任务创建时间
     *
     * Table:     taobao_task
     * Column:    created
     * Nullable:  true
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 任务创建时间
     *
     * Table:     taobao_task
     * Column:    created
     * Nullable:  true
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 任务提交时的参数
     *
     * Table:     taobao_task
     * Column:    params
     * Nullable:  true
     */
    public String getParams() {
        return params;
    }

    /**
     * 任务提交时的参数
     *
     * Table:     taobao_task
     * Column:    params
     * Nullable:  true
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     * 响应 body
     *
     * Table:     taobao_task
     * Column:    body
     * Nullable:  true
     */
    public String getBody() {
        return body;
    }

    /**
     * 响应 body
     *
     * Table:     taobao_task
     * Column:    body
     * Nullable:  true
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * 此任务是由哪个api产生的
     *
     * Table:     taobao_task
     * Column:    method
     * Nullable:  true
     */
    public String getMethod() {
        return method;
    }

    /**
     * 此任务是由哪个api产生的
     *
     * Table:     taobao_task
     * Column:    method
     * Nullable:  true
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 异步任务处理状态。new（还未开始处理），doing（处理中），done（处理结束）。
     *
     * Table:     taobao_task
     * Column:    status
     * Nullable:  true
     */
    public String getStatus() {
        return status;
    }

    /**
     * 异步任务处理状态。new（还未开始处理），doing（处理中），done（处理结束）。
     *
     * Table:     taobao_task
     * Column:    status
     * Nullable:  true
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 大任务结果下载地址。当创建的认任务是大数据量的任务时，获取结果会返回此字段，同时subtasks列表会为空。
     *
     * Table:     taobao_task
     * Column:    download_url
     * Nullable:  true
     */
    public String getDownloadUrl() {
        return downloadUrl;
    }

    /**
     * 大任务结果下载地址。当创建的认任务是大数据量的任务时，获取结果会返回此字段，同时subtasks列表会为空。
     *
     * Table:     taobao_task
     * Column:    download_url
     * Nullable:  true
     */
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    /**
     * 下载文件的MD5校验码，通过此校验码可以检查下载的文件是否是完整的
     *
     * Table:     taobao_task
     * Column:    check_code
     * Nullable:  true
     */
    public String getCheckCode() {
        return checkCode;
    }

    /**
     * 下载文件的MD5校验码，通过此校验码可以检查下载的文件是否是完整的
     *
     * Table:     taobao_task
     * Column:    check_code
     * Nullable:  true
     */
    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    /**
     * 任务最后一次检查时间
     *
     * Table:     taobao_task
     * Column:    last_check_time
     * Nullable:  true
     */
    public Date getLastCheckTime() {
        return lastCheckTime;
    }

    /**
     * 任务最后一次检查时间
     *
     * Table:     taobao_task
     * Column:    last_check_time
     * Nullable:  true
     */
    public void setLastCheckTime(Date lastCheckTime) {
        this.lastCheckTime = lastCheckTime;
    }

}
