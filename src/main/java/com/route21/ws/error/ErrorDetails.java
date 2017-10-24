package com.route21.ws.error;
/**
 * 
 * @author webwerks
 * This class represents error details to end user when custom exception is handled.
 *
 */
public class ErrorDetails {

	private String userMessage;
	private String internalMessage;
	private String errorCode;
	private String info;

	public ErrorDetails() {
		super();
	}

	public ErrorDetails(String userMessage, String internalMessage, String errorCode, String info) {
		super();
		this.userMessage = userMessage;
		this.internalMessage = internalMessage;
		this.errorCode = errorCode;
		this.info = info;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public String getInternalMessage() {
		return internalMessage;
	}

	public void setInternalMessage(String internalMessage) {
		this.internalMessage = internalMessage;
	}

	

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
