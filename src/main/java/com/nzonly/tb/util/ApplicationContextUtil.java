package com.nzonly.tb.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-8-4 上午9:21:23
 * @version V1.0
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {
	
	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ApplicationContextUtil.context = applicationContext;
	}

	/**   
	 * get context
	 * @return  context    
	 */
	public static ApplicationContext getContext() {
		return context;
	}

}
