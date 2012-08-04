package com.nzonly.tb.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单信息同步
 * 
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-8-4 上午9:59:46
 * @version V1.0
 */
@Component
@Transactional(readOnly = false)
public class SyncTradesJob implements Job {

	/**
	 * execute 
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)   
	 */
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		
	}

}
