package com.nzonly.tb.web;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-8-4 下午12:14:40
 * @version V1.0
 */
@Controller
@RequestMapping("/ajax/schedule")
public class ScheduleAjaxController extends BaseController {
	
	@Autowired
	private Scheduler scheduler;
	
	@RequestMapping(value = "/trigger/{key}", method = RequestMethod.POST)
	@ResponseBody
	public String trigger(@PathVariable String key) {
		try {
			JobKey jobKey = JobKey.jobKey(key);
			scheduler.triggerJob(jobKey);
		} catch (SchedulerException e) {
			log.error("trigger exception", e);
			return "Fail:" + e.getMessage();
		}
		return "success";
	}

}
