package com.example.demo.Exception;

public class CustomerExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerExistException() {
		// TODO Auto-generated constructor stub
	}

	public CustomerExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CustomerExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public CustomerExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CustomerExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
