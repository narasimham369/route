package com.route21.ws.service;

import com.route21.ws.request.OpportunityRequest;
import com.route21.ws.request.OppurtunityBeanRequest;
import com.route21.ws.response.OpportunityListResponse;
import com.route21.ws.response.OpportunityResponse;



public interface OpportunityService {

	OpportunityResponse saveOpportunity(OpportunityRequest request);
	
	OpportunityResponse updateOpportunity(Long id, OpportunityRequest request);


	OpportunityListResponse getOpportunity(OppurtunityBeanRequest request);
	
	
}
