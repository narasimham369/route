package com.route21.ws.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.route21.ws.bean.OpportunityType;


public class OpportunityTypeResponse extends Response{

	@JsonProperty("OPPORTUNITY_TYPE")
	private OpportunityType opportunitytype;

	public OpportunityType getOpportunitytype() {
		return opportunitytype;
	}

	public void setOpportunitytype(OpportunityType opportunitytype) {
		this.opportunitytype = opportunitytype;
	}
	
	
}
