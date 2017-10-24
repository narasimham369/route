package com.route21.ws.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.route21.ws.bean.UserLogin;

public class RegisterPartyResponse extends Response {
	
	@JsonProperty("USER_LOGIN")
	private UserLogin userLogin;
	
	@JsonProperty("AUTHTOKEN")
	private String authtoken;
	
	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

	public String getAuthtoken() {
		return authtoken;
	}

	public void setAuthtoken(String authtoken) {
		this.authtoken = authtoken;
	}


	
}
