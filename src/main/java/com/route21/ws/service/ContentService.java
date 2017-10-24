package com.route21.ws.service;

import com.route21.ws.request.SaveContentRequest;
import com.route21.ws.response.ContentResponse;
import com.route21.ws.response.GetContentResponse;
import com.route21.ws.response.SaveContentResponse;

public interface ContentService {
	
	public SaveContentResponse saveContent(SaveContentRequest saveRequest);
	
	public GetContentResponse listContents();
	
	public GetContentResponse getContent(String pageUrl);

	public ContentResponse updateContent(Long contentId, SaveContentRequest request);

	public GetContentResponse listContents(Long artId, String contenttype);
}