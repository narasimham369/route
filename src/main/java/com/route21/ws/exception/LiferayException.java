package com.route21.ws.exception;

public class LiferayException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LiferayException() {
		super();
	}
	
	public LiferayException(String errorMessage) {
		super(errorMessage);
	}

}
