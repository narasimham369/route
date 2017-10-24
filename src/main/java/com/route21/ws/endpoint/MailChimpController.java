package com.route21.ws.endpoint;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.route21.ws.request.MailChimpSubscriptionRequest;
import com.route21.ws.service.MailChimpService;

@RestController
@Path("/")
public class MailChimpController {
	
	@Autowired
	MailChimpService mailChimpService;
	
	@POST
	@Path("/subscribe")
	@Produces("application/json")
	@Consumes("application/json")
	public com.route21.ws.response.Response subscribeMail(MailChimpSubscriptionRequest request) throws IOException
	{
		return mailChimpService.subscribeMail(request);
		
	}

}
