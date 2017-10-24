package com.route21.ws.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveContentRequest {
	
	@JsonProperty("ID")
	private Long id;
	
	@JsonProperty("PAGE_NAME")
	private String pageName;
	
	@JsonProperty("TITLE")
	private String title;
	
	@JsonProperty("DESCRIPTION")
	private String description;
	
	@JsonProperty("PAGE_URL")
	private String pageUrl;
	
	@JsonProperty("TITLE_URL")
	private String titleUrl;
	
	@JsonProperty("SORT")
	private int sort;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public String getTitleUrl() {
		return titleUrl;
	}
	public void setTitleUrl(String titleUrl) {
		this.titleUrl = titleUrl;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	

}
