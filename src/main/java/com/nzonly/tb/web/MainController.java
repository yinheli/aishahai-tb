package com.nzonly.tb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-21 下午3:50:44
 * @version V1.0
 */
@Controller
@RequestMapping("/")
public class MainController extends BaseController {
	
	@RequestMapping(value = {"index", "/"})
	public String index() {
		return "main/index";
	}

}
