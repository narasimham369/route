package com.route21.ws.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NameListResponse extends Response {

	@JsonProperty("LOOKUP")
	private Map<String,List> map;

	public Map<String, List> getMap() {
		return map;
	}

	public void setMap(Map<String, List> map) {
		this.map = map;
	}
	
	
	
}
