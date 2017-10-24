package com.route21.ws.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.route21.ws.bean.Experience;

public class ExperienceListResponse extends Response{

	@JsonProperty("EXPERIENCElIST")
	private List<Experience> lstExp;

	public List<Experience> getLstExp() {
		return lstExp;
	}

	public void setLstExp(List<Experience> lstExp) {
		this.lstExp = lstExp;
	}
	
	
}
