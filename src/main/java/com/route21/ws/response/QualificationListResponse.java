package com.route21.ws.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.route21.ws.bean.Qualification;



public class QualificationListResponse extends Response{
	
	@JsonProperty("QUALIFICATIONLST")
	private List<Qualification> lstQualification;

	public List<Qualification> getLstQualification() {
		return lstQualification;
	}

	public void setLstQualification(List<Qualification> lstQualification) {
		this.lstQualification = lstQualification;
	}
	

}
