package com.route21.ws.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MailChimpSubscriptionRequest {
	
	@JsonProperty("email_address")
	private String email_address;
	
	@JsonProperty("status")
	private String status;

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



}
