package com.route21.ws.exception;

public class LoginCredentialNotMatchedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LoginCredentialNotMatchedException() {
		super();
	}
	
	public LoginCredentialNotMatchedException(String errorMessage) {
		super(errorMessage);
	}

}
