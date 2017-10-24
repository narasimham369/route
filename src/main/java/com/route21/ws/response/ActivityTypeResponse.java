package com.route21.ws.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.route21.ws.bean.ActivityType;


public class ActivityTypeResponse extends Response {

	@JsonProperty("ACTIVITYTYPE")
	private ActivityType activityType;

	public ActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}
	
}
