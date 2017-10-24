package com.route21.ws.endpoint;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.jose4j.json.internal.json_simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.route21.ws.annotation.JWTSecured;
import com.route21.ws.constants.Route21Constants;
import com.route21.ws.exception.OperationProhibitedException;
import com.route21.ws.helper.JWTokenUtility;
import com.route21.ws.request.ExperienceRequest;
import com.route21.ws.response.ExperienceListResponse;
import com.route21.ws.response.ExperienceResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.ExperienceService;
import com.route21.ws.types.Role;

/**
 * 
 * This controller gives the information about the Experience.
 * 
 * @author admin-pc
 *
 */

@RestController
@Path("/")
public class ExperienceController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExperienceController.class);

	/**
	 * It inject {@link ExperienceService} object
	 */
	
	@Autowired
	private ExperienceService expService;
	
	/**
	 * 
	 * This method is used to insert details in Experience table.
	 * 
	 * @param request contains attribute of {@link ExperienceRequest}
	 * 
	 * @return the response status message
	 * @throws ParseException 
	 * 
	 */

	@JWTSecured(Role.STUDENT)
	@POST
	@Path(Route21Constants.SAVE_EXPERIENCE)
	@Produces("application/json")
	@Consumes("application/json")
	public ExperienceResponse addExperience(ExperienceRequest request, @Context HttpServletRequest req) throws ParseException
	{
		Long pid = JWTokenUtility.Jwtdecoder(req);
		System.out.println("reached controller");
		if(pid.longValue() == request.getPtyId())
		{
			return expService.addExperience(request);
		}
		
		else throw new OperationProhibitedException("You are not allowed to proceed.");
	}
	
	/**
	 * 
	 * This method is used to update the records in Experience table.
	 * 
	 * @param id contains id to update based on id.
	 * 
	 * @param1 request contains attribute of {@link ExperienceRequest}.
	 * 
	 * @return the response status message.
	 * @throws ParseException 
	 * 
	 */

	@JWTSecured(Role.STUDENT)
	@PUT
	@Path(Route21Constants.UPDATE_EXPERIENCE)
	@Produces("application/json")
	@Consumes("application/json")
	public ExperienceResponse updateExperience(ExperienceRequest request, @PathParam("id") Long id, @Context HttpServletRequest req) throws ParseException
	{
		Long pid = JWTokenUtility.Jwtdecoder(req);
		if(pid.longValue()== request.getPtyId())
		{
			return expService.updateExperience(request, id);
		}
		
		else throw new OperationProhibitedException("You are not allowed to proceed.");
	}
	
	/**
	 * 
	 * This method is used to list out the records in Experience table.
	 * 
	 * @return {@link ExperienceListResponse} to retrieve the list of all records in ApplyOpportunity table.
	 * 
	 */
	
	@GET
	@Path(Route21Constants.GET_EXPERIENCE)
	@Produces("application/json")
	public ExperienceListResponse getExperience(@PathParam("partyId") Long partyId)
	{
		LOGGER.info("controller"+partyId);
		return expService.getExperience(partyId);
	}
	
	/**
	 * 
	 * This method is for  delete the details in Experience table.
	 * 
	 * @param id contains id of Experience.
	 * 
	 * @return the response status message.
	 * 
	 * @throws ParseException 
	 *
	 */

	@JWTSecured(Role.STUDENT)
	@DELETE
	@Path(Route21Constants.DELETEEXPERIENCE_BYID)
	@Produces("application/json")
	public Response deleteApplyOpportunity(@PathParam("id") Long id,@PathParam("partyId") Long ptyId, @Context HttpServletRequest req) throws ParseException
	{
		Long pid = JWTokenUtility.Jwtdecoder(req);
		if(pid.longValue()== ptyId.longValue())
		{
			return expService.deleteExperience(id);
		}
	
		else throw new OperationProhibitedException("You are not allowed to proceed.");
	}
}
