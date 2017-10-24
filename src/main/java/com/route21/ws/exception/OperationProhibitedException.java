package com.route21.ws.exception;

public class OperationProhibitedException extends RuntimeException{

	public OperationProhibitedException(){
		super();
	}
	
	public OperationProhibitedException(String errorMessage)
	{
		super(errorMessage);
	}
}
