package com.nzonly.tb.quartz;

import javax.annotation.PostConstruct;

import org.quartz.Scheduler;
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
@Transactional(readOnly = true)
public class ScheduleService {
	
	@Autowired
	private Scheduler scheduler;
	
	@PostConstruct
	@SuppressWarnings("unused")
	private void initCheck() {
		
	}
	
	/**
	 * 添加一个定时任务
	 * 
	 * @author yinheli
	 * @date 2012-7-21 上午10:33:59
	 */
	@Transactional(readOnly = false)
	public void scheduleJob() {
	}

}
