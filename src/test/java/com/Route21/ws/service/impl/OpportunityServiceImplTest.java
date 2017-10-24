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
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.route21.ws.bean.Category;
import com.route21.ws.bean.Opportunity;
import com.route21.ws.bean.OpportunityType;
import com.route21.ws.bean.Party;
import com.route21.ws.bean.PartyQualification;
import com.route21.ws.bean.PartyType;
import com.route21.ws.bean.Qualification;
import com.route21.ws.repository.CategoryRepository;
import com.route21.ws.repository.OpportunityRepository;
import com.route21.ws.repository.OpportunitySpecifications;
import com.route21.ws.repository.OpportunityTypeRepository;
import com.route21.ws.repository.PartyRepository;
import com.route21.ws.repository.QualificationRepository;
import com.route21.ws.request.OpportunityRequest;
import com.route21.ws.request.OppurtunityBeanRequest;
import com.route21.ws.response.OpportunityListResponse;
import com.route21.ws.response.OpportunityResponse;
import com.route21.ws.service.impl.OpportunityServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class OpportunityServiceImplTest {

	@Mock
	OpportunityRepository opportunityRepository;
	
	@Mock
	PartyRepository ptyRepository;
	
	@Mock
	CategoryRepository categoryRepository;
	
	@Mock
	OpportunityTypeRepository opportunityTypeRepository;
	
	@Mock
	QualificationRepository qualificationRepository;

	@InjectMocks
	private final OpportunityServiceImpl opportunityServiceImpl = new OpportunityServiceImpl();
	
	@Test
	public void testShouldAddOpportunity()
	{
		PartyType ptytype = new PartyType();
		ptytype.setId(1);
		ptytype.setType("employer");
		
		Party pty = new Party();
		pty.setId(1);
		pty.setEmail("email@gmail.com");
		pty.setPartyType(ptytype);
		
		Category ctgy = new Category();
		ctgy.setId(1);
		ctgy.setName("IT-SOFTWARE");
		
		OpportunityType opportunityType = new OpportunityType();
		opportunityType.setId(1);
		opportunityType.setType("full time");
		
		when(ptyRepository.findOne(1l)).thenReturn(pty);
		Qualification qual = new Qualification();
		Opportunity newOpportunity = new Opportunity();
		newOpportunity.setId(1);
		newOpportunity.setDescription("description");
		newOpportunity.setDesiredSkills("desiredSkills");
		newOpportunity.setHowToApply("howToApply");
		newOpportunity.setLinkRef("linkRef");
		newOpportunity.setLocation("location");
		newOpportunity.setStatus("status");
		newOpportunity.setTitle("title");
		newOpportunity.setType("type");
		newOpportunity.setRole("Role");
		newOpportunity.setDepartment("Department");
		newOpportunity.setMinWage(2000);
		newOpportunity.setLiveOrFuture("l");
		newOpportunity.setDuration("Duration");
		newOpportunity.setMinAge(21);
		
		qual.setId(1);
		qual.setName("B-Tech");
		
		OpportunityRequest req = new OpportunityRequest();
		req.setId(1);
		req.setPartyId(1l);
		req.setDescription("description");
		req.setDesiredSkills("desiredSkills");
		req.setHowToApply("howToApply");
		req.setLinkRef("linkRef");
		req.setLocation("location");
		req.setStatus("status");
		req.setTitle("title");
		req.setType("type");
		req.setRole("Role");
		req.setDepartment("Department");
		req.setMinWage(2000);
		req.setLiveOrFuture("l");
		req.setDuration("Duration");
		req.setMinAge(21);
		
		OpportunityResponse response = new OpportunityResponse();
		when(categoryRepository.findByName("IT-SOFTWARE")).thenReturn(ctgy);
		when(opportunityTypeRepository.findByType("full time")).thenReturn(opportunityType);
		when(qualificationRepository.findByName("B-Tech")).thenReturn(qual);
		when(opportunityRepository.save(newOpportunity)).thenReturn(newOpportunity);
		response = opportunityServiceImpl.saveOpportunity(req);
		Assert.assertNotNull(response);
		System.out.println(response.getStatusMessage());
	}
	
	@Test
	public void testShouldUpdateOpportunity()
	{
		Party pty = new Party();
		pty.setId(1);
		pty.setEmail("email@gmail.com");
		
		Opportunity optny = new Opportunity();
		optny.setId(1);
		optny.setDescription("description");
		optny.setDesiredSkills("desiredSkills");
		optny.setHowToApply("howToApply");
		optny.setLinkRef("linkRef");
		optny.setLocation("location");
		optny.setStatus("status");
		optny.setTitle("title");
		optny.setType("type");
		optny.setRole("Role");
		optny.setDepartment("Department");
		optny.setMinWage(2000);
		optny.setLiveOrFuture("l");
		optny.setDuration("Duration");
		optny.setMinAge(21);
		
		Category ctgy = new Category();
		ctgy.setId(1);
		ctgy.setName("IT-SOFTWARE");
		
		Qualification qual = new Qualification();
		qual.setId(1);
		qual.setName("B-Tech");
		
		OpportunityType opportunityType = new OpportunityType();
		opportunityType.setId(1);
		opportunityType.setType("full time");
		
		OpportunityResponse response = new OpportunityResponse();
		Opportunity newOpportunity = new Opportunity();
		newOpportunity.setId(1);
		newOpportunity.setDescription("description");
		newOpportunity.setDesiredSkills("desiredSkills");
		newOpportunity.setHowToApply("howToApply");
		newOpportunity.setLinkRef("linkRef");
		newOpportunity.setLocation("location");
		newOpportunity.setStatus("status");
		newOpportunity.setTitle("title");
		newOpportunity.setType("type");
		newOpportunity.setRole("Role");
		newOpportunity.setDepartment("Department");
		newOpportunity.setMinWage(2000);
		newOpportunity.setLiveOrFuture("l");
		newOpportunity.setDuration("Duration");
		newOpportunity.setMinAge(21);
		
		OpportunityRequest req = new OpportunityRequest();
		req.setId(1);
		req.setPartyId(1l);
		req.setDescription("description");
		req.setDesiredSkills("desiredSkills");
		req.setHowToApply("howToApply");
		req.setLinkRef("linkRef");
		req.setLocation("location");
		req.setStatus("status");
		req.setTitle("title");
		req.setType("type");
		req.setRole("Role");
		req.setDepartment("Department");
		req.setMinWage(2000);
		req.setLiveOrFuture("l");
		req.setDuration("Duration");
		req.setMinAge(21);
		
		when(ptyRepository.findOne(1l)).thenReturn(pty);
		when(opportunityTypeRepository.findByType("full time")).thenReturn(opportunityType);
		when(categoryRepository.findByName("IT-SOFTWARE")).thenReturn(ctgy);
		when(qualificationRepository.findByName("B-Tech")).thenReturn(qual);
		when(opportunityRepository.findOne(1l)).thenReturn(optny);
		when(opportunityRepository.save(newOpportunity)).thenReturn(newOpportunity);
		response = opportunityServiceImpl.updateOpportunity(1l, req);
		Assert.assertNotNull(response);
		System.out.println(response.getStatusMessage());
		
	}
	
	@Test
	public void testShouldGetOpportunity()
	{
		Opportunity optny = new Opportunity();
		List<Opportunity> lstOpportunity = new ArrayList<Opportunity>();
		OpportunityListResponse lstRes = new OpportunityListResponse();
		optny.setId(1);
		optny.setDescription("description");
		optny.setDesiredSkills("desiredSkills");
		optny.setHowToApply("howToApply");
		optny.setLinkRef("linkRef");
		optny.setLocation("location");
		optny.setStatus("status");
		optny.setTitle("title");
		optny.setType("type");
		optny.setDepartment("Department");
		optny.setMinWage(2000);
		optny.setLiveOrFuture("l");
		optny.setDuration("Duration");
		optny.setMinAge(21);
		lstOpportunity.add(optny);
		
		OppurtunityBeanRequest req = new OppurtunityBeanRequest();
		req.setDesiredSkills("desiredSkills");
		req.setLocation("location");
		req.setStatus("status");
		req.setTitle("title");
		req.setType("type");
		req.setRole("Role");
		req.setDepartment("Department");
		req.setMinWage(2000);
		req.setLiveOrFuture("l");
		req.setDuration("Duration");
		req.setMinAge(21);
		
		OpportunitySpecifications spec = new OpportunitySpecifications(req);
		when(opportunityRepository.findAll(spec, orderBy("id"))).thenReturn(lstOpportunity);
		lstRes = opportunityServiceImpl.getOpportunity(req);
		System.out.println(lstRes.getStatusMessage());
		
	}
	
	private Sort orderBy(String id) {
		// TODO Auto-generated method stub
		 return new Sort(Sort.Direction.DESC, id);
		 }

	
}
