package com.route21.ws.response;

import java.util.List;

import com.route21.ws.bean.OpportunityType;



public class OpportunityTypeListResponse extends Response{

	private List<OpportunityType> lstOpportuniyType;

	public List<OpportunityType> getLstOpportuniyType() {
		return lstOpportuniyType;
	}

	public void setLstOpportuniyType(List<OpportunityType> lstOpportuniyType) {
		this.lstOpportuniyType = lstOpportuniyType;
	}
	
	
	
}
