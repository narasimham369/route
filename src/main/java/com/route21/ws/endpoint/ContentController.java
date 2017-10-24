package com.route21.ws.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.route21.ws.annotation.JWTSecured;
import com.route21.ws.constants.Route21Constants;
import com.route21.ws.request.SaveContentRequest;
import com.route21.ws.response.GetContentResponse;
import com.route21.ws.service.ContentService;
import com.route21.ws.service.OpportunityService;
import com.route21.ws.types.Role;

/**
 * This class gives information related to content.
 * 
 * @author viswanath
 *
 */


@RestController
@Path("/")
public class ContentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContentController.class);
	
	/**
	 * It inject {@link OpportunityService} object
	 */
	@Autowired
	ContentService contentService;
	
	/**
	 * 
	 * This method is used to insert details in Content table.
	 * 
	 * @param request contains attribute of {@link SaveContentRequest}
	 * 
	 * @return the response status message
	 * 
	 */
	
	@POST
	@Path(Route21Constants.SAVE_CONTENT)
	@Produces("application/json")
	@Consumes("application/json")
	public Object saveContent(SaveContentRequest saveRequest) {
		LOGGER.debug("SAVE CONTENT METHOD");
		
		return contentService.saveContent(saveRequest);
	}
	
	
	/**
	 * 
	 * This method is used to list out the records in Content table.
	 * 
	 * @return {@link ListOpportunityResponse} to retrieve the list of all records in Content table.
	 * 
	 */
	
	@GET
	@Path(Route21Constants.LIST_CONTENT)
	@Produces("application/json")
	public GetContentResponse listContnets(@QueryParam("articleId") String articleId,@QueryParam("contenttype") String contenttype) {
		LOGGER.debug("LIST CONTENT");
		Long artId = 0l;
		LOGGER.debug("articleId::"+articleId);
		if(articleId != null) 
			artId = new Long(articleId);
		return contentService.listContents(artId,contenttype);
	}
	
	/**
	 * 
	 * This method is used to get the records in Content table.
	 * 
	 * @param pageUrl to get url.
	 * 
	 * @return {@link ListContentResponse} to retrieve the list of all records in Content table.
	 * 
	 */
	
	
	@GET
	@Path(Route21Constants.GET_CONTENT)
	@Produces("application/json")
	public GetContentResponse getContent(@PathParam("pageUrl") String pageUrl) {
		LOGGER.debug("GET CONTENT");
		return contentService.getContent(pageUrl);
	}
}
