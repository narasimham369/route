package com.route21.ws.endpoint;

import java.io.IOException;

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
import com.route21.ws.request.PartyActivityRequest;
import com.route21.ws.response.PartyActivityListResponse;
import com.route21.ws.response.PartyActivityResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.PartyActivityService;
import com.route21.ws.types.Role;

/**
 * 
 * This class gives activities of customer.
 * 
 * @author admin-pc
 *
 */

@RestController
@Path("/")
public class PartyActivityController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PartyActivityController.class);
	/**
	 * It inject {@link PartyActivityService} object
	 */
	@Autowired
	protected PartyActivityService partyActivityService;
	
	/**
	 * 
	 * This method is used to insert details in PartyActivity table.
	 * 
	 * @param request contains attribute of {@link PartyActivityRequest}
	 * 
	 * @return the response status message
	 * 
	 * @throws IOException 
	 * 
	 * @throws ParseException 
	 * 
	 */

	@JWTSecured({Role.STUDENT, Role.EMPLOYER})
	@POST
	@Path(Route21Constants.SAVEPARTY_ACTIVITY)
	@Produces("application/json")
	@Consumes("application/json")
	public PartyActivityResponse savePartyActivity(PartyActivityRequest request, @Context HttpServletRequest req) throws IOException, ParseException
	{
		System.out.println("Checking skills");
		Long pid = JWTokenUtility.Jwtdecoder(req);
		System.out.println("test pidlongvalue:"+pid.longValue());
		System.out.println("request ptyId:"+request.getPtyId());
		if(pid.longValue() == request.getPtyId())
		{
			System.out.println("enter Checking skills");
			return partyActivityService.savePartyActivity(request);
		}
		
		else
			throw new OperationProhibitedException("You are not allowed to proceed.");
		
	}
	
	/**
	 * 
	 * This method is used to update the records in PartyActivity table.endpoint
	 * 
	 * @param id contains id to update based on id.
	 * 
	 * @param1 request contains attribute of {@link PartyActivityRequest}.
	 * 
	 * @return the response status message.
	 * 
	 * @throws IOException 
	 * 
	 * @throws ParseException 
	 * 
	 */

	@JWTSecured({Role.STUDENT, Role.EMPLOYER})
	@PUT
	@Path(Route21Constants.UPDATEPARTY_ACTIVITY)
	@Produces("application/json")
	@Consumes("application/json")
	public PartyActivityResponse updatePartyActivity(@PathParam("id") Long id, PartyActivityRequest request, @Context HttpServletRequest req) throws IOException, ParseException
	{
		Long pid = JWTokenUtility.Jwtdecoder(req);
		System.out.println("reached controller");
		if(pid.longValue() == request.getPtyId())
		{
		
			return partyActivityService.updatePartyActivity(id,request);
		}
		
		else throw new OperationProhibitedException("You are not allowed to proceed.");
		
	}
	/**
	 * 
	 * This method is used to list out the records in PartyActivity table.
	 * 
	 * @param contains party id to  get the records by party id.
	 * 
	 * @return {@link LisPartyActivityResponse} to retrieve the list of all records in PartyActivity table.
	 * 
	 */
	@GET
	@Path(Route21Constants.GETPARTY_ACTIVITYBY_PARTYID)
	@Produces("application/json")
	@Consumes("application/json")
	public PartyActivityListResponse getPartyActivityById(@PathParam("partyId") Long partyId)
	{
		return partyActivityService.getPartyActivityById(partyId);
		
	}
	
	/**
	 * 
	 * This method is for  delete the details in PartyActivity table.
	 * 
	 * @param id contains id of party.
	 * 
	 * @return the response status message.
	 * 
	 * @throws ParseException 
	 *
	 */

	@JWTSecured({Role.STUDENT, Role.EMPLOYER})
	@DELETE
	@Path(Route21Constants.DELETE_PARTYACTIVITYBY_ID)
	@Produces("application/json")
	public Response deletePartyActivity(@PathParam("id") Long id,@PathParam("partyId") Long ptyId, @Context HttpServletRequest req) throws ParseException
	{
		Long pid = JWTokenUtility.Jwtdecoder(req);
		System.out.println("ass::"+ptyId+"sfdgf::"+pid);
		if(pid.longValue()==ptyId.longValue())
		{
			System.out.println("partyActivityId "+id);
			return partyActivityService.deletePartyActivityById(id);
		}
		
		else throw new OperationProhibitedException("You are not allowed to proceed.");

	}
}
