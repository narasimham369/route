package com.route21.ws.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
	

	@JsonProperty("STATUS_CODE")	
	private int statusCode;
	
	@JsonProperty("STATUS_MESSAGE")
	private String statusMessage;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	} 

}
