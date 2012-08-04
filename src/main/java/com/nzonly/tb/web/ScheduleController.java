package com.nzonly.tb.web;

import java.util.ArrayList;
import java.util.List;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nzonly.tb.dto.JobDTO;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-22 上午10:43:27
 * @version V1.0
 */
@Controller
@RequestMapping("/schedule")
public class ScheduleController extends BaseController {
	
	@Autowired
	private Scheduler scheduler;
	
	@RequestMapping(value = {"index", ""})
	public String index(Model model) throws Exception {
		List<JobDTO> jobs = new ArrayList<JobDTO>();
		GroupMatcher<JobKey> gmk = GroupMatcher.groupEquals(Scheduler.DEFAULT_GROUP);
		for(JobKey jobKey : scheduler.getJobKeys(gmk)) {
	       JobDetail job = scheduler.getJobDetail(jobKey);
	      if (job != null) {
	    	  jobs.add(new JobDTO(job, scheduler.getTriggersOfJob(jobKey)));
	      }
	    }
		
		model.addAttribute("list", jobs);
		return "schedule/index";
	}

}
