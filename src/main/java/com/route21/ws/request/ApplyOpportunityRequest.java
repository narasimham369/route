package com.route21.ws.request;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown= true)
public class ApplyOpportunityRequest {

	@JsonProperty("ID")
	private long id;
	
	@JsonProperty("PTY_ID")
	private long partyId;
	
	@JsonProperty("OPY_ID")
	private long opportunityId;
	
	@JsonProperty("STATUS")
	private String status;
	
	@JsonProperty("STATUS_REASON")
	private String statusReason;

	@JsonFormat(pattern="dd-MM-yyyy")
	@JsonProperty("APPLY_DATE")
	private DateTime applyDate;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public long getPartyId() {
		return partyId;
	}

	public void setPartyId(long partyId) {
		this.partyId = partyId;
	}

	public long getOpportunityId() {
		return opportunityId;
	}

	public void setOpportunityId(long opportunityId) {
		this.opportunityId = opportunityId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusReason() {
		return statusReason;
	}

	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}

	
	public DateTime getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(DateTime applyDate) {
		this.applyDate = applyDate;
	}

	
	
}
