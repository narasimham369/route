package com.route21.ws.service;

import com.route21.ws.request.SaveContactRequest;
import com.route21.ws.response.ListContactResponse;
import com.route21.ws.response.Response;

public interface ContactService {
	
	public Response saveContact(SaveContactRequest saveRequest);
	
	public ListContactResponse listContact();
}