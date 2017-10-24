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

/**
 * 
 * This is the Activity bean class, it implements serializable object.
 * 
 * It contains some properties to get and set this values.
 * 
 * using @entity create a table in data base.
 * 
 * @author admin-pc
 *
 */
@Entity
@Table(name="ACTIVITY")
public class Activity implements Serializable{

	
	private static final long serialVersionUID = 4581255879356588210L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="ACT_TYPE_ID")
	private ActivityType activityType;
	
	@ManyToOne
	@JoinColumn(name ="PTY_TYPE_ID")
	private PartyType ptyType;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	public PartyType getPtyType() {
		return ptyType;
	}

	public void setPtyType(PartyType ptyType) {
		this.ptyType = ptyType;
	}


}
