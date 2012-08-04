package com.nzonly.tb.quartz;

import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 定时服务接口
 * 
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-21 上午10:32:18
 * @version V1.0
 */
@Component
@Transactional(readOnly = false)
public class ScheduleService {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private Scheduler scheduler;
	
	public void clearScheduler() throws Exception {
		log.info("clear all");
		scheduler.clear();
	}

	/**
	 * 添加一个定时任务
	 * 
	 * @author yinheli
	 * @date 2012-7-21 上午10:33:59
	 */
	public void addTrigger() {
		log.info("add trigger");
	}

}
