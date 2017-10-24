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

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * 
 * This is the PartyActivity bean class, it implements serializable object.
 * 
 * It contains some properties to get and set this values.
 * 
 * using @entity create a table in data base.
 * 
 * @author admin-pc
 *
 */
@Entity
@Table(name = "PARTY_ACTIVITY")
public class PartyActivity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3564386788068288950L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="SHORT_DESCRIPTION")
	private String shortDescription;	
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "PTY_ID" ,nullable = false)
	private Party party;
	
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "ACT_ID" ,nullable = false)
	private ActivityType activityType;

	@Column(name="ORDER_ID")
	private long orderId;
	
	@Column(name="IMAGE_1")
	private String image_1;
	
	@Column(name="IMAGE_2")
	private String image_2;
	
	@Column(name="IMAGE_3")
	private String image_3;
	
	@Column(name="IMAGE_4")
	private String image_4;
	
	@Column(name="ACT_DATE")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime actDate;
	
	
	public DateTime getActDate() {
		return actDate;
	}


	public void setActDate(DateTime actDate) {
		this.actDate = actDate;
	}


	public ActivityType getActivityType() {
		return activityType;
	}


	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}


	public String getImage_2() {
		return image_2;
	}


	public void setImage_2(String image_2) {
		this.image_2 = image_2;
	}


	public String getImage_3() {
		return image_3;
	}


	public void setImage_3(String image_3) {
		this.image_3 = image_3;
	}


	public String getImage_4() {
		return image_4;
	}


	public void setImage_4(String image_4) {
		this.image_4 = image_4;
	}


	public String getImage_1() {
		return image_1;
	}


	public void setImage_1(String image_1) {
		this.image_1 = image_1;
	}


	public long getId() {
		return id;
	}

	
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
