package com.route21.ws.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.route21.ws.bean.ApplyOpportunity;

public class ApplyOpportunityResponse extends Response{

	@JsonProperty("APPLY_OPPORTUNITY")
	private ApplyOpportunity applyOpportunity;

	
	public ApplyOpportunity getApplyOpportunity() {
		return applyOpportunity;
	}

	public void setApplyOpportunity(ApplyOpportunity applyOpportunity) {
		this.applyOpportunity = applyOpportunity;
	}
	
	
}
