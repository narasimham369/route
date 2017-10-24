package com.route21.ws.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.route21.ws.bean.Qualification;




public class QualificationResponse extends Response{
	
	@JsonProperty("QUALIFICATION")
	private Qualification qualification;

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

}
