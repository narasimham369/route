package com.route21.ws.request;

import java.util.Map;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PartyActivityRequest {
	
	@JsonProperty("PTY_ID")
	private long ptyId;
	
	@JsonProperty("ACT_ID")
	private long actId;
	
	@JsonProperty("TITLE")
	private String title;
	
	@JsonProperty("DESCRIPTION")
	private String description;
	
	@JsonProperty("SHORT_DESCRIPTION")
	private String shortDescription;	

	@JsonProperty("ORDER_ID")
	private long orderId;
	
	@JsonProperty("IMAGE_1")
	private Map<String, String> image_1;
	
	@JsonProperty("IMAGE_2")
	private  Map<String, String> image_2;
	
	@JsonProperty("IMAGE_3")
	private Map<String, String> image_3;
	
	@JsonProperty("IMAGE_4")
	private Map<String, String> image_4;
	
	@JsonProperty("ACT_DATE")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@JsonFormat(pattern="dd-MM-yyyy")
	private DateTime actDate;
	
	
	public DateTime getActDate() {
		return actDate;
	}

	public void setActDate(DateTime actDate) {
		this.actDate = actDate;
	}

	public Map<String, String> getImage_2() {
		return image_2;
	}

	public void setImage_2(Map<String, String> image_2) {
		this.image_2 = image_2;
	}

	public Map<String, String> getImage_3() {
		return image_3;
	}

	public void setImage_3(Map<String, String> image_3) {
		this.image_3 = image_3;
	}

	public Map<String, String> getImage_4() {
		return image_4;
	}

	public void setImage_4(Map<String, String> image_4) {
		this.image_4 = image_4;
	}

	public Map<String, String> getImage_1() {
		return image_1;
	}

	public void setImage_1(Map<String, String> image_1) {
		this.image_1 = image_1;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getPtyId() {
		return ptyId;
	}

	public void setPtyId(long ptyId) {
		this.ptyId = ptyId;
	}

	public long getActId() {
		return actId;
	}

	public void setActId(long actId) {
		this.actId = actId;
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

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	
}
