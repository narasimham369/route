package com.route21.ws.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserStatusRequest {
	
	@JsonProperty("USER_ID")
	private long userId;
	
	@JsonProperty("LOGIN_ID")
	private String loginId;
	
	@JsonProperty("STATUS")
	private String status;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
