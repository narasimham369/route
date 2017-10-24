package com.route21.ws.service;

import com.route21.ws.bean.OpportunityType;
import com.route21.ws.response.OpportunityTypeListResponse;
import com.route21.ws.response.OpportunityTypeResponse;
import com.route21.ws.response.Response;


public interface OpportunityTypeService {

	OpportunityTypeResponse addOpportunityType(OpportunityType ot);

	OpportunityTypeResponse updateOpportunityType(OpportunityType ot);
	
	OpportunityTypeListResponse getOpportunityType();
	
	Response deleteOpportunityType(Long id);

}
