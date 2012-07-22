package com.nzonly.tb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nzonly.tb.quartz.ScheduleService;

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
	private ScheduleService scheduleService;
	
	@RequestMapping(value = {"index", ""})
	public String index(Model model) {
		model.addAttribute("list", new Object());
		return "index";
	}

}
