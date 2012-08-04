package com.nzonly.tb.quartz;

import org.junit.Test;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;

import com.nzonly.tb.test.BaseTestNoWeb;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-21 上午10:27:03
 * @version V1.0
 */
public class SchedulerTest extends BaseTestNoWeb {

	@Autowired
	private Scheduler scheduler;

	@Test
	public void test01() throws Exception {
		GroupMatcher<JobKey> gmk = GroupMatcher.groupEquals(Scheduler.DEFAULT_GROUP);
		for(JobKey jobKey : scheduler.getJobKeys(gmk)) {
	       JobDetail job = scheduler.getJobDetail(jobKey);
	       System.out.println(job.getDescription());
	       Trigger t = null;
	    }
		
		
	}
	
}
