package com.route21.ws.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
* 
* This is the Story bean class, it implements serializable object.
* 
* It contains some properties to get and set this values.
* 
* using @entity create a table in data base.
* 
* @author admin-pc
*
*/
@Entity
@Table(name = "STORY")
public class Story {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	@JsonProperty("ID")
	private long id;
	
	@Column(name = "TITLE")
	@JsonProperty("TITLE")
	private String title;
	
	@Column(name = "SHORT_DESC")
	@JsonProperty("SHORT_DESC")
	private String shortDesc;
	
	@Column(name = "IMAGE")
	@JsonProperty("IMAGE")
	private String image;
	
	@Column(name = "DETAIL_DESC_TITLE")
	@JsonProperty("DETAIL_DESC_TITLE")
	private String detailDescTitle;
	
	@Column(name = "DESCRIPTION")
	@JsonProperty("DESCRIPTION")
	private String description;
	
	@Column(name = "AUTHOR_NAME")
	@JsonProperty("AUTHOR_NAME")
	private String authorName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE")
	@JsonProperty("UPDATED_DATE")
	private Date updatedDate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDetailDescTitle() {
		return detailDescTitle;
	}
	public void setDetailDescTitle(String detailDescTitle) {
		this.detailDescTitle = detailDescTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	} 
	
}
