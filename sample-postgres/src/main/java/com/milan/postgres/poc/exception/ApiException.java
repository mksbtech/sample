package com.milan.postgres.poc.exception;

public class ApiException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorCode;

	public ApiException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ApiException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	
	public ApiException(String errorCode, String message, Throwable cause) {		
		super(message, cause);
		this.errorCode = errorCode;
		// TODO Auto-generated constructor stub
	}
	
	public ApiException(String errorCode, String message) {		
		super(message);
		this.errorCode = errorCode;
		// TODO Auto-generated constructor stub
	}
	public ApiException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ApiException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	

}
