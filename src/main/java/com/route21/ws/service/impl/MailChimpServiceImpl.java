package com.route21.ws.service.impl;

import java.io.IOException;

import javax.transaction.Transactional;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.springframework.stereotype.Service;

import com.route21.ws.request.MailChimpSubscriptionRequest;
import com.route21.ws.service.MailChimpService;

@Service
@Transactional
public class MailChimpServiceImpl implements MailChimpService {

	@Override
	public com.route21.ws.response.Response subscribeMail(MailChimpSubscriptionRequest request) throws IOException {

		ClientConfig clientConfig = new ClientConfig();
		 
	    HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("anything", "586fdc5e7e5eaeac1e369bd5c93fdb8b-us13");
	    clientConfig.register( feature) ;
	 
	    clientConfig.register(JacksonFeature.class);
		
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target("https://us13.api.mailchimp.com/3.0/lists/ee6aab2ea6").path("members");
		 
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);		
		Response response = invocationBuilder.post(Entity.entity(request, MediaType.APPLICATION_JSON));
		 

		com.route21.ws.response.Response res = new com.route21.ws.response.Response();
		if(response.getStatus()==200)
		{
		
			res.setStatusCode(200);
			res.setStatusMessage("Subscribed Successfully");
		}
		
		     
		System.out.println(response.getStatus());
	
		return res;
	
	}

}
