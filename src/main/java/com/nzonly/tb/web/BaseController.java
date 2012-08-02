package com.nzonly.tb.web;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-20 下午8:55:36
 * @version V1.0
 */
public class BaseController {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * 异步任务执行器 (限制最大线程个数, 5个)
	 * 
	 * 全站 Controller 唯一
	 */
	protected static final ExecutorService executorService = Executors.newFixedThreadPool(5);

}
