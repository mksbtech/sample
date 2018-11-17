package com.milan.api.exception;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private String code;
	public BusinessException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BusinessException(String message, Throwable arg1, boolean arg2, boolean arg3) {
		super(message, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}
	public BusinessException(String message, Throwable arg1) {
		super(message, arg1);
		// TODO Auto-generated constructor stub
	}
	public BusinessException(String message) {
		super(message);
		this.message = message;
		// TODO Auto-generated constructor stub
	}
	public BusinessException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
