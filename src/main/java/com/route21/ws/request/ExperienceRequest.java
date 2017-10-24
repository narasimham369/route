package com.route21.ws.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown= true)
public class ExperienceRequest {

	@JsonProperty("ID")
	private long id;
	
	@JsonProperty("PTY_ID")
	private long ptyId;
	
	@JsonProperty("WORK_PLACE")
	private String workPlace;
	
	@JsonProperty("LOCATION")
	private String location;
	
	@JsonProperty("JOB_TITLE")
	private String jobTitle;
	
	@JsonProperty("DESCRIPTION")
	private String Decription;
	
	@JsonProperty("START_YEAR")
	private long startYear;
	
	@JsonProperty("START_MONTH")
	private String startMonth;
	
	@JsonProperty("ORDER_ID")
	private long orderId;
	
	@JsonProperty("END_YEAR")
	private long endYear;
	
	@JsonProperty("END_MONTH")
	private String endMonth;
	
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPtyId() {
		return ptyId;
	}

	public void setPtyId(long ptyId) {
		this.ptyId = ptyId;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDecription() {
		return Decription;
	}

	public void setDecription(String decription) {
		Decription = decription;
	}

	public long getStartYear() {
		return startYear;
	}

	public void setStartYear(long startYear) {
		this.startYear = startYear;
	}

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public long getEndYear() {
		return endYear;
	}

	public void setEndYear(long endYear) {
		this.endYear = endYear;
	}

	public String getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}

	
	
	
}
