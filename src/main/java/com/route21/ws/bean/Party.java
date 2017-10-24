package com.route21.ws.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * This is the Party bean class, it implements serializable object.
 * 
 * It contains some properties to get and set this values.
 * 
 * using @entity create a table in data base.
 * 
 * @author admin-pc
 *
 */
@Entity
@Table(name = "PARTY")
public class Party implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 935709957342042399L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="ID")
	private long id;
	
	
	@Column(name="NAME")
	private String name;	
	
	
	@Column(name="EMAIL")
	private String email;
	
	
	@Column(name="IMAGE")
	private String image;	
	
	@Column(name="SOCIAL_MEDIA")
	private String socialMedia;	
	
	@Column(name="DESCRIPTION")
	private String description;
	
	
	@ManyToOne
	@JoinColumn(name="PTY_TYPE_ID")
	private PartyType partyType;
	
	@Column(name="DOB")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dob;
	
	
	@Column(name="TELL_NO")
	private String mobileno;
	
	
	@Column(name="INDUSTRY_TYPE")
	private String industryType;

	@Column(name="ONBOARD_SCREEN")
	private String onBoardScreen;
	
	@Column(name="EMPLOYER_WEBSITE")
	private String employerWebsite;
	
	
	@Column(name="LOCATION")
	private String location;
	
	
	public String getSocialMedia() {
		return socialMedia;
	}

	public void setSocialMedia(String socialMedia) {
		this.socialMedia = socialMedia;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmployerWebsite() {
		return employerWebsite;
	}

	public void setEmployerWebsite(String employerWebsite) {
		this.employerWebsite = employerWebsite;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public DateTime getDob() {
		
		return dob;
		
	}

	public void setDob(DateTime dob) {
		this.dob = dob;
	}

	public long getId() {
		
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PartyType getPartyType() {
		return partyType;
	}

	public void setPartyType(PartyType partyType) {
		this.partyType = partyType;
	}

    public String getOnBoardScreen() {
        return onBoardScreen;
    }

    public void setOnBoardScreen(String onBoardScreen) {
        this.onBoardScreen = onBoardScreen;
    }

	
	
}
