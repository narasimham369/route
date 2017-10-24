package com.route21.ws.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class StoryRequest {	
	
	@JsonProperty("ID")
	private long id;

	@JsonProperty("TITLE")
	private String title;
	
	@JsonProperty("SHORT_DESC")
	private String shortDesc;
	
	@JsonProperty("IMAGE")
	private String image;
	
	@JsonProperty("DETAIL_DESC_TITLE")
	private String detailDescTitle;
	
	@JsonProperty("DESCRIPTION")
	private String description;
	
	@JsonProperty("AUTHOR_NAME")
	private String authorName; 
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDetailDescTitle() {
		return detailDescTitle;
	}

	public void setDetailDescTitle(String detailDescTitle) {
		this.detailDescTitle = detailDescTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	
	
	
}
