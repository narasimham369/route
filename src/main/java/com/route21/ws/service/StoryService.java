package com.route21.ws.service;

import com.route21.ws.request.StoryRequest;
import com.route21.ws.response.Response;
import com.route21.ws.response.StoryListResponse;
import com.route21.ws.response.StoryResponse;

public interface StoryService {

	StoryResponse saveStory(StoryRequest request);

	StoryResponse updateStory(StoryRequest request);

	StoryListResponse getStory();

	StoryResponse findById(Long id);

	Response deleteStory(Long id);

}
