package com.route21.ws.response;

import java.util.List;

import com.route21.ws.bean.UserLogin;

public class RegisteredPartyListResponse extends Response {
	
	private List<UserLogin> lstUserLogin;

	public List<UserLogin> getLstUserLogin() {
		return lstUserLogin;
	}

	public void setLstUserLogin(List<UserLogin> lstUserLogin) {
		this.lstUserLogin = lstUserLogin;
	}

}
