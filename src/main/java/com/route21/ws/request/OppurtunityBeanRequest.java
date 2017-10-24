package com.route21.ws.request;

import javax.ws.rs.QueryParam;

import org.joda.time.DateTime;

public class OppurtunityBeanRequest {	

	@QueryParam("location")
	private String location;
	
	@QueryParam("optid")
	private long optid;
	
	public long getOptid() {
		return optid;
	}

	public void setOptid(long optid) {
		this.optid = optid;
	}

	@QueryParam("type")
	private String type;
	
	@QueryParam("opttype")
	private String optType;
	
	@QueryParam("category")
	private String category;
	
	@QueryParam("organisation")
	private String organisation;
	
	@QueryParam("title")
	private String title;
	
	@QueryParam("role")
	private String role;
	
	@QueryParam("department")
	private String department;
	
	@QueryParam("minwage")
	private double minWage;
	
	@QueryParam("lorf")
	private String liveOrFuture;
	
	@QueryParam("startdate")
	private DateTime startDate;
	
	@QueryParam("enddate")
	private DateTime endDate;
	
	@QueryParam("duration")
	private String duration;
	
	@QueryParam("qualification")
	private String minQualification;
	
	@QueryParam("age")
	private int minAge;
	
	@QueryParam("skills")
	private String desiredSkills;
	
	@QueryParam("orgId")
	private long orgId;

	@QueryParam("status")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getMinQualification() {
		return minQualification;
	}

	public void setMinQualification(String minQualification) {
		this.minQualification = minQualification;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public String getDesiredSkills() {
		return desiredSkills;
	}

	public void setDesiredSkills(String desiredSkills) {
		this.desiredSkills = desiredSkills;
	}

	public String getOptType() {
		return optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}

	
}
