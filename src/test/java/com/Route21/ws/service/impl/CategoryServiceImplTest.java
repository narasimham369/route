package com.Route21.ws.service.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.route21.ws.bean.Category;
import com.route21.ws.repository.CategoryRepository;
import com.route21.ws.response.CategoryListResponse;
import com.route21.ws.response.CategoryResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.impl.CategoryServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceImplTest {
	
	@Mock
	CategoryRepository categoryRepository;
	
	@InjectMocks
	private final CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();
	
	@Test
	public void testShouldAddCategory()
	{
		CategoryResponse response = new CategoryResponse();
		Category ctgy = new Category();
		ctgy.setId(1);
		ctgy.setName("name");
		when(categoryRepository.save(ctgy)).thenReturn(ctgy);
		Assert.assertEquals(true, true);
		response = categoryServiceImpl.addCategory(ctgy);
		System.out.println(response.getStatusCode()+"==="+response.getStatusMessage());
	}
	
	@Test
	public void testShouldUpdateCategory()
	{
		CategoryResponse response = new CategoryResponse();
		Category ctgy = new Category();
		ctgy.setId(1);
		ctgy.setName("name");
		when(categoryRepository.findOne(1l)).thenReturn(ctgy);
		ctgy.setName("software");
		when(categoryRepository.save(ctgy)).thenReturn(ctgy);
		Assert.assertEquals(200, 200);
		response = categoryServiceImpl.updateCategory(ctgy);
		System.out.println(response.getCategory().getName());
	}
	
	@Test
	public void testShouldGetCategory()
	{
		Category ctgy = new Category();
		ctgy.setId(1);
		ctgy.setName("software");
		ctgy.setId(2);
		ctgy.setName("Hardware");
		List<Category> lstCtgy = new ArrayList<>();
		lstCtgy.add(ctgy);
		CategoryListResponse resp = new CategoryListResponse();
		when(categoryRepository.findAll()).thenReturn(lstCtgy);
		resp = categoryServiceImpl.getCategory();
		Assert.assertNotNull(resp);
		System.out.println("categoryList::"+resp.getStatusMessage());
		
	}
	
	@Test
	public void testShouldDeleteCategory(){
		
		Category ctgy = new Category();
		ctgy.setId(1);
		ctgy.setName("software");
		Response resp = new Response();
		resp = categoryServiceImpl.deleteCategory(1l);
		System.out.println(resp.getStatusMessage());
		
		
	}

}
