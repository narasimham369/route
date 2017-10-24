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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
* 
* This is the UserLogin bean class, it implements serializable object.
* 
* It contains some properties to get and set this values.
* 
* using @entity create a table in data base.
* 
* @author admin-pc
*
*/
@Entity
@Table(name="USER_LOGIN")
public class UserLogin implements Serializable {

	
	private static final long serialVersionUID = -2271484382397421729L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "ID")	
	private long id;
	

	@Column(name="LOGIN_ID")
	private String loginId;	
	
	@JsonIgnore
	@Column(name="LOGIN_PASSWORD")
	private String loginPassword;
	
	
	@Column(name="VERIFY_CODE")
	private String verifyCode;
	
	
	@Column(name="VERIFY_STATUS")
	private String verifyStatus;
	

	@Column(name = "COOKIE")
	private String cookie;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PTY_ID")
	private Party party;
	
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	
	@Column(name="LAST_NAME")
	private String lastName;
	


	

	@Column(name="GENDER")
	private String gender;
	
		
	
	@Column(name="STATUS")
	private String status;
	
	
	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name="UPDATED_DATE")
	private DateTime updatedDate;	
	

	/**
	 * 
	 * This is the method to get the user id.
	 * 
	 * @return user id.
	 * 
	 */
	public long getId() {
		return id;
	}

	/**
	 * 
	 * This is the method to set the  id.
	 * 
	 * @param id  id.
	 * 
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 
	 * This is the method to get the login id.
	 * 
	 * @return login id.
	 * 
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * 
	 * This is the method to set the login id.
	 * 
	 * @param loginId. user has this login id.
	 * 
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * 
	 * This is the method to get the login password.
	 * 
	 * @return login password.
	 * 
	 */
	public String getLoginPassword() {
		return loginPassword;
	}

	/**
	 * 
	 * This is the method to set the login password.
	 * 
	 * @param loginPassword user password.
	 * 
	 */
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	/**
	 * 
	 * This is the method to get the VerifyCode.
	 * 
	 * @return verify code.
	 * 
	 */
	public String getVerifyCode() {
		return verifyCode;
	}

	/**
	 * 
	 * This is the method to set the VerifyCode.
	 * @param verifyCode.
	 * 
	 */
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	/**
	 * 
	 * This is the method to get the VerifyStatus.
	 * 
	 * @return verifyStatus the status of the user logged in or not.
	 * 
	 */
	public String getVerifyStatus() {
		return verifyStatus;
	}

	/**
	 * 
	 * This is the method to set the VerifyStatus.
	 *
	 * @param verifyStatus the status of the user.
	 * 
	 */
	public void setVerifyStatus(String verifyStatus) {
		this.verifyStatus = verifyStatus;
	}

	/**
	 * 
	 * This is the method to get the Party.
	 * 
	 * @return party the user who will registered.
	 * 
	 */
	public Party getParty() {
		return party;
	}

	/**
	 * 
	 * This is the method to set the party.
	 * 
	 * @param party it has details about the user.
	 * 
	 */
	public void setParty(Party party) {
		this.party = party;
	}

	/**
	 * 
	 * This is the method to get the Cookie.
	 * 
	 * @return cookie address of the object.
	 * 
	 */
	public String getCookie() {
		return cookie;
	}

	/**
	 * 
	 * This is the method to set the Cookie.
	 * 
	 * @param cookie address of the object.
	 */
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	/**
	 * 
	 * This is the method to get FirstName.
	 * 
	 * @return firstName name of the user.
	 * 
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * This is the method to set FirstName.
	 * 
	 * @param firstName user's first name.
	 * 
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * This is the method to get LastName.
	 * 
	 * @return lastName user's last name.
	 * 
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * This is the method to set last name.
	 * 
	 * @param lastName user's last name.
	 * 
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
	/**
	 * 
	 * This is the method to get the gender.
	 * 
	 * @return gender of the user.
	 * 
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * 
	 * This is the method to set the gender.
	 * 
	 * @param gender user's gender.
	 * 
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
/**
 * 
 * This is the method to get status of the user.
 * 
 * @return status user's status.
 * 
 */
	public String getStatus() {
		return status;
	}

	/**
	 * 
	 * This is the method to set status of the user.
	 * 
	 * @param status user's status.
	 * 
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 
	 * This is the method to get updated date.
	 * 
	 * @return updatedDate present date.
	 * 
	 */
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	

	/**
	 * 
	 * This is the method to get updated date.
	 * 
	 * @param updatedDate present date.
	 */
	

	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	
	


}
