package com.route21.ws.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.route21.ws.bean.ApplyOpportunity;

public class ApplyOpportunityMapResponse  extends Response{
	
	@JsonProperty("MAPAPPLYOPPORTUNITY")
	public Map<Integer, List<ApplyOpportunity>>  mapResponse;

	public Map<Integer, List<ApplyOpportunity>> getMapResponse() {
		return mapResponse;
	}

	public void setMapResponse(Map<Integer, List<ApplyOpportunity>> mapResponse) {
		this.mapResponse = mapResponse;
	}
	
	

}
