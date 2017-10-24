package com.route21.ws.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.route21.ws.constants.Route21Constants;
import com.route21.ws.request.StoryRequest;
import com.route21.ws.response.Response;
import com.route21.ws.response.StoryListResponse;
import com.route21.ws.response.StoryResponse;
import com.route21.ws.service.StoryService;

/**
 * 
 * It is the Story Controller class which is the end point of web services.
 * 
 * It has some annotations to inject object from one layer to another layer.
 * 
 * It has some annotations to add, get, update and delete the records.
 * 
 * It has methods to add, get, update and delete the records.
 * 
 * @author admin-pc
 *
 */

@RestController
@Path("/")
public class StoryController {

	@Autowired
	StoryService storyService;
	
	/**
	 * 
	 * This controller is used to insert records in Story table.
	 * 
	 * In side the method it have only return type.
	 * 
	 * @param request to hold the records.
	 * 
	 * @return saveStory to save the records in database.
	 * 
	 */

	@POST
	@Path(Route21Constants.SAVE_STORY)
	@Produces("application/json")
	@Consumes("application/json")
	public StoryResponse saveStory(StoryRequest request)
	{
		return storyService.saveStory(request);
		
	}
	
	/**
	 * 
	 * This controller is used to update Story table.
	 * 
	 * In side the method it have only return type.
	 * 
	 * @param request to hold the records.
	 * 
	 * @return updateStory to update the records in database.
	 * 
	 */
	
	@PUT
	@Path(Route21Constants.UPDATE_STORY)
	@Produces("application/json")
	@Consumes("application/json")
	public StoryResponse updateStory(StoryRequest  request)
	{
		return storyService.updateStory(request);
	}
	
	
	/**
	 * 
	 * This controller is used to get records from Story table.
	 * 
	 * In side the method it have only return type.
	 * 
	 * @return getStory to get  the records in database.
	 * 
	 */
	
	@GET
	@Path(Route21Constants.GET_STORY)
	@Produces("application/json")
	public StoryListResponse getStory()
	{
		return storyService.getStory();
		
	}
	
	/**
	 * 
	 * This controller is used to get Story records ById.
	 * 
	 * In side the method it have only return type.
	 * 
	 * @param id to delete records with id.
	 * 
	 * @return findById to get  the records in database based on id.
	 * 
	 */
	
	@GET
	@Path(Route21Constants.GET_STORY_BY_ID)
	@Produces("application/json")
	public StoryResponse getStoryById(@PathParam("id") Long id)
	{		
		return storyService.findById(id);
		
	}
	
	/**
	 * 
	 * This controller is used to delete Story ById.
	 * 
	 * In side the method it have only return type.
	 * 
	 * @param id to delete records with id.
	 * 
	 * @return deleteStory to delete  the records in database based on id.
	 * 
	 */
	
	@DELETE
	@Path(Route21Constants.DELETE_STORY)
	@Produces("application/json")
	public Response deleteStory(@PathParam("id") Long id)
	{
		return storyService.deleteStory(id);
	}
	
	
	
}
