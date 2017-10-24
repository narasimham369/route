package com.route21.ws.service;

import com.route21.ws.bean.ActivityType;
import com.route21.ws.response.ActivityTypeListResponse;
import com.route21.ws.response.ActivityTypeResponse;
import com.route21.ws.response.Response;


public interface ActivityTypeService {

	ActivityTypeResponse addActivityType(ActivityType at);

	ActivityTypeResponse updateActivityType(ActivityType at);

	ActivityTypeListResponse getActivityType();

	Response deleteActivityType(Long id);

}
