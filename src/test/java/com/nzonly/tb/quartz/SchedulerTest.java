package com.nzonly.tb.quartz;

import org.junit.Test;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
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
		System.out.println(scheduler.getJobGroupNames());
	}

}
