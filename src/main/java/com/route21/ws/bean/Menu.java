package com.route21.ws.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * This is the Menu bean class, it implements serializable object.
 * 
 * It contains some properties to get and set this values.
 * 
 * using @entity create a table in data base.
 * 
 * @author admin-pc
 *
 */
@Entity
@Table(name="MENU")
public class Menu implements Serializable{

	private static final long serialVersionUID = 935709957342042399L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@JsonProperty("ID")
	private Long id;
	
	@Column(name="NAME")
	@JsonProperty("NAME")
	private String name;
	
	@Column(name="TYPE")
	@JsonProperty("TYPE")
	private String type;
	
	@Column(name="SORT")
	@JsonProperty("SORT")
	private int sort;
	
	@Column(name="URL")
	@JsonProperty("URL")
	private String url;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}