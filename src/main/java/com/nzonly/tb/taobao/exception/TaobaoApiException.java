package com.nzonly.tb.taobao.exception;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-21 下午10:24:09
 * @version V1.0
 */
public class TaobaoApiException extends TaobaoException {

	private static final long serialVersionUID = 1596935947761112110L;

	/**
	 * @author yinheli
	 * @date 2012-7-21 下午10:24:09
	 */
	public TaobaoApiException() {
	}

	/**
	 * @param message
	 * @param cause
	 * @author yinheli
	 * @date 2012-7-21 下午10:24:09
	 */
	public TaobaoApiException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @author yinheli
	 * @date 2012-7-21 下午10:24:09
	 */
	public TaobaoApiException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 * @author yinheli
	 * @date 2012-7-21 下午10:24:09
	 */
	public TaobaoApiException(Throwable cause) {
		super(cause);
	}

}
