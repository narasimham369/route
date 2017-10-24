package com.route21.ws.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PartyQualificationRequest {
	
	@JsonProperty("PTY_ID")
	private long partyId;
	
	@JsonProperty("QUL_ID")
	private long qualificationId;
	
	@JsonProperty("INS_NAME")
	private String instituteName;
	
	@JsonProperty("MAJOR")
	private String major;
	
	@JsonProperty("STARTED_ON")
	private int startedOn;
	
	@JsonProperty("COMPLETED_ON")
	private int completedOn;
	
	@JsonProperty("GRADE")
	private String grade;
	
	@JsonProperty("DESCRIPTION")
	private String description;
	
	@JsonProperty("ORDER_ID")
	private int orderId;	

	@JsonProperty("OTHER_QUALIFICATION")
	private String otherQualification;
	
	@JsonProperty("LOCATION")
	private String location;
	
	
	
	public long getPartyId() {
		return partyId;
	}

	public void setPartyId(long partyId) {
		this.partyId = partyId;
	}

	public long getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(long qualificationId) {
		this.qualificationId = qualificationId;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getStartedOn() {
		return startedOn;
	}

	public void setStartedOn(int startedOn) {
		this.startedOn = startedOn;
	}

	public int getCompletedOn() {
		return completedOn;
	}

	public void setCompletedOn(int completedOn) {
		this.completedOn = completedOn;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOtherQualification() {
		return otherQualification;
	}

	public void setOtherQualification(String otherQualification) {
		this.otherQualification = otherQualification;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	

}
