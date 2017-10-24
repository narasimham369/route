package com.route21.ws.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.joda.time.DateTime;

/**
 * 
 * This is the Contact bean class, it implements serializable object.
 * 
 * It contains some properties to get and set this values.
 * 
 * using @entity create a table in data base.
 * 
 * @author admin-pc
 *
 */
@Entity
@Table(name="CONTACT_US")
public class Contact implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 935709957342042399L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@NotNull
	@Column(name="FIRST_NAME")	
	private String firstName;
	
	@Column(name="MIDDLE_NAME")
	private String middleName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	@NotNull(message="please enter your email")
	@Email
	private String email;
	
	@Column(name="MESSAGE")
	private String message;	

	@Temporal(TemporalType.TIMESTAMP)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name="CONTACT_DATE")
	private DateTime contactDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DateTime getContactDate() {
		return contactDate;
	}

	public void setContactDate(DateTime contactDate) {
		this.contactDate = contactDate;
	}

}