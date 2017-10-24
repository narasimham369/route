package com.Route21.ws.service.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.route21.ws.bean.Content;
import com.route21.ws.repository.ContentRepository;
import com.route21.ws.request.SaveContentRequest;
import com.route21.ws.response.ContentResponse;
import com.route21.ws.response.SaveContentResponse;
import com.route21.ws.service.impl.ContentServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ContentServiceImplTest {

	@Mock
	private ContentRepository contentRepository;
	
	@InjectMocks
	private final ContentServiceImpl contentserviceimpl= new ContentServiceImpl();
	
	@Test
	public void testShouldAddContent()
	{
		Content content = new Content();
		content.setDescription("asajhajdh");
		content.setPageName("source");
		content.setPageUrl("https://www.google.com");
		content.setTitle("`ashaaaa");
		content.setTitleUrl("google");
		content.setId(1l);
		when (contentRepository.findOne(1l)).thenReturn(content);
		SaveContentResponse resp= new SaveContentResponse();
		when (contentRepository.saveAndFlush(content)).thenReturn(content);
		SaveContentRequest saveReq = new SaveContentRequest();
		saveReq.setId(1l);
		saveReq.setPageName("contenttype");
		resp = contentserviceimpl.saveContent(saveReq);
		System.out.println("responae::"+ resp.getStatusMessage());
		
	}
	
	@Test
	public void testShouldUpdateContent()
	{

		ContentResponse resp= new ContentResponse();
		Content content= new Content();
		content.setDescription("asajhajdh");
		content.setPageName("source");
		content.setPageUrl("https://www.google.com");
		content.setTitle("`ashaaaa");
		content.setTitleUrl("google");
		content.setSort(5);
		
		when(contentRepository.findOne(1l)).thenReturn(content);
		
		content.setPageUrl("http///wwww.com");
		when (contentRepository.save(content)).thenReturn(content);
		resp.setContent(content);
		resp.setStatusCode(200);
		resp.setStatusMessage("SUCESSFULLY UPDATED");
		System.out.println(resp.getStatusMessage()+"------"+resp.getContent().getPageUrl());
	}
	@Test
	public void testShouldDeleteContent(){
		
		ContentResponse resp= new ContentResponse();
		Content content= new Content();
		content.setId(1l);
		content.setPageName("pageName");
		content.setPageUrl("www.com");
		content.setSort(5);
		content.setDescription("description");
		content.setTitle("title");
		content.setTitleUrl("titleUrl");
		
		contentRepository.delete(1l);
		verify(contentRepository).delete(1l);
		resp.setContent(content);
		resp.setStatusCode(200);
		resp.setStatusMessage("SUCESSFULLY DELETED");
		System.out.println(resp.getContent().getDescription()+"========="+resp.getStatusCode());
		


	}
	
}
