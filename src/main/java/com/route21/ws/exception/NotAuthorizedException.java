package com.route21.ws.exception;

public class NotAuthorizedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotAuthorizedException() {
		super();
	}
	
	public NotAuthorizedException(String errorMessage) {
		super(errorMessage);
	}
}
