package com.route21.ws.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DefaultValue;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * 
 * This is the Opportunity bean class, it implements serializable object.
 * 
 * It contains some properties to get and set this values.
 * 
 * using @entity create a table in data base.
 * 
 * @author admin-pc
 *
 */
@Entity
@Table(name = "OPPORTUNITY")
public class Opportunity implements Serializable {

	private static final long serialVersionUID = -7341664029978931484L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;


	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "PTY_ID", nullable = false)
	private Party party;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "DESIRE_SKILLS")
	private String desiredSkills;

	@Column(name = "TYPE")
	private String type;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "CAT_ID")
	private Category category;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "OPT_ID")
	private OpportunityType opportunityType;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "HOW_TO_APPLY")
	private String howToApply;

	@Column(name = "LINK_REF")
	private String linkRef;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "ROLE")
	private String role;

	@Column(name = "DEPARTMENT")
	private String department;

	@Column(name = "MIN_WAGE")
	private double minWage;

	@Column(name = "LIVE_OR_FUTURE")
	private String liveOrFuture;
	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "START_DATE")
	private DateTime startDate;

	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "END_DATE")
	private DateTime endDate;

	@Column(name = "DURATION")
	private String duration;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "QUAL_ID")
	private Qualification qualification;

	@Column(name = "MIN_AGE")
	private int minAge;

	@Column(name = "WAGE_TYPE")
	@NotNull(message = "wage type should not be null")
	private String wageType;
	
	@Column(name = "SHORT_DESCRIPTION")
	private String shortDescription;
	
	public String getWageType() {
		return wageType;
	}

	public void setWageType(String wageType) {
		this.wageType = wageType;
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

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public OpportunityType getOpportunityType() {
		return opportunityType;
	}

	public void setOpportunityType(OpportunityType opportunityType) {
		this.opportunityType = opportunityType;
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
