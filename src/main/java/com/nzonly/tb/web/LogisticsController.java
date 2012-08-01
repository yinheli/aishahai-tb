package com.nzonly.tb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nzonly.tb.Constants;
import com.nzonly.tb.service.LogisticsService;

/**
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-8-1 下午11:23:51
 * @version V1.0
 */
@Controller
@RequestMapping("/trade/logistics")
public class LogisticsController extends BaseController {
	
	@Autowired
	private LogisticsService logisticsService;
	
	@RequestMapping(value = {"index", ""})
	public String index(Model model, @RequestParam(defaultValue = "1") int p) {
		PageRequest pageRequest = new PageRequest(p - 1, Constants.PAGE_SIZE);
		model.addAttribute("list", logisticsService.getByPage(pageRequest));
		return "logistics/index";
	}

}
