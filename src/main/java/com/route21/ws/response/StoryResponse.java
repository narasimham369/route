package com.route21.ws.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.route21.ws.bean.Story;

public class StoryResponse extends Response {
	
	@JsonProperty("STORY")
	private Story story;

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

}
