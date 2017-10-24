package com.route21.ws.service;

import com.route21.ws.bean.Category;
import com.route21.ws.response.CategoryListResponse;
import com.route21.ws.response.CategoryResponse;
import com.route21.ws.response.Response;


public interface CategoryService {

	CategoryResponse addCategory(Category c);
	
	CategoryResponse updateCategory(Category c);
	
	CategoryListResponse getCategory();
	
	Response deleteCategory(Long id); 
	
	
}
