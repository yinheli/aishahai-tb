package com.nzonly.tb.taobao.exception;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-21 下午10:23:02
 * @version V1.0
 */
public class TaobaoException extends Exception {

	private static final long serialVersionUID = 6296875948993604348L;

	/**
	 * @author yinheli
	 * @date 2012-7-21 下午10:23:14
	 */
	public TaobaoException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @author yinheli
	 * @date 2012-7-21 下午10:23:14
	 */
	public TaobaoException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @author yinheli
	 * @date 2012-7-21 下午10:23:14
	 */
	public TaobaoException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 * @author yinheli
	 * @date 2012-7-21 下午10:23:14
	 */
	public TaobaoException(Throwable cause) {
		super(cause);
	}

}
