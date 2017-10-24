package com.route21.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.route21.ws.bean.Category;
import com.route21.ws.repository.CategoryRepository;
import com.route21.ws.response.CategoryListResponse;
import com.route21.ws.response.CategoryResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.CategoryService;
import com.route21.ws.service.OpportunityService;

/**
* 
* This class gives Category details.
* 
* @author admin-pc
*
*/


@Service
public class CategoryServiceImpl implements CategoryService {

	/**
	 * It inject {@link OpportunityService} object
	 */
	@Autowired
	CategoryRepository categoryRepository;

	/**
	 * 
	 * This  method is used to insert data into Category table.
	 * 
	 * This method consists of business logic which is used to add details into table.
	 * 
	 * @param c contains attribute of {@link Category}
	 *
	 * @return the response status message
	 * 
	 */
	
	@Override
	public CategoryResponse addCategory(Category c) {


		CategoryResponse response = new CategoryResponse();
		Category category = categoryRepository.save(c);
		response.setCategory(category);
		response.setStatusCode(200);
		response.setStatusMessage("INSERTED SUCCESSFULLY");
		return response;
	}

	/**
	 * 
	 * This  method is used to update data into Category table.
	 * 
	 * This method consists of business logic which is used to update details of Category table.
	 * 
	 * @param c contains attributes of {@link Category}
	 *
	 * @return the response status message
	 * 
	 */
	
	@Override
	public CategoryResponse updateCategory(Category c) {


		CategoryResponse response = new CategoryResponse();

		Category category = categoryRepository.findOne(c.getId());
		category.setName(c.getName());
		Category updatecategory = categoryRepository.save(category);
		response.setCategory(updatecategory);
		response.setStatusCode(200);
		response.setStatusMessage("UPDATESD SUCCESSFULLY");
		return response;
	}

	/**
	 * 
	 * This  method is used to get data from Category table.
	 * 
	 * This method consists of business logic which is used to get details of Category table.
	 * 
	 * @return the response status message
	 * 
	 */
	
	@Override
	public CategoryListResponse getCategory() {

		
		CategoryListResponse resp = new CategoryListResponse();
		List<Category> lstCategory = categoryRepository.findAll();
		resp.setLstCategory(lstCategory);
		resp.setStatusCode(200);
		resp.setStatusMessage("RETRIEVED SUCCESSFULLY");
		return resp;
	}
	
	/**
	 * 
	 * This  method is used to delete data from Category table.
	 * 
	 * This method consists of business logic which is used to delete details of Category table.
	 * 
	 * @param id contains id of Category.
	 * 
	 * @return the response status message
	 * 
	 */
	@Override
	public Response deleteCategory(Long id) {

		
		Response resp = new Response();
		try
		{
			categoryRepository.delete(id);
			resp.setStatusCode(200);
			resp.setStatusMessage("DELETED SUCCESSFULLY");
		}
		catch(Exception e)
		{
			resp.setStatusCode(500);
			resp.setStatusMessage("INTERNALSERVER ERROR");
		}
		return resp;
	}

	
}

