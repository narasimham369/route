package com.route21.ws.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.route21.ws.bean.Story;

public class StoryListResponse extends Response{
	
	@JsonProperty("STORY_LIST")
	private List<Story> lstStory;

	public List<Story> getLstStory() {
		return lstStory;
	}

	public void setLstStory(List<Story> lstStory) {
		this.lstStory = lstStory;
	}
	

}
