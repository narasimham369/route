package com.route21.ws.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.route21.ws.bean.Story;
import com.route21.ws.exception.DataNotFoundException;
import com.route21.ws.repository.StoryRepository;
import com.route21.ws.request.StoryRequest;
import com.route21.ws.response.Response;
import com.route21.ws.response.StoryListResponse;
import com.route21.ws.response.StoryResponse;
import com.route21.ws.service.StoryService;

@Transactional
@Service
public class StoryServiceImpl implements StoryService{

	@Autowired
	StoryRepository storyRepository;
	
	
	@Override
	public StoryResponse saveStory(StoryRequest request) {
		StoryResponse response = new StoryResponse();
		
		Story story = new Story();
		story.setTitle(request.getTitle());
		story.setShortDesc(request.getShortDesc());
		story.setImage(request.getImage());
		story.setDetailDescTitle(request.getDetailDescTitle());
		story.setDescription(request.getDescription());
		story.setAuthorName(request.getAuthorName());
		Story newStory = storyRepository.save(story);
		
		response.setStory(newStory);
		response.setStatusCode(200);
		response.setStatusMessage("SAVED SUCCESSFULLY");
		
		
		return response;
	}


	@Override
	public StoryResponse updateStory(StoryRequest request) {
		
		StoryResponse response = new StoryResponse();
		
		Story story = storyRepository.findOne(request.getId());
		if(story == null)
			throw new DataNotFoundException("Given id is not available");
		
		story.setTitle(request.getTitle());
		story.setShortDesc(request.getShortDesc());
		story.setImage(request.getImage());
		story.setDetailDescTitle(request.getDetailDescTitle());
		story.setDescription(request.getDescription());
		story.setAuthorName(request.getAuthorName());
		Story updatedStory = storyRepository.save(story);
		
		response.setStory(updatedStory);
		response.setStatusCode(200);
		response.setStatusMessage("SAVED SUCCESSFULLY");
		return response;
	}


	@Override
	public StoryListResponse getStory() {

		StoryListResponse response = new StoryListResponse();
		
		List<Story> storyList = storyRepository.findAll();
		
		response.setLstStory(storyList);
		response.setStatusCode(200);
		response.setStatusMessage("RETRIEVED SUCCESSFULLY");
		
		return response;
	}


	@Override
	public StoryResponse findById(Long id) {

		StoryResponse response = new StoryResponse();
		
		Story story = storyRepository.findOne(id);
		
		if(story == null)
			throw new DataNotFoundException("Given id is not available");
		
			response.setStory(story);
			response.setStatusCode(200);
			response.setStatusMessage("RETRIEVED SUCCESSFULLY");
				
		return response;
		
	}


	@Override
	public Response deleteStory(Long id) {

		Response response  = new Response();
		
		Story story = storyRepository.findOne(id);
		if(story!=null)
		{
			try
			{
				storyRepository.delete(id);
				response.setStatusCode(200);
				response.setStatusMessage("DELETED SUCCESSFULLY");
			}
			catch(Exception e)
			{
				response.setStatusCode(500);
				response.setStatusMessage("INTERNAL SERVER ERROR");
			}
		}
		
		return response;
	}

	
}
