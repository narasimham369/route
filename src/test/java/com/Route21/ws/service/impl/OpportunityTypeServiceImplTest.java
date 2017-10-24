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

import com.route21.ws.bean.Experience;
import com.route21.ws.bean.OpportunityType;
import com.route21.ws.repository.OpportunityTypeRepository;
import com.route21.ws.response.OpportunityTypeListResponse;
import com.route21.ws.response.OpportunityTypeResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.impl.OpportunityTypeServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class OpportunityTypeServiceImplTest {

	@Mock
	OpportunityTypeRepository opportunityTypeRepository;
	
	@InjectMocks
	private final OpportunityTypeServiceImpl opportunityTypeServiceImpl= new OpportunityTypeServiceImpl();
	
	@Test
	public void testShouldAddOpportunityType(){
	
		OpportunityTypeResponse resp= new OpportunityTypeResponse();
		OpportunityType newoptyp= new OpportunityType();
		newoptyp.setId(1);
		newoptyp.setType("full time");
		when(opportunityTypeRepository.save(newoptyp)).thenReturn(newoptyp);
		resp = opportunityTypeServiceImpl.addOpportunityType(newoptyp);
		System.out.println(resp.getStatusMessage());
	}
	
	@Test
	public void testShouldUpdateOpportunityType(){
		
		OpportunityTypeResponse resp= new OpportunityTypeResponse();
		OpportunityType newoptyp= new OpportunityType();
		newoptyp.setId(1);
		newoptyp.setType("part time");
		when(opportunityTypeRepository.findOne(1l)).thenReturn(newoptyp);
		newoptyp.setType("full time");
		when(opportunityTypeRepository.save(newoptyp)).thenReturn(newoptyp);
		resp = opportunityTypeServiceImpl.updateOpportunityType(newoptyp);
		System.out.println(resp.getStatusMessage());
	}
	
	@Test
	public void testShouldGetOpportunityType()
	{
		OpportunityTypeListResponse resp= new OpportunityTypeListResponse();
		List<OpportunityType> lstOpportunityType = new ArrayList<>();
		OpportunityType newoptyp= new OpportunityType();
		newoptyp.setId(1);
		newoptyp.setType("part time");
		lstOpportunityType.add(newoptyp);
		when(opportunityTypeRepository.findAll()).thenReturn(lstOpportunityType);
		
		resp = opportunityTypeServiceImpl.getOpportunityType();
		System.out.println(resp.getStatusMessage());
	}
	
	@Test
	public void testShouldDeleteOpportunityType()
	{

		OpportunityType optType= new OpportunityType();
		Response response = new Response();
		optType.setId(1);
		optType.setType("type");
		response = opportunityTypeServiceImpl.deleteOpportunityType(1l);
		verify(opportunityTypeRepository).delete(1l);
		Assert.assertNotNull(response);
		System.out.println(response.getStatusMessage());
	}
}
