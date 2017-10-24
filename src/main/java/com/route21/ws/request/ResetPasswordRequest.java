package com.route21.ws.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResetPasswordRequest {
	
	@JsonProperty("LOGIN_ID")
	private String loginId;
	
	@JsonProperty("VERIFY_CODE")
	private String verifyCode;
	
	@JsonProperty("OLD_PASS")
	private String oldLoginPass;
	
	@JsonProperty("NEW_PASS")
	private String newLoginPass;

	public String getOldLoginPass() {
		return oldLoginPass;
	}

	public void setOldLoginPass(String oldLoginPass) {
		this.oldLoginPass = oldLoginPass;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getNewLoginPass() {
		return newLoginPass;
	}

	public void setNewLoginPass(String newLoginPass) {
		this.newLoginPass = newLoginPass;
	}
	
	

}
