package com.Route21.ws.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.route21.ws.bean.ActivityType;
import com.route21.ws.repository.ActivityTypeRepository;
import com.route21.ws.response.ActivityTypeListResponse;
import com.route21.ws.response.ActivityTypeResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.impl.ActivityTypeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ActivityTypeServiceImplTest {

	@Mock
	private ActivityTypeRepository activityTypeRepository;

	/**
	 * It inject {@link ActivityTypeServiceImpl} mock object
	 */
	@InjectMocks
	private final ActivityTypeServiceImpl activityTypeServiceImpl = new ActivityTypeServiceImpl();

	/*
	 * This class used to test the record inserted 
	 * 
	 * It creates mock object for ActivityType Response.
	 * 
	 * 
	 * 
	 */
	@Test
	public void testShouldAddActivityType() {
		ActivityTypeResponse response = new ActivityTypeResponse();
		
		ActivityType newActivitytype = mock(ActivityType.class);
		newActivitytype.setId(1);
		newActivitytype.setType("Skills");

		when(activityTypeRepository.save(newActivitytype)).thenReturn(newActivitytype);
		response = activityTypeServiceImpl.addActivityType(newActivitytype);
		Assert.assertNotNull(response);
		
		System.out.println(response.getStatusMessage());

	}

	@Test
	public void testShouldUpdateActivityType() {
		
		ActivityType actType =  new ActivityType();
		ActivityTypeResponse response = new ActivityTypeResponse();
		actType.setId(1);
		actType.setType("Skills");
				
		when(activityTypeRepository.findOne(1l)).thenReturn(actType);
		actType.setType("Achievements");
		when(activityTypeRepository.save(actType)).thenReturn(actType);
		response = activityTypeServiceImpl.updateActivityType(actType);
		Assert.assertNotNull(response);
		System.out.println(response.getStatusMessage());
	}
	
	@Test
	public void testShouldGetActivityType()
	{
		ActivityType actType =  new ActivityType();
		ActivityTypeListResponse response = new ActivityTypeListResponse();
		actType.setId(1);
		actType.setType("Skills");
		List lstActType = new ArrayList<ActivityType>();
		lstActType.add(actType);
		when(activityTypeRepository.findAll()).thenReturn(lstActType);
		response = activityTypeServiceImpl.getActivityType();
		Assert.assertNotNull(response);
		System.out.println(response.getStatusMessage());
		
	}
	@Test
	public void testShouldDeleteActivityType(){
	
		ActivityType actType = new ActivityType();
		Response response = new Response();
		actType.setId(1);
		actType.setType("Skills");  
		response = activityTypeServiceImpl.deleteActivityType(1l);
		verify(activityTypeRepository).delete(1l);
		Assert.assertNotNull(response);
		System.out.println(response.getStatusMessage());
	}

}
