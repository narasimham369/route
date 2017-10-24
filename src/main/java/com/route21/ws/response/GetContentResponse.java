package com.route21.ws.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetContentResponse extends Response {
	
	@JsonProperty("CONTENT_LIST")
	private List<LiferayContent> contentList;
	
	@JsonProperty("PAGE_NAME")
	private String pageName;
	
	@JsonProperty("TOTAL_CONTENT_SIZE")
	private String totalContentSize;

	private String message;
	
	private String exception;
	
	public List<LiferayContent> getContentList() {
		return contentList;
	}

	public void setContentList(List<LiferayContent> contentList) {
		this.contentList = contentList;
	}
	public GetContentResponse() {
		
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getTotalContentSize() {
		return totalContentSize;
	}

	public void setTotalContentSize(String totalContentSize) {
		this.totalContentSize = totalContentSize;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}
	
}
