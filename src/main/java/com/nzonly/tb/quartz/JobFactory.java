package com.nzonly.tb.quartz;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

import com.nzonly.tb.util.ApplicationContextUtil;

/**
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-8-4 下午12:55:47
 * @version V1.0
 */
@Component("quartzJobFactory")
public class JobFactory extends AdaptableJobFactory {
	
	/**
	 * createJobInstance 
	 * @see org.springframework.scheduling.quartz.AdaptableJobFactory#createJobInstance(org.quartz.spi.TriggerFiredBundle)   
	 */
	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle)
			throws Exception {
		return ApplicationContextUtil.getContext().getBean(bundle.getJobDetail().getJobClass());
	}

}
