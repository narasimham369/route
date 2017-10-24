package com.route21.ws.exception;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException() {
		super();
	}
	
	public DataNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
