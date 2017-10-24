package com.route21.ws.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * This is the bean class of login request.
 * 
 * @author admin-pc
 *
 */
public class LoginRequest {

	@JsonProperty("LOGIN_ID")
	private String loginId;
	
	@JsonProperty("LOGIN_PASS")
	private String loginPwd;

	
	public String getLoginId() {
		return loginId;
	}

	
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	
	
}
