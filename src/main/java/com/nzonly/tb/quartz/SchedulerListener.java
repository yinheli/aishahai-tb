package com.nzonly.tb.quartz;

import javax.annotation.PostConstruct;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.listeners.SchedulerListenerSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nzonly.tb.quartz.job.LogisticsCheckJob;
import com.nzonly.tb.quartz.job.SyncLogistics;
import com.nzonly.tb.quartz.job.SyncTradesJob;

/**
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-8-4 上午9:01:34
 * @version V1.0
 */
@Component
@Transactional(readOnly = false)
public class SchedulerListener extends SchedulerListenerSupport {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private Scheduler scheduler;
	
	@PostConstruct
	@SuppressWarnings("unused")
	private void init() {
		try {
			scheduler.getListenerManager().addSchedulerListener(this);
		} catch (SchedulerException e) {
			log.error("reg scheduler listener error", e);
		}
		
		/*--------------------物流状态检查--------------------*/
		JobDetail logisticsCheckJob = JobBuilder.newJob(LogisticsCheckJob.class)
				.withIdentity(LogisticsCheckJob.class.getSimpleName())
				.withDescription("物流状态检查")
				.build();
		
		Trigger logisticsCheckJobTrigger = TriggerBuilder.newTrigger()
				   						   .withDescription("每8小时检查物流状态")
				   						   .forJob(logisticsCheckJob)
				   						   .startNow()
				   						   .withSchedule(
				   								CronScheduleBuilder.cronSchedule("* * */8 * * ?")
				   							)
										   .build();
		
		/*--------------------同步淘宝物流数据--------------------*/
		JobDetail syncLogistics = JobBuilder.newJob(SyncLogistics.class)
				.withIdentity(SyncLogistics.class.getSimpleName())
				.withDescription("同步淘宝物流数据")
				.build();
		
		Trigger syncLogisticsTrigger = TriggerBuilder.newTrigger()
				   .withDescription("每天凌晨1点同步淘宝物流数据")
				   .forJob(syncLogistics)
				   .startNow()
				   .withSchedule(
						CronScheduleBuilder.cronSchedule("* * 1 * * ?")
					)
				   .build();

		/*--------------------同步淘宝订单数据--------------------*/
		JobDetail syncTradesJob = JobBuilder.newJob(SyncTradesJob.class)
				.withIdentity(SyncTradesJob.class.getSimpleName())
				.withDescription("同步淘宝订单数据")
				.build();
		
		Trigger syncTradesJobTrigger = TriggerBuilder.newTrigger()
				   .withDescription("每天凌晨0点同步淘宝订单数据")
				   .forJob(syncTradesJob)
				   .startNow()
				   .withSchedule(
						CronScheduleBuilder.cronSchedule("* * 0 * * ?")
					)
				   .build();
		
		try {
			// 清理定时服务
			scheduler.clear();
			scheduler.scheduleJob(logisticsCheckJob, logisticsCheckJobTrigger);
			scheduler.scheduleJob(syncLogistics, syncLogisticsTrigger);
			scheduler.scheduleJob(syncTradesJob, syncTradesJobTrigger);
		} catch (SchedulerException e) {
			log.error("init job exception", e);
		}
		
	}
	
}
