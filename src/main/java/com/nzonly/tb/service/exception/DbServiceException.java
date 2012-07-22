package com.nzonly.tb.service.exception;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-21 下午10:59:13
 * @version V1.0
 */
public class DbServiceException extends RuntimeException {

	private static final long serialVersionUID = 3796834121892221107L;

	/**
	 * @author yinheli
	 * @date 2012-7-21 下午10:59:14
	 */
	public DbServiceException() {
	}

	/**
	 * @param message
	 * @author yinheli
	 * @date 2012-7-21 下午10:59:14
	 */
	public DbServiceException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 * @author yinheli
	 * @date 2012-7-21 下午10:59:14
	 */
	public DbServiceException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @author yinheli
	 * @date 2012-7-21 下午10:59:14
	 */
	public DbServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
