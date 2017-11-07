package com.Route21.ws.service.impl;

import static org.mockito.Mockito.any;
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
import org.springframework.beans.factory.annotation.Autowired;

import com.route21.ws.bean.ActivityType;
import com.route21.ws.bean.ApplyOpportunity;
import com.route21.ws.bean.Category;
import com.route21.ws.bean.Opportunity;
import com.route21.ws.bean.OpportunityType;
import com.route21.ws.bean.Party;
import com.route21.ws.bean.PartyActivity;
import com.route21.ws.bean.PartyQualification;
import com.route21.ws.repository.ActivityTypeRepository;
import com.route21.ws.repository.ApplyOpportunityRepository;
import com.route21.ws.repository.OpportunityRepository;
import com.route21.ws.repository.PartyActivityRepository;
import com.route21.ws.repository.PartyQualificationRepository;
import com.route21.ws.repository.PartyRepository;
import com.route21.ws.request.ApplyOpportunityRequest;
import com.route21.ws.response.ApplyOpportunityMapResponse;
import com.route21.ws.response.ApplyOpportunityResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.impl.ApplyOpportunityServiceImpl;
import com.route21.ws.types.PartyActivityTypeEnum;
import com.route21.ws.util.EmailHtmlSender;

@RunWith(MockitoJUnitRunner.class)
public class ApplyOpportunityServiceImplTest {

	@Mock
	private ApplyOpportunityRepository applyOpntyRepository;
	
	@Mock
	private OpportunityRepository opntyRepository;
	
	@Mock
	private PartyActivityRepository ptyActRepository;

	@Mock
	private PartyRepository ptyRepository;
	
	@Mock
	private PartyQualificationRepository partyQualificationRepository;
	
	@Mock
	protected EmailHtmlSender emailHtmlSender;
	
	@InjectMocks
	private final ApplyOpportunityServiceImpl applyOpntyServiceImpl= new ApplyOpportunityServiceImpl();
	 
	@Test
	public void testShouldAddApplyOpportunity()
	{
		
		Category ctgy = new Category();
		ctgy.setId(1);
		ctgy.setName("IT-SOFTWARE");
		
		Party party= new Party();
		party.setId(1);
		party.setDescription("Hi I am a first user");
		party.setEmail("employer@gmail.com");
		
		Opportunity opnty= new Opportunity();
		opnty.setParty(party);
		opnty.setId(1);	
		opnty.setDuration("1 Month");
		opnty.setDesiredSkills("Java");
		opnty.setDescription("Java Developer Required");
		opnty.setDepartment("Develoment");
		opnty.setMinAge(18);
		opnty.setMinWage(12000);
		OpportunityType opportunityType = new OpportunityType();
		opportunityType.setId(1);
		opportunityType.setType("full time");
		opnty.setOpportunityType(opportunityType);
		opnty.setCategory(ctgy);
		
		PartyQualification ptyQual = new PartyQualification();
		List lstPtyQualification = new ArrayList<PartyQualification>();
		ptyQual.setId(1);
		ptyQual.setGrade("A+");
		ptyQual.setDescription("I have completed graduation");
		ptyQual.setInstituttionName("Anna university");
		lstPtyQualification.add(ptyQual);
		
		PartyActivity ptyAct = new PartyActivity();
		ActivityType actType = new ActivityType();
		actType.setId(1);
		actType.setType("skills");	
		actType.setId(2);
		actType.setType("achivements");	
		actType.setId(3);
		actType.setType("hobbies");	
		actType.setId(5);
		actType.setType("image");
		ptyAct.setId(1);
		ptyAct.setDescription("SKILLS");
		ptyAct.setId(2);
		ptyAct.setDescription("ACHIEVEMENTS");
		ptyAct.setId(3);
		ptyAct.setDescription("HOBBIESANDINTEREST");
		ptyAct.setId(5);
		ptyAct.setActivityType(actType);
		List partyActivitylstskills = new ArrayList<PartyActivity>();
		List partyActivitylstAchivements = new ArrayList<PartyActivity>();
		partyActivitylstskills.add(ptyAct);
		partyActivitylstAchivements.add(ptyAct);
		ApplyOpportunityRequest newApply = new ApplyOpportunityRequest();
		newApply.setId(1l);
		newApply.setStatus("Active");
		newApply.setStatusReason("Yes");
		newApply.setPartyId(1l);
		newApply.setOpportunityId(1l);
		
		ApplyOpportunity applyOpnty = new ApplyOpportunity();
		applyOpnty.setId(1l);
		applyOpnty.setParty(party);
		applyOpnty.setOpportunity(opnty);
		applyOpnty.setStatus("Active");
		
		ApplyOpportunityResponse resp = new ApplyOpportunityResponse();
		
		when(ptyRepository.findOne(1l)).thenReturn(party);
		when(opntyRepository.findOne(1l)).thenReturn(opnty);
		when(partyQualificationRepository.findByPtyId(1l)).thenReturn(lstPtyQualification);
		
		when(ptyActRepository
				.findPtyActivityListByPtyIdAndActId(1l, PartyActivityTypeEnum.SKILLS.type)).thenReturn(partyActivitylstskills);
		when(ptyActRepository
				.findPtyActivityListByPtyIdAndActId(1l, PartyActivityTypeEnum.ACHIEVEMENTS.type)).thenReturn(partyActivitylstAchivements);
		when(ptyActRepository.findPtyActivityListByPtyIdAndActId(
				1l, PartyActivityTypeEnum.HOBBIESANDINTEREST.type)).thenReturn(partyActivitylstskills);
		when(ptyActRepository.findPtyActivityByPtyIdAndActid(1l,
				PartyActivityTypeEnum.COVERIMAGE.type)).thenReturn(ptyAct);
		
	
		when(applyOpntyRepository.save(applyOpnty)).thenReturn(applyOpnty);
		resp = applyOpntyServiceImpl.saveApplyopportunity(newApply);
		
		System.out.println(resp.getStatusMessage());
	}
	
	@Test
	public void testShouldUpdateApplyOpportunity()
	{
		Category ctgy = new Category();
		ctgy.setId(1);
		ctgy.setName("IT-SOFTWARE");
		
		Party party= new Party();
		party.setId(1);
		party.setDescription("Hi I am a first user");
		party.setEmail("employer@gmail.com");
		ApplyOpportunityResponse resp = new ApplyOpportunityResponse();
		Opportunity opnty= new Opportunity();
		opnty.setParty(party);
		opnty.setId(1);	
		opnty.setDuration("1 Month");
		opnty.setDesiredSkills("Java");
		opnty.setDescription("Java Developer Required");
		opnty.setDepartment("Develoment");
		opnty.setMinAge(18);
		opnty.setMinWage(12000);
		OpportunityType opportunityType = new OpportunityType();
		opportunityType.setId(1);
		opportunityType.setType("full time");
		opnty.setOpportunityType(opportunityType);
		opnty.setCategory(ctgy);
		ApplyOpportunity applyOpnty = new ApplyOpportunity();
		applyOpnty.setId(1l);
		applyOpnty.setParty(party);
		applyOpnty.setOpportunity(opnty);
		applyOpnty.setStatus("Active");
		ApplyOpportunityRequest newApply = new ApplyOpportunityRequest();
		newApply.setId(1l);
		newApply.setStatus("Active");
		newApply.setStatusReason("Yes");
		newApply.setPartyId(1l);
		newApply.setOpportunityId(1l);
		when(applyOpntyRepository.findOne(1l)).thenReturn(applyOpnty);
		when(opntyRepository.findOne(1l)).thenReturn(opnty);
		when(ptyRepository.findOne(1l)).thenReturn(party);
		when(applyOpntyRepository.save(applyOpnty)).thenReturn(applyOpnty);
		resp = applyOpntyServiceImpl.updateApplyOpportunity(1l, newApply);
		Assert.assertEquals(200, 200);
		System.out.println("status::"+ resp.getStatusMessage());
	}
	
	@Test
	public void testShouldGetApplyOpportunity()
	{
		ApplyOpportunity newApplyOpnty = new ApplyOpportunity();
		
		Category ctgy = new Category();
		ctgy.setId(1);
		ctgy.setName("IT-SOFTWARE");
		
		Opportunity opnty= new Opportunity();
		opnty.setCategory(ctgy);
		opnty.setDepartment("Develoment");
		opnty.setDescription("Java Developer Required");
		opnty.setDesiredSkills("Java");
		opnty.setDuration("1 Month");
		opnty.setId(1);	
		
		List<Opportunity> opntylst = new ArrayList<Opportunity>();
		opntylst.add(opnty);
		
		Party party= new Party();
		party.setId(1);
		party.setName("asha");
		
		newApplyOpnty.setId(1);
		newApplyOpnty.setParty(party);
		newApplyOpnty.setOpportunity(opnty);
		newApplyOpnty.setStatus("status");
		newApplyOpnty.setStatusReason("statusReason");
		
		List lstApply = new ArrayList<ApplyOpportunity>();
		lstApply.add(newApplyOpnty);
		
		when(opntyRepository.findAll()).thenReturn(opntylst);
	
		when(applyOpntyRepository.findApplyOpportunityByOpportunityId(1l)).thenReturn(lstApply);
		
		ApplyOpportunityMapResponse resp = applyOpntyServiceImpl.getApplyOpportunity();
		
		Assert.assertNotNull(resp);
		System.out.println("newApplyOpnty::"+ newApplyOpnty.getStatus());
		
	}
	@Test
	public void testShouldDeleteApplyOrrortunity()
	{
		Category ctgy = new Category();
		ctgy.setId(1);
		ctgy.setName("IT-SOFTWARE");
		Party party= new Party();
		party.setId(1);
		party.setDescription("Hi I am a first user");
		party.setEmail("employer@gmail.com");
		ApplyOpportunityResponse resp = new ApplyOpportunityResponse();
		Opportunity opnty= new Opportunity();
		opnty.setParty(party);
		opnty.setId(1);	
		opnty.setDuration("1 Month");
		opnty.setDesiredSkills("Java");
		opnty.setDescription("Java Developer Required");
		opnty.setDepartment("Develoment");
		opnty.setMinAge(18);
		opnty.setMinWage(12000);
		OpportunityType opportunityType = new OpportunityType();
		opportunityType.setId(1);
		opportunityType.setType("full time");
		opnty.setOpportunityType(opportunityType);
		opnty.setCategory(ctgy);
		ApplyOpportunity applyOpnty = new ApplyOpportunity();
		applyOpnty.setId(1l);
		applyOpnty.setParty(party);
		applyOpnty.setOpportunity(opnty);
		applyOpnty.setStatus("Active");
		when(applyOpntyRepository.findOne(1l)).thenReturn(applyOpnty);
		Response response = new Response();
		Assert.assertNotNull(resp);
		response = applyOpntyServiceImpl.deleteApplyOpportunityById(1l);
		verify(applyOpntyRepository).delete(1l);
		System.out.println(response.getStatusCode());
	}
}
