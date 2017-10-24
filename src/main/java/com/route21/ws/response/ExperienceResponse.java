package com.route21.ws.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.route21.ws.bean.Experience;

public class ExperienceResponse extends Response{

	@JsonProperty("EXPERIENCE")
	private Experience experience;

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}
	
	
}
