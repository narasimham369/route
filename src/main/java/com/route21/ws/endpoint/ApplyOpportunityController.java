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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.route21.ws.annotation.JWTSecured;
import com.route21.ws.constants.Route21Constants;
import com.route21.ws.exception.OperationProhibitedException;
import com.route21.ws.helper.JWTokenUtility;
import com.route21.ws.request.ApplyOpportunityRequest;
import com.route21.ws.response.ApplyOpportunityListResponse;
import com.route21.ws.response.ApplyOpportunityMapResponse;
import com.route21.ws.response.ApplyOpportunityResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.ApplyOpportunityService;
import com.route21.ws.service.OpportunityService;
import com.route21.ws.types.Role;


/**
 * 
 * This controller gives the information about the ApplyOpportunity.
 * 
 * @author admin-pc
 *
 */
@RestController
@Path("/")
public class ApplyOpportunityController {

	/**
	 * It inject {@link OpportunityService} object
	 */
	
	@Autowired
	ApplyOpportunityService applyOpportunityservice;
	
	/**
	 * 
	 * This method is used to insert details in ApplyOpportunity table.
	 * 
	 * @param request contains attribute of {@link ApplyOpportunityRequest}
	 * 
	 * @return the response status message
	 * @throws ParseException 
	 * 
	 */

	@JWTSecured(Role.STUDENT)
	@POST
	@Path(Route21Constants.SAVEAPPLY_OPPORTUNITY)
	@Produces("application/json")
	@Consumes("application/json")
	public ApplyOpportunityResponse saveApplyOpportunity(ApplyOpportunityRequest request, @Context HttpServletRequest req) throws ParseException{
		
		Long pid = JWTokenUtility.Jwtdecoder(req);
		if(pid.longValue()== request.getPartyId())
		{
			return applyOpportunityservice.saveApplyopportunity(request);
		}
		
		else
		    throw new OperationProhibitedException("You are not allowed to proceed.");
		
	}	
	
	/**
	 * 
	 * This method is used to update the records in ApplyOpportunity table.
	 * 
	 * @param id contains id to update based on id.
	 * 
	 * @param1 request contains attribute of {@link ApplyOpportunityRequest}.
	 * 
	 * @return the response status message.
	 * @throws ParseException 
	 * 
	 */
	@JWTSecured(Role.STUDENT)
	@PUT
	@Path(Route21Constants.UPDATEAPPLY_OPPORTUNITY)
	@Produces("application/json")
	@Consumes("application/json")
	public ApplyOpportunityResponse updateApplyOpportunity(@PathParam("id") Long id, ApplyOpportunityRequest request, @Context HttpServletRequest req) throws ParseException{
		
		Long pid = JWTokenUtility.Jwtdecoder(req);
		if(pid.longValue() == request.getPartyId())
		{
			return applyOpportunityservice.updateApplyOpportunity(id,request);
		}
		
		else throw new OperationProhibitedException("You are not allowed to proceed.");
	}
	
	/**
	 * 
	 * This method is used to list out the records in ApplyOpportunity table.
	 * 
	 * @return {@link ListApplyOpportunityResponse} to retrieve the list of all records in ApplyOpportunity table.
	 * 
	 */

	@JWTSecured({Role.EMPLOYER, Role.ADMIN})
	@GET
	@Path(Route21Constants.GETAPPLY_OPPORTUNITY)
	@Produces("application/json")
	@Consumes("application/json")
	public ApplyOpportunityMapResponse getApplyOpportunity()
	{
		return applyOpportunityservice.getApplyOpportunity();
	}
	//@JWTSecured
	
	@JWTSecured({Role.STUDENT})
	@GET
	@Path(Route21Constants.GETAPPLY_OPPORTUNITYBYPTYID)
	@Produces("application/json")
	@Consumes("application/json")
	public ApplyOpportunityListResponse getApplyOpportunityByPartyId(@PathParam("ptyId") Long id)
	{
		
		return applyOpportunityservice.getApplyOpportunityByPartyId(id);
	}
	
	/**
	 * 
	 * This method is for  delete the details in ApplyOpportunity table.
	 * 
	 * @param id contains id of party.
	 * 
	 * @return the response status message.
	 *
	 */
	
	@DELETE
	@Path(Route21Constants.DELETEAPPLY_OPPORTUNITYBY_ID)
	@Produces("application/json")
	public Response deleteApplyOpportunity(@PathParam("id") Long id)
	{
		return applyOpportunityservice.deleteApplyOpportunityById(id);
	}
}
