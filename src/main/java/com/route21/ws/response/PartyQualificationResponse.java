package com.route21.ws.response;

import com.route21.ws.bean.PartyQualification;



public class PartyQualificationResponse extends Response{
	
	private PartyQualification partyQualification;

	public PartyQualification getPartyQualification() {
		return partyQualification;
	}

	public void setPartyQualification(PartyQualification partyQualification) {
		this.partyQualification = partyQualification;
	}

}
