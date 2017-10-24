package com.route21.ws.request;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * This class used to  pass the OpportunityRequest for the client.
 *
 * @author admin-pc
 *
 */

@JsonIgnoreProperties(ignoreUnknown= true)
public class OpportunityRequest {
	
	
	@JsonProperty("ID")
	private long id;
	
	@JsonProperty("PTY_ID")
	private long  partyId;
	

	@JsonProperty("TITLE")
	private String title;
	
	
	@JsonProperty("LOCATION")
	private String location;
	
	@JsonProperty("DESIRED_SKILLS")
	private String desiredSkills;

	@JsonProperty("SHORT_DESCRIPTION")
	private String shortDescription;
	
	@JsonProperty("TYPE")
	private String type;
	
	@JsonProperty("CAT_NAME")
	private String categoryName;
	
	@JsonProperty("OPT_NAME")
	private String oppurtunityName;
	
	@JsonProperty("DESCRIPTION")
	private String description;
	
	@JsonProperty("HOW_TO_APPLY")
	private String howToApply;
	
	@JsonProperty("LINK_REF")
	private String linkRef;
	
	@JsonProperty("STATUS")
	private String status;
	
	@JsonProperty("ROLE")
	private String role;
	
	@JsonProperty("DEPARTMENT")
	private String department;
	
	@JsonProperty("MIN_WAGE")
	private double minWage;
	
	@JsonProperty("LIVE_OR_FUTURE")
	private String liveOrFuture;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@JsonProperty("START_DATE")
	private DateTime startDate;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@JsonProperty("END_DATE")
	private DateTime endDate;
	
	@JsonProperty("DURATION")
	private String duration;
	
	@JsonProperty("QUAL_NAME")
	private String qualificationName;
	
	@JsonProperty("MIN_AGE")
	private int minAge;
	
	@JsonProperty("WAGE_TYPE")
	@NotNull(message = "wage type should not be null")
	private String wageType;
	
	
	public String getWageType() {
		return wageType;
	}

	public void setWageType(String wageType) {
		this.wageType = wageType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getMinWage() {
		return minWage;
	}

	public void setMinWage(double minWage) {
		this.minWage = minWage;
	}

	public String getLiveOrFuture() {
		return liveOrFuture;
	}

	public void setLiveOrFuture(String liveOrFuture) {
		this.liveOrFuture = liveOrFuture;
	}

	
	public DateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	public DateTime getEndDate() {
		
		return endDate;
	}

	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getQualificationName() {
		return qualificationName;
	}

	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getPartyId() {
		return partyId;
	}

	public void setPartyId(long partyId) {
		this.partyId = partyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDesiredSkills() {
		return desiredSkills;
	}

	public void setDesiredSkills(String desiredSkills) {
		this.desiredSkills = desiredSkills;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getOppurtunityName() {
		return oppurtunityName;
	}

	public void setOppurtunityName(String oppurtunityName) {
		this.oppurtunityName = oppurtunityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHowToApply() {
		return howToApply;
	}

	public void setHowToApply(String howToApply) {
		this.howToApply = howToApply;
	}

	public String getLinkRef() {
		return linkRef;
	}

	public void setLinkRef(String linkRef) {
		this.linkRef = linkRef;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	
	
	
}
