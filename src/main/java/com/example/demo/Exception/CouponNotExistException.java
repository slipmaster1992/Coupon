/**
 * 
 */
package com.example.demo.Exception;

/**
 * @author User
 *
 */
public class CouponNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1L;

	/**
	 * 
	 */
	public CouponNotExistException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public CouponNotExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public CouponNotExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CouponNotExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public CouponNotExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
