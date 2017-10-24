package com.route21.ws.service.impl;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.route21.ws.bean.Content;
import com.route21.ws.bean.Qualification;
import com.route21.ws.exception.DataNotFoundException;
import com.route21.ws.exception.LiferayException;
import com.route21.ws.repository.ContentRepository;
import com.route21.ws.request.SaveContentRequest;
import com.route21.ws.response.ContentResponse;
import com.route21.ws.response.GetContentResponse;
import com.route21.ws.response.SaveContentResponse;
import com.route21.ws.service.ContentService;
import com.route21.ws.service.OpportunityService;


/**
* 
* This class gives Content details.
* 
* This class contain Logger tool for debug. 
* 
* @author admin-pc
*
*/

@Service
public class ContentServiceImpl implements ContentService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContentServiceImpl.class);
	
	/**
	 * It inject {@link OpportunityService} object
	 */
	@Autowired
	ContentRepository contentRespositry;
	
	@Autowired
	Environment env;

	/**
	 * 
	 * This  method is used to insert data into Content table.
	 * 
	 * This method consists of business logic which is used to add details into table.
	 * 
	 * @param saveRequest contains attribute of {@link SaveContentRequest}
	 *
	 * @return the response status message
	 * 
	 */
	
	@Override
	public SaveContentResponse saveContent(SaveContentRequest saveRequest) {
			
		SaveContentResponse response = new SaveContentResponse();	
		
		Content con = new Content();			
	
		con.setDescription(saveRequest.getDescription());
		con.setPageName(saveRequest.getPageName());
		con.setPageUrl(saveRequest.getPageUrl());
		con.setTitle(saveRequest.getTitle());
		con.setTitleUrl(saveRequest.getTitleUrl());
		con.setSort(saveRequest.getSort());
		
		Content content = contentRespositry.saveAndFlush(con);
		
		response.setStatusCode(200);
		response.setStatusMessage("Saved Successfully");
		response.setContent(content);		
		return response;
	}
	
	/**
	 * 
	 * This  method is used to list out  data from Content table.
	 * 
	 * This method consists of business logic which is used to get details of Content table.
	 * 
	 * @return the response status message
	 * 
	 */

	@Override
	public GetContentResponse listContents() {
		LOGGER.debug("LIST ALL CONTENTS");
		
		ClientConfig clientConfig = new ClientConfig();
		 
	    HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(env.getProperty("liferay.user.id"), env.getProperty("liferay.user.key"));
	    clientConfig.register( feature) ;
	 
	    clientConfig.register(JacksonFeature.class);
		
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target(env.getProperty("liferay.api.rootpath")).path("article-id/0/content-type/tagtest");
		 
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
	
		Response response = invocationBuilder.get();
		 
		GetContentResponse content = response.readEntity(GetContentResponse.class);
		
		
	
		     
		LOGGER.info("status::"+response.getStatus());
		
		
		
		content.setStatusCode(200);
		content.setStatusMessage("Content List");
	
		return content;
	}
	
	/**
	 * 
	 * This  method is used to get data from Content table.
	 * 
	 * This method consists of business logic which is used to get details of Content table.
	 * 
	 * @return the response status message
	 * 
	 */
	
	@Override
	public GetContentResponse getContent(String pageUrl) {
		
		List<Content> content = contentRespositry.findByPageUrlOrderBySortAsc(pageUrl);
		GetContentResponse response = new  GetContentResponse();
		response.setStatusCode(200);
		response.setStatusMessage("Get Content");
		response.setContentList(null);
		return response;
	}

	/**
	 * 
	 * This  method is used to update data into Content table.
	 * 
	 * This method consists of business logic which is used to update details of Content table.
	 * 
	 * @param q contains attributes of {@link Qualification}
	 *
	 * @return the response status message
	 * 
	 */
	@Override
	public ContentResponse updateContent(Long contentId, SaveContentRequest request) {
		
		ContentResponse response = new ContentResponse();
		Content content = contentRespositry.findOne(contentId);
		if(content == null)
		{
			throw new DataNotFoundException("Content not found");
		}
		content.setDescription(request.getDescription());
		content.setPageName(request.getPageName());
		content.setPageUrl(request.getPageUrl());
		content.setTitle(request.getTitle());
		content.setTitleUrl(request.getTitleUrl());
		content.setSort(request.getSort());
		
		Content updateContent = contentRespositry.saveAndFlush(content);
		response.setStatusCode(200);
		response.setStatusMessage("Content Updated Successfully");
		response.setContent(updateContent);
		
		return response;
	}

	@Override
	public GetContentResponse listContents(Long artId, String contenttype) {

		LOGGER.debug("LIST ALL CONTENTS");
		
		String relativepath = env.getProperty("liferay.api.relativepath");
		
		relativepath = relativepath.replace("{id}", artId.toString());
		if(contenttype == null)			
			contenttype = "cnttype";
		relativepath = relativepath.replace("{cnttype}", contenttype);
		
		LOGGER.info("Relativepath :"+relativepath);
		
		ClientConfig clientConfig = new ClientConfig();
		 
	    HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(env.getProperty("liferay.user.id"), env.getProperty("liferay.user.key"));
	    clientConfig.register( feature) ;
	 
	    clientConfig.register(JacksonFeature.class);
		
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target(env.getProperty("liferay.api.rootpath")).path(relativepath);
		 
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationBuilder.get();
		 
		GetContentResponse content = response.readEntity(GetContentResponse.class);
				
		LOGGER.info("status::"+response.getStatus());
		
		if(!(StringUtils.isEmpty(content.getMessage())) && !(StringUtils.isEmpty(content.getException())))
		{
			LOGGER.info("liferayException");
			throw new LiferayException(content.getMessage());
		}
		content.setStatusCode(200);
		content.setStatusMessage("Content List");
		
		return content;
	
	}

	

}
