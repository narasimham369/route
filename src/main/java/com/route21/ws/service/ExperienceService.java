package com.route21.ws.service;

import com.route21.ws.request.ExperienceRequest;
import com.route21.ws.response.ExperienceListResponse;
import com.route21.ws.response.ExperienceResponse;
import com.route21.ws.response.Response;

public interface ExperienceService {

	
	ExperienceResponse addExperience(ExperienceRequest request);

	ExperienceResponse updateExperience(ExperienceRequest request, Long id);
	
	ExperienceListResponse getExperience(Long id);
	
	Response deleteExperience(Long id);
}
