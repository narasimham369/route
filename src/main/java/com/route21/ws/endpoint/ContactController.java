package com.route21.ws.endpoint;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.route21.ws.annotation.JWTSecured;
import com.route21.ws.constants.Route21Constants;
import com.route21.ws.request.SaveContactRequest;
import com.route21.ws.response.ListContactResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.ContactService;
import com.route21.ws.types.Role;


/**

 * ContactController class is front face for accessing and manipulating Contact(enquiry) related resource
 * 
 * @author viswanath
 *
 */

@RestController
@Path("/")
public class ContactController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);
	
	/**
	 * It inject {@link ContactService} object
	 */
	@Autowired
	protected ContactService contactService;
	
	
	/**
	 * This method is used to save the enquire details in Contact table.
	 * 
	 * @param request
	 *            contains attribute of {@link SaveContactRequest}
	 * @return the response status message
	 */
	
	@POST
	@Path(Route21Constants.CONTACT_US)
	@Produces("application/json")
	@Consumes("application/json")
	public Response saveContent(@Valid SaveContactRequest saveRequest) {
		LOGGER.debug("SAVE CONTACT METHOD");		
		return contactService.saveContact(saveRequest);		
	}
	
	/**
	 * 

	 * This method is used to list out the records in Content table.
	 * 
	 * @return {@link ListContactResponse} to retrieve the list of all records in Contact table.
	 * 
	 */

	@JWTSecured(Role.ADMIN)
	@GET
	@Path(Route21Constants.LIST_CONTACT)
	@Produces("application/json")
	public ListContactResponse listContact() {
		
		return contactService.listContact();
	}
	
}
