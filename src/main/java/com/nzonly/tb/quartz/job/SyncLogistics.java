package com.nzonly.tb.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 运单信息同步 
 *
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-8-4 上午10:01:20
 * @version V1.0
 */
@Component
@Transactional(readOnly = false)
public class SyncLogistics implements Job {

	/**
	 * execute 
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)   
	 */
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		System.out.println("hello");
	}

}
