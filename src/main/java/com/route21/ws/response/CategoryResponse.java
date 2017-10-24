package com.route21.ws.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.route21.ws.bean.Category;



public class CategoryResponse extends Response {

	@JsonProperty("CATEGORY")
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
