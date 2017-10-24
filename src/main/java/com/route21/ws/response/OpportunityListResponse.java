package com.route21.ws.response;

import java.util.List;

import com.route21.ws.bean.Opportunity;


public class OpportunityListResponse extends Response{

	private List<Opportunity> lstOpportunity;

	public List<Opportunity> getLstOpportunity() {
		return lstOpportunity;
	}

	public void setLstOpportunity(List<Opportunity> lstOpportunity) {
		this.lstOpportunity = lstOpportunity;
	}

	
	
	
}
