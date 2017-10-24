package com.route21.ws.request;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveContactRequest {
	
	@JsonProperty("FIRST_NAME")
	private String firstName;
	
	@JsonProperty("MIDDLE_NAME")
	private String middleName;
	
	@JsonProperty("LAST_NAME")
	private String lastName;
	
	@JsonProperty("EMAIL")
	private String email;
	
	@JsonProperty("MESSAGE")
	private String message;

	@JsonFormat(pattern="dd-MM-yyyy")
	@JsonProperty("CONTACT_DATE")
	private DateTime contactDate;
	
	
	public DateTime getContactDate() {
		return contactDate;
	}

	public void setContactDate(DateTime contactDate) {
		this.contactDate = contactDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
