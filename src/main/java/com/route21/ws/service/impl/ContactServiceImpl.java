package com.route21.ws.service.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import com.route21.ws.bean.Contact;
import com.route21.ws.constants.EmailConstants;
import com.route21.ws.repository.ContactRepository;
import com.route21.ws.request.SaveContactRequest;
import com.route21.ws.response.ListContactResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.ContactService;
import com.route21.ws.util.EmailHtmlSender;
import com.route21.ws.util.EmailStatus;



@Service
public class ContactServiceImpl implements ContactService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContactServiceImpl.class);
	
	@Autowired
	protected ContactRepository contactRespositry;
	
	@Autowired
	protected EmailHtmlSender emailHtmlSender;

	@Override
	public Response saveContact(SaveContactRequest request) {
		Response response = new Response();		
		LOGGER.debug("Save contact");
		Contact contact = new Contact();		
		contact.setFirstName(request.getFirstName());
		contact.setMiddleName(request.getMiddleName());
		contact.setLastName(request.getLastName());
		contact.setEmail(request.getEmail());
		contact.setMessage(request.getMessage());
		contact.setContactDate(request.getContactDate());
		
		contactRespositry.saveAndFlush(contact);
		
		/*
		 * Email setup
		 */
		Context context = new Context();
		context.setVariable("firstname", request.getFirstName());
		context.setVariable("lastname", request.getLastName());
		context.setVariable("middlename", request.getMiddleName());
		context.setVariable("email", request.getEmail());
		context.setVariable("message", request.getMessage());
		EmailStatus emailStatus = emailHtmlSender.send("info@route21.org", EmailConstants.CONTACT_SUB, "email/contact-us", context);
		
		LOGGER.info("ERROR MESSAGE DETAILS "+emailStatus.getErrorMessage());
		LOGGER.info("EMAIL STATUS "+emailStatus.getStatus());
		
		response.setStatusCode(200);
		response.setStatusMessage("Contact stored successful");
		return response;
	}

	@Override
	public ListContactResponse listContact() {
		ListContactResponse response = new ListContactResponse();
		List<Contact> contact = contactRespositry.findAllByOrderByIdDesc();
		response.setContact(contact);
		response.setStatusCode(200);
		response.setStatusMessage("List all the contacts");
		return response;
	}
	

}
