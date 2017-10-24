package com.route21.ws.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="APPLY_OPPORTUNITY")
public class ApplyOpportunity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="PTY_ID")
	private Party party;
	
	@ManyToOne
	@JoinColumn(name ="OPY_ID")
	private Opportunity opportunity;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "STATUS_REASON")
	private String statusReason;
	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "APPLY_DATE")
	private DateTime applyDate;
	
	
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

	public Opportunity getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(Opportunity opportunity) {
		this.opportunity = opportunity;
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
