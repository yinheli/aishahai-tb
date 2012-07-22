package com.nzonly.tb.web;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-20 下午11:17:08
 * @version V1.0
 */
@Controller
public class LoginController {

	@Value("${app.key}")
	private String appKey;

	@Value("${app.callback}")
	private String appCallback;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) throws Exception {
		if (SecurityUtils.getSubject().isAuthenticated()) {
			return "redirect:/index";
		}

		model.addAttribute("appKey", appKey);
		model.addAttribute("appCallback", URLEncoder.encode(appCallback, "UTF-8"));
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName, Model model) throws IOException {
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
		model.addAttribute("appKey", appKey);
		model.addAttribute("appCallback", URLEncoder.encode(appCallback, "UTF-8"));
		return "login";
	}

}
