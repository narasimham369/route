package com.route21.ws.exception;

public class LoginIdNotExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LoginIdNotExistsException() {
		super();
	}
	
	public LoginIdNotExistsException(String errorMessage) {
		super(errorMessage);
	}

}
