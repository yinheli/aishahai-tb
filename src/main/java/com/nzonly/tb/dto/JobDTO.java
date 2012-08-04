package com.nzonly.tb.dto;

import java.util.List;

import org.quartz.JobDetail;
import org.quartz.Trigger;

/**
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-8-4 上午10:34:43
 * @version V1.0
 */
public class JobDTO {
	
	private JobDetail job;
	
	private List<? extends Trigger> triggers;
	
	public JobDTO() {
	}

	public JobDTO(JobDetail job, List<? extends Trigger> triggers) {
		super();
		this.job = job;
		this.triggers = triggers;
	}

	/**   
	 * get job
	 * @return  job    
	 */
	public JobDetail getJob() {
		return job;
	}

	/**   
	 * @param job set job
	 */
	public void setJob(JobDetail job) {
		this.job = job;
	}

	/**   
	 * get triggers
	 * @return  triggers    
	 */
	public List<? extends Trigger> getTriggers() {
		return triggers;
	}

	/**   
	 * @param triggers set triggers
	 */
	public void setTriggers(List<? extends Trigger> triggers) {
		this.triggers = triggers;
	}
	
}
