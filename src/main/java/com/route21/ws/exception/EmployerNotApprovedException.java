package com.route21.ws.exception;

public class EmployerNotApprovedException extends RuntimeException{
	
	public EmployerNotApprovedException() {
		super();
	}
	
	public EmployerNotApprovedException(String errorMessage)
	{
		super(errorMessage);
	}

	
}
