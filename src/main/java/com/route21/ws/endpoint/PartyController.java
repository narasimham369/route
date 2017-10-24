package com.route21.ws.endpoint;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
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
import com.route21.ws.request.RegisterPartyRequest;
import com.route21.ws.request.UpdatePartyRequest;
import com.route21.ws.response.NameListResponse;
import com.route21.ws.response.RegisterPartyResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.PartyService;
import com.route21.ws.types.Role;


/**
 * This class gives information related to party
 * 
 * @author viswanath
 *
 */

@RestController
@Path("/")
public class PartyController {
	private static final Logger LOGGER = LoggerFactory.getLogger(PartyController.class);
	
	@Autowired
	protected PartyService partyService;
	

	/**
	 * This method is used to register new customer
	 * 
	 * @param request
	 * 				contains attribute of {@link RegisterPartyRequest}
	 * 
	 * @return {@link RegisterPartyResponse}
	 */
	@POST
	@Path(Route21Constants.REGISTER_PARTY)
	@Produces("application/json")
	@Consumes("application/json")
	public RegisterPartyResponse registerParty(RegisterPartyRequest request)
	{	
		
		return partyService.regiterParty(request);
		
	}
	
	/**
	 * 
	 * This method is used to get NameListofEmployeer and Institute.
	 *  
	 * @return getNameListofEmployeerandInstitute to get the records of NameListofEmployeer and Institute.
	 * 
	 * @throws IOException 
	 * 
	 * @throws ParseException 
	 * 
	 */
	
	@PUT
	@JWTSecured({Role.STUDENT, Role.EMPLOYER})
	@Path(Route21Constants.UPDATE_PARTY)
	@Produces("application/json")
	@Consumes("application/json")
	public Response updateParty(@PathParam("id") Long id,UpdatePartyRequest request, @Context HttpServletRequest req) throws IOException, ParseException
	{
		Long pid = JWTokenUtility.Jwtdecoder(req);
		
		if(pid.longValue()==id.longValue())
		{
			return partyService.updateparty(id,request);
		}
		
		else throw new OperationProhibitedException("You are not allowed to proceed.");
	}
	
	
	
	
	/*@PUT
	@Path(Route21Constants.UPDATE_PARTY)
	@Produces("application/json")
	@Consumes("application/json")
	public Response updateParty(@PathParam("id") Long id,UpdatePartyRequest request) throws IOException
	{	
		System.out.println("reach controller");
		return partyService.updateparty(id,request);		
	}*/
	
		
	
	@GET
	@Path(Route21Constants.ORGANDINSPARTY_LIST)
	@Produces("application/json")
	public NameListResponse getNameListofEmployeerandInstitute()
	{		
		return partyService.getNameListofEmployeerandInstitute();
		
	}
	
}
