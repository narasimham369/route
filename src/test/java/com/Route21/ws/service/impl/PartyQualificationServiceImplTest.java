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
import com.route21.ws.bean.Party;
import com.route21.ws.bean.PartyQualification;
import com.route21.ws.bean.Qualification;
import com.route21.ws.repository.PartyQualificationRepository;
import com.route21.ws.repository.PartyRepository;
import com.route21.ws.repository.QualificationRepository;
import com.route21.ws.request.PartyQualificationRequest;
import com.route21.ws.response.ExperienceListResponse;
import com.route21.ws.response.PartyQualificationListResponse;
import com.route21.ws.response.PartyQualificationResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.impl.PartyQualificationServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PartyQualificationServiceImplTest {

	@Mock
	PartyQualificationRepository partyQualificationRepository;
	
	@Mock
	PartyRepository partyRepository;
	
	@Mock
	QualificationRepository qualificationRepository;
	
	@InjectMocks
	private final PartyQualificationServiceImpl partyQualificationServiceImpl= new PartyQualificationServiceImpl();
	@Test
	public void testShouldAddPartyQualification()
	{
		Party pty = new Party();
		pty.setId(1);
		pty.setEmail("email@gmail.com");
		
		Qualification qual = new Qualification();
		qual.setId(1);
		qual.setName("B-Tech");
		
		PartyQualification ptyQual = new PartyQualification();
		ptyQual.setId(1);
		ptyQual.setQualification(qual);
		ptyQual.setCompletedOn(2011);
		ptyQual.setDescription("hi");
		ptyQual.setExternalLink("externalLink");
		ptyQual.setGrade("A");
		ptyQual.setId(1);
		ptyQual.setInstituttionName("anna university");
		ptyQual.setMajor("Yes");
		ptyQual.setOrderId(1);
		ptyQual.setStartedOn(2010);
		
		PartyQualificationRequest req = new PartyQualificationRequest();
		req.setPartyId(1);
		req.setQualificationId(1);
		req.setCompletedOn(2015);
		req.setDescription("hi");
		req.setLocation("chennai");
		req.setGrade("A+");
		req.setInstituteName("Abc institute");
		req.setMajor("Yes");
		req.setOrderId(1);
		
		when(partyRepository.findOne(1l)).thenReturn(pty);
		when(qualificationRepository.findOne(1l)).thenReturn(qual);
		when(partyQualificationRepository.save(ptyQual)).thenReturn(ptyQual);
		PartyQualificationResponse resp= new PartyQualificationResponse();
		Assert.assertNotNull(resp);
		resp = partyQualificationServiceImpl.savePartyQualification(req);
		System.out.println(resp.getStatusMessage());
		
	}
	
	@Test
	public void testShouldUpdatePartyQualification(){
		
		Party pty = new Party();
		pty.setId(1);
		pty.setEmail("email@gmail.com");
		
		Qualification qual = new Qualification();
		qual.setId(1);
		qual.setName("B-Tech");
		
		PartyQualification ptyQual = new PartyQualification();
		ptyQual.setId(1);
		ptyQual.setQualification(qual);
		ptyQual.setCompletedOn(2011);
		ptyQual.setDescription("hi");
		ptyQual.setExternalLink("externalLink");
		ptyQual.setGrade("A");
		ptyQual.setId(1);
		ptyQual.setInstituttionName("anna university");
		ptyQual.setMajor("Yes");
		ptyQual.setOrderId(1);
		ptyQual.setStartedOn(2010);
		
		PartyQualificationRequest req = new PartyQualificationRequest();
		req.setPartyId(1);
		req.setQualificationId(1);
		req.setCompletedOn(2015);
		req.setDescription("hi");
		req.setLocation("chennai");
		req.setGrade("A+");
		req.setInstituteName("Abc institute");
		req.setMajor("Yes");
		req.setOrderId(1);
		
		when(partyRepository.findOne(1l)).thenReturn(pty);
		when(qualificationRepository.findOne(1l)).thenReturn(qual);
		when(partyQualificationRepository.findOne(1l)).thenReturn(ptyQual);
		when(partyQualificationRepository.save(ptyQual)).thenReturn(ptyQual);
		
		PartyQualificationResponse resp= new PartyQualificationResponse();
		Assert.assertNotNull(resp);
		resp = partyQualificationServiceImpl.updatePartyQualification(1l, req);
		System.out.println(resp.getStatusMessage());

	}
	
	@Test
	public void testShouldGetPartyQualification()
	{
		PartyQualification ptyQual = new PartyQualification();
		PartyQualificationListResponse response = new PartyQualificationListResponse();
		Qualification qual = new Qualification();
		qual.setId(1);
		qual.setName("B-Tech");
		ptyQual.setId(1);
		ptyQual.setQualification(qual);
		ptyQual.setCompletedOn(2011);
		ptyQual.setDescription("hi");
		ptyQual.setExternalLink("externalLink");
		ptyQual.setGrade("A");
		ptyQual.setId(1);
		ptyQual.setInstituttionName("anna university");
		ptyQual.setMajor("Yes");
		ptyQual.setOrderId(1);
		ptyQual.setStartedOn(2010);
		List lstPtyQualification  = new ArrayList<PartyQualification>();
		lstPtyQualification.add(ptyQual);
		when(partyQualificationRepository.findByPtyId(1l)).thenReturn(lstPtyQualification);
		response = partyQualificationServiceImpl.getPartQualificationByPartyId(1l);
		Assert.assertNotNull(response);
		System.out.println(response.getStatusMessage());
		
	}
	
	@Test
	public void testShouldDeletePartyQualification(){
		
		PartyQualification ptyQual = new PartyQualification();
		Response response = new Response();
		Qualification qual = new Qualification();
		qual.setId(1);
		qual.setName("B-Tech");
		ptyQual.setId(1);
		ptyQual.setQualification(qual);
		ptyQual.setCompletedOn(2011);
		ptyQual.setDescription("hi");
		ptyQual.setExternalLink("externalLink");
		ptyQual.setGrade("A");
		ptyQual.setId(1);
		ptyQual.setInstituttionName("anna university");
		ptyQual.setMajor("Yes");
		ptyQual.setOrderId(1);
		ptyQual.setStartedOn(2010);
		when(partyQualificationRepository.findOne(1l)).thenReturn(ptyQual);
		response = partyQualificationServiceImpl.deletePartyQualificationById(1l);
		verify(partyQualificationRepository).delete(1l);
		Assert.assertNotNull(response);
		System.out.println(response.getStatusMessage());
		
	}
}
