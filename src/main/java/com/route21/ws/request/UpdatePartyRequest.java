package com.route21.ws.request;


import java.util.Map;

import javax.persistence.Column;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class UpdatePartyRequest {
	
	@JsonProperty("DESCRIPTION")
	private String description;
	
	
	@JsonProperty("DOB")
	@JsonFormat(pattern="dd-MM-yyyy")
	private DateTime dob;
	
	@JsonProperty("IMAGE")
	private Map<String,String> image;
	
	@JsonProperty("NAME")
	private String name;
	
	@JsonProperty("ONBOARD_SCREEN")
    private String onBoardScreen;
	
	@JsonProperty("SOCIAL_MEDIA")
	private String socialMedia;
	
	@JsonProperty("EMPLOYER_WEBSITE")
	private String employerWebsite;
	
	@JsonProperty("LOCATION")
	private String location;
	
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DateTime getDob() {
		return dob;
	}

	public void setDob(DateTime dob) {
		this.dob = dob;
	}

	public Map<String, String> getImage() {
		return image;
	}

	public void setImage(Map<String, String> image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    public String getOnBoardScreen() {
        return onBoardScreen;
    }

    public void setOnBoardScreen(String onBoardScreen) {
        this.onBoardScreen = onBoardScreen;
    }
	public String getSocialMedia() {
		return socialMedia;
	}
	public void setSocialMedia(String socialMedia) {
		this.socialMedia = socialMedia;
	}

	
	
	
}
