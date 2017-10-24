package com.route21.ws.service;

import com.route21.ws.request.ApplyOpportunityRequest;
import com.route21.ws.response.ApplyOpportunityListResponse;
import com.route21.ws.response.ApplyOpportunityMapResponse;
import com.route21.ws.response.ApplyOpportunityResponse;
import com.route21.ws.response.Response;


public interface ApplyOpportunityService {

	ApplyOpportunityResponse saveApplyopportunity(ApplyOpportunityRequest request);
	
	ApplyOpportunityResponse updateApplyOpportunity(Long id, ApplyOpportunityRequest request);
	
	ApplyOpportunityMapResponse getApplyOpportunity();
	
	ApplyOpportunityListResponse getApplyOpportunityByPartyId(Long id);
	
	Response deleteApplyOpportunityById(Long id);
	
	}
