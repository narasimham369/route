package com.route21.ws.response;

import com.route21.ws.bean.PartyActivity;



public class PartyActivityResponse extends Response {

	private PartyActivity partyActivity;

	public PartyActivity getPartyActivity() {
		return partyActivity;
	}

	public void setPartyActivity(PartyActivity partyActivity) {
		this.partyActivity = partyActivity;
	} 
}
