package com.nzonly.tb;


/**
 * 系统常量
 * 
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-21 上午11:01:20
 * @version V1.0
 */
public interface Constants {
	
	int PAGE_SIZE = 15;
	
	interface FromChannel {
		String TAOBAO = "taobao";
	}
	
	/**
	 * 淘宝任务处理状态, 封装淘宝的处理状态和本地的处理状态
	 * 
	 * @author yinheli
	 * @link yinheli@gmail.com
	 * @date 2012-7-21 下午10:51:17
	 * @version V1.0
	 */
	interface TaskStatus {
		/**
		 * 淘宝还未开始处理
		 */
		String NEW = "new";
		
		/**
		 * 淘宝处理中
		 */
		String DOING = "doing";
		
		/**
		 * 淘宝处理结束 (可以下载)
		 */
		String DONE = "done";
		
		/**
		 * 本地处理中
		 */
		String HANDING = "local_handing";
		
		/**
		 * 本地处理完成
		 */
		String FINISH = "local_finish";
	}


}
