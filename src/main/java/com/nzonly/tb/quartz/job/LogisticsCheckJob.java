package com.nzonly.tb.quartz.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nzonly.tb.taobao.TaobaoLogisticsService;

/**
 * 检查物流信息
 * 
 * @author yinheli <yinheli@gmail.com>
 * @date 2012-8-3 下午8:59:54
 * @version V1.0
 */
@Component
@Transactional(readOnly = false)
public class LogisticsCheckJob implements Job {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TaobaoLogisticsService taobaoLogisticsService;
	
	/**
	 * execute 
	 */
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		log.debug("date:{}", new Date());
	}

}
