package com.route21.ws.exception;

public class EmailAlreadyRegisteredException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmailAlreadyRegisteredException() {
		super();
	}
	
	public EmailAlreadyRegisteredException(String errorMessage) {
		super(errorMessage);
	}

}
