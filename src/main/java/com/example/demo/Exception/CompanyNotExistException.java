package com.example.demo.Exception;

public class CompanyNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public CompanyNotExistException() {
		// TODO Auto-generated constructor stub
	}

	public CompanyNotExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CompanyNotExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public CompanyNotExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CompanyNotExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
