package com.route21.ws.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.route21.ws.bean.Contact;

public class ListContactResponse extends Response {
	
	@JsonProperty("CONTACT_LIST")
	private List<Contact> contact;

	public List<Contact> getContact() {
		return contact;
	}

	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}
	
	
}