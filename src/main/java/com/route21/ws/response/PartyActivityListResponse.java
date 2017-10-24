package com.route21.ws.response;

import java.util.List;

import com.route21.ws.bean.PartyActivity;


public class PartyActivityListResponse extends Response{

	private List<PartyActivity> lstPartyActivity;

	public List<PartyActivity> getLstPartyActivity() {
		return lstPartyActivity;
	}

	public void setLstPartyActivity(List<PartyActivity> lstPartyActivity) {
		this.lstPartyActivity = lstPartyActivity;
	}
}
