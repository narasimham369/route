package com.route21.ws.response;

import java.util.List;

import com.route21.ws.bean.ApplyOpportunity;

public class ApplyOpportunityListResponse extends Response{

	private List<ApplyOpportunity> lstApplyOpnty;

	public List<ApplyOpportunity> getLstApplyOpnty() {
		return lstApplyOpnty;
	}

	public void setLstApplyOpnty(List<ApplyOpportunity> lstApplyOpnty) {
		this.lstApplyOpnty = lstApplyOpnty;
	}
	
	
}
