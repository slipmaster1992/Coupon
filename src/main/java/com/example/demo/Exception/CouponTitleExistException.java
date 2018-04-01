/**
 * 
 */
package com.example.demo.Exception;

/**
 * @author slipmaster8
 *
 */
public class CouponTitleExistException extends Exception {

	/**
	 * 
	 */
	public CouponTitleExistException() {
		
	}

	/**
	 * @param arg0
	 */
	public CouponTitleExistException(String arg0) {
		super(arg0);
		
	}

	/**
	 * @param arg0
	 */
	public CouponTitleExistException(Throwable arg0) {
		super(arg0);
	
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public CouponTitleExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public CouponTitleExistException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

}
