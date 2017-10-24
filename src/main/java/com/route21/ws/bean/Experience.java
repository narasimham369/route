package com.route21.ws.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EXPERIENCE")
public class Experience {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="PTY_ID")
	private Party party;
	
	@Column(name="WORK_PLACE")
	private String workPlace;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="JOB_TITLE")
	private String jobTitle;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="START_YEAR")
	private long startYear;

	@Column(name="START_MONTH")
	private String startMonth;
	
	@Column(name="ORDER_ID")
	private long orderId;
	
	@Column(name="END_YEAR")
	private long endYear;

	@Column(name="END_MONTH")
	private String endMonth; 
	
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getStartYear() {
		return startYear;
	}

	public void setStartYear(long startYear) {
		this.startYear = startYear;
	}

	

	public long getEndYear() {
		return endYear;
	}

	public void setEndYear(long endYear) {
		this.endYear = endYear;
	}

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}

}
