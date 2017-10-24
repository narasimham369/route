package com.route21.ws.endpoint;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
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
import com.route21.ws.request.OpportunityRequest;
import com.route21.ws.request.OppurtunityBeanRequest;
import com.route21.ws.response.OpportunityListResponse;
import com.route21.ws.response.OpportunityResponse;
import com.route21.ws.service.OpportunityService;
import com.route21.ws.types.Role;

/**
 * 
 * This class gives Opportunity details.
 * 
 * @author admin-pc
 *
 */
@RestController
@Path("/")
public class OpportunityController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OpportunityController.class);
	/**
	 * It inject {@link OpportunityService} object
	 */
	@Autowired
	OpportunityService opportunityservice;
	

	/**
	 * 
	 * This method is used to insert details in Opportunity table.
	 * 
	 * @param request contains attribute of {@link OpportunityRequest}
	 * 
	 * @return the response status message.
	 * 
	 * @throws ParseException 
	 * 
	 */

	@JWTSecured(Role.EMPLOYER)
	@POST
	@Path(Route21Constants.SAVE_OPPORTUNITY)
	@Produces("application/json")
	@Consumes("application/json")
	public OpportunityResponse saveOpportunity(OpportunityRequest request, @Context HttpServletRequest req) throws ParseException{
		Long pid = JWTokenUtility.Jwtdecoder(req);
		if(pid.longValue()== request.getPartyId())
		{
			System.out.println("REACHED CONTROLLER");
			return opportunityservice.saveOpportunity(request);
		}
		
		else throw new OperationProhibitedException("You are not allowed to proceed.");

	}
	

	/**
	 * 
	 * This method is used to update the records in Opportunity table.
	 * 
	 * @param id contains id to update based on id.
	 * 
	 * @param1 request contains attribute of {@link OpportunityRequest}.
	 * 
	 * @return the response status message.
	 * 
	 * @throws ParseException 
	 * 
	 */

	@JWTSecured(Role.EMPLOYER)
	@PUT
	@Path(Route21Constants.UPDATE_OPPORTUNITY)
	@Produces("application/json")
	@Consumes("application/json")
	public OpportunityResponse updateOpportunity(@PathParam("id") Long id, OpportunityRequest request, @Context HttpServletRequest req) throws ParseException{
		Long pid = JWTokenUtility.Jwtdecoder(req);
		if(pid.longValue()== request.getPartyId())
		{
			System.out.println("REACHED CONTROLLER");
			return opportunityservice.updateOpportunity(id,request);
		}
	
		else throw new OperationProhibitedException("You are not allowed to proceed.");

	}
	

	/**
	 * 
	 * This method is used to list out the records in Opportunity table.
	 * 
	 * @return {@link ListOpportunityResponse} to retrieve the list of all records in Opportunity table.
	 * 
	 */

	@GET
	@Path(Route21Constants.GET_OPPORTUNITY)
	@Produces("application/json")
	public OpportunityListResponse getOpportunity(@BeanParam OppurtunityBeanRequest request){
		
		LOGGER.info("=====controller====");
		return opportunityservice.getOpportunity(request);
		
		
	}
	
	
}
