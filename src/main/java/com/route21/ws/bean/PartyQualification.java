package com.route21.ws.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
* 
* This is the PartyQualification bean class, it implements serializable object.
* 
* It contains some properties to get and set this values.
* 
* using @entity create a table in data base.
* 
* @author admin-pc
*
*/
@Entity
@Table(name = "PARTY_QUALIFICATION")
public class PartyQualification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "PTY_ID" ,nullable = false)
	private Party party;
	
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "QUL_ID")
	private Qualification qualification;
	
	@Column(name = "INSTITUTION_NAME")
	private String instituttionName;
	
	@Column(name="MAJOR")
	private String major;
	
	@Column(name = "STARTED_ON")
	private int startedOn;
	
	@Column(name = "COMPLETED_ON")
	private int CompletedOn;
	
	@Column(name = "GRADE")
	private String grade;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "EXTERNAL_LINK")
	private String externalLink;
	
	@Column(name = "ORDER_ID")
	private int orderId;

	@Column(name= "OTHER_QUALIFICATION")
	private String otherQualification;
	
	@Column(name= "LOCATION")
	private String location;
	
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOtherQualification() {
		return otherQualification;
	}

	public void setOtherQualification(String otherQualification) {
		this.otherQualification = otherQualification;
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

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	public String getInstituttionName() {
		return instituttionName;
	}

	public void setInstituttionName(String instituttionName) {
		this.instituttionName = instituttionName;
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
		return CompletedOn;
	}

	public void setCompletedOn(int completedOn) {
		CompletedOn = completedOn;
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

	public String getExternalLink() {
		return externalLink;
	}

	public void setExternalLink(String externalLink) {
		this.externalLink = externalLink;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

}
