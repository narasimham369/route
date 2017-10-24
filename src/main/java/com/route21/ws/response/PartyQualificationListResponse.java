package com.route21.ws.response;

import java.util.List;

import com.route21.ws.bean.PartyQualification;



public class PartyQualificationListResponse extends Response{
	
	private List<PartyQualification> partyQualificationList;

	public List<PartyQualification> getPartyQualificationList() {
		return partyQualificationList;
	}

	public void setPartyQualificationList(List<PartyQualification> partyQualificationList) {
		this.partyQualificationList = partyQualificationList;
	}

}
