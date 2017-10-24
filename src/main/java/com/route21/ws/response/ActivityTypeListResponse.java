package com.route21.ws.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.route21.ws.bean.ActivityType;


public class ActivityTypeListResponse extends Response{
	
	@JsonProperty("ACTIVITYTYPELST")
	private List<ActivityType> lstActivityType;

	public List<ActivityType> getLstActivityType() {
		return lstActivityType;
	}

	public void setLstActivityType(List<ActivityType> lstActivityType) {
		this.lstActivityType = lstActivityType;
	}
	
}
