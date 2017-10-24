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
import com.route21.ws.request.PartyQualificationRequest;
import com.route21.ws.response.PartyQualificationListResponse;
import com.route21.ws.response.PartyQualificationResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.PartyQualificationService;
import com.route21.ws.types.Role;


/**
 * 
 * This class gives the information about the qualification of party.
 * 
 * @author admin-pc
 *
 */

@RestController
@Path("/")
public class PartyQualificationController {

	@Autowired
	PartyQualificationService partyQualificationService;
	
	
	
	/**
	 * 
	 * This method used to insert the details about the qualification of party.
	 *
	 * @param request contains the attributes of {@link PartyQualificationRequest}.
	 * 
	 * @return the response status message.
	 * 
	 * @throws ParseException 
	 * 
	 */

	@JWTSecured(Role.STUDENT)
	@POST
	@Path(Route21Constants.SAVEPARTY_QUALIFICATION)
	@Produces("application/json")
	@Consumes("application/json")
	public PartyQualificationResponse savePartyQualification(PartyQualificationRequest request, @Context HttpServletRequest req) throws ParseException
	{
		Long pid = JWTokenUtility.Jwtdecoder(req);
		if(pid.longValue()== request.getPartyId())
		{
			return partyQualificationService.savePartyQualification(request);
		}
		
		else throw new OperationProhibitedException("You are not allowed to proceed.");
		
	}
	
	/**
	 * 
	 * This method is used to update the records in PartyQualification table.
	 * 
	 * @param id contains id to update based on Party id.
	 * 
	 * @param1 request contains attribute of {@link PartyQualificationRequest}.
	 * 
	 * @return the response status message.
	 * 
	 * @throws ParseException 
	 * 
	 */
	

	@JWTSecured(Role.STUDENT)
	@PUT
	@Path(Route21Constants.UPDATEPARTY_QUALIFICATION)
	@Produces("application/json")
	@Consumes("application/json")
	public PartyQualificationResponse updatePartyQualification(@PathParam("id") Long id, PartyQualificationRequest request, @Context HttpServletRequest req) throws ParseException
	{
		Long pid = JWTokenUtility.Jwtdecoder(req);
		
		if(pid.longValue()== request.getPartyId())
		{
			return partyQualificationService.updatePartyQualification(id,request);
		}
		
		else throw new OperationProhibitedException("You are not allowed to proceed.");
	}
	
	/**
	 * 
	 * This method is used to list out the records in PartyQualification table.
	 * 
	 * @param contains party id to  get the records by party id.
	 * 
	 * @return {@link ListPartyQualification Response} to retrieve the list of all records in PartyQualification  table.
	 * 
	 */
	
	@GET
	@Path(Route21Constants.GET_QUALIFICATIONBY_PARTYID)
	@Produces("application/json")
	public PartyQualificationListResponse getPartQualificationByPartyId(@PathParam("partyId") Long partyId)
	{
		return partyQualificationService.getPartQualificationByPartyId(partyId);
		
	}
	
	/**
	 * 
	 * This method is for  delete the details in PartyQualification table.
	 * 
	 * @param id contains id of party.
	 * 
	 * @return the response status message.
	 * 
	 * @throws ParseException 
	 *
	 */

	@JWTSecured(Role.STUDENT)
	@DELETE
	@Path(Route21Constants.DELETE_QUALIFICATIONBY_ID)
	@Produces("application/json")
	public Response deletePartyQualification(@PathParam("id") Long id, @PathParam("partyId") Long ptyId, @Context HttpServletRequest req) throws ParseException
	{
		Long pid = JWTokenUtility.Jwtdecoder(req);
		
		if(pid.longValue()==ptyId.longValue())
		{
		return partyQualificationService.deletePartyQualificationById(id);
		}
		
		else throw new OperationProhibitedException("You are not allowed to proceed.");
	}
	
}
