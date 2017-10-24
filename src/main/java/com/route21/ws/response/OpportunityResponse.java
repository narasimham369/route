package com.route21.ws.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.route21.ws.bean.Opportunity;



public class OpportunityResponse extends Response{

	@JsonProperty("OPPORTUNITY")
	private Opportunity opportunity;

	
	public Opportunity getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(Opportunity opportunity) {
		this.opportunity = opportunity;
	}
	
	
}
