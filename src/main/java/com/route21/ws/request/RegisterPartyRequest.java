package com.route21.ws.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown= true)
public class RegisterPartyRequest {	


	@JsonProperty("NAME")
	private String name;	
	
	@JsonProperty("LAST_NAME")
	private String lastName;
	
	
	@JsonProperty("EMAIL")	
	private String email;
	
	@JsonProperty("PASSWORD")
	private String password;
	
	@JsonProperty("PARTY_TYPE")
	private long partyType;
	
	
	@JsonProperty("PARTY_NAME")
	private String partyName;
	
	
	@JsonProperty("MOB_NO")
	private String mobileno;
	
	@JsonProperty("STATUS")
	private String status;
	
	@JsonProperty("INDUSTRY_TYPE")
	private String indusrtyType;
	
	@JsonProperty("ONBOARD_SCREEN")
    private String onBoardScreen;
	
	@JsonProperty("EMPLOYER_WEBSITE")
	private String employerWebsite;
	
	@JsonProperty("SOCIAL_MEDIA")
	private String socialMedia;
	
	public String getEmployerWebsite() {
		return employerWebsite;
	}
	public void setEmployerWebsite(String employerWebsite) {
		this.employerWebsite = employerWebsite;
	}
	public String getIndusrtyType() {
		return indusrtyType;
	}
	public void setIndusrtyType(String indusrtyType) {
		this.indusrtyType = indusrtyType;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPartyType() {
		return partyType;
	}
	public void setPartyType(long partyType) {
		this.partyType = partyType;
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
