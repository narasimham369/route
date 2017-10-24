package com.route21.ws.response;

import java.util.List;

import com.route21.ws.bean.Category;


public class CategoryListResponse extends Response{
	
	private List<Category> lstCategory;

	public List<Category> getLstCategory() {
		return lstCategory;
	}

	public void setLstCategory(List<Category> lstCategory) {
		this.lstCategory = lstCategory;
	}
	
	

}
