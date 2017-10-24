package com.Route21.ws.service.impl;

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
import com.route21.ws.repository.ExperienceRepository;
import com.route21.ws.repository.PartyRepository;
import com.route21.ws.request.ExperienceRequest;
import com.route21.ws.response.ExperienceListResponse;
import com.route21.ws.response.ExperienceResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.impl.ExperienceServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ExperienceServiceImplTest {

	@Mock
	private ExperienceRepository expRepository;
	
	@Mock
	private PartyRepository partyRepository;
	
	@InjectMocks
	private final ExperienceServiceImpl experienceServiceImpl = new ExperienceServiceImpl();
	
	@Test
	public void testShouldAddExperience()
	{
		ExperienceRequest expReq = new ExperienceRequest();
		Party pty = new Party();
		pty.setId(1);
		pty.setEmail("email@gmail.com");
		when(partyRepository.findOne(1l)).thenReturn(pty);
		Experience exp = new Experience();
		ExperienceResponse response = new ExperienceResponse();
		exp.setId(1);
		exp.setParty(pty);
		exp.setWorkPlace("mbf");
		exp.setLocation("chennai");
		exp.setJobTitle("java developer");
		exp.setDescription("sedfrsf");
		exp.setStartYear(2015);
		exp.setStartMonth("nov");
		exp.setEndYear(2016);
		exp.setEndMonth("jan");
		exp.setOrderId(1);
		expReq.setId(1);
		expReq.setPtyId(1);
		expReq.setWorkPlace("mbf");
		expReq.setLocation("chennai");
		expReq.setJobTitle("java developer");
		expReq.setDecription("sedfrsf");
		expReq.setStartYear(2015);
		expReq.setStartMonth("nov");
		expReq.setEndYear(2016);
		expReq.setEndMonth("jan");
		when(expRepository.save(exp)).thenReturn(exp);
		Assert.assertNotNull(response);
		response = experienceServiceImpl.addExperience(expReq);
		System.out.println("response::"+response.getStatusMessage());

	}
	
	@Test
	public void testShouldUpdateExperience() {
	
		Experience newexp = new Experience();
		ExperienceResponse response = new ExperienceResponse();
		ExperienceRequest expReq = new ExperienceRequest();
		Party pty = new Party();
		pty.setId(1);
		pty.setEmail("email@gmail.com");
		newexp.setId(1);
		newexp.setWorkPlace("CHENNAI");
		newexp.setParty(pty);
		newexp.setJobTitle("JAVA DEVELOPER");
		newexp.setLocation("HYD");
		newexp.setDescription("I HAVE 2 YEARS OF WORKING EXPERIENCE IN JAVA");
		newexp.setStartMonth("nov");
		newexp.setStartYear(2);
		newexp.setOrderId(1);
		expReq.setId(1);
		expReq.setPtyId(1);
		expReq.setWorkPlace("mbf");
		expReq.setLocation("hyd");
		expReq.setJobTitle("java developer");
		expReq.setDecription("sedfrsf");
		expReq.setStartYear(2015);
		expReq.setStartMonth("nov");
		expReq.setEndYear(2016);
		expReq.setEndMonth("jan");
		when(partyRepository.findOne(1l)).thenReturn(pty);
		when(expRepository.findOne(1l)).thenReturn(newexp);
		newexp.setJobTitle("PHP DEVELOPER");
		when(expRepository.save(newexp)).thenReturn(newexp);
		Assert.assertNotNull(response);
		response = experienceServiceImpl.updateExperience(expReq, 1l);
		System.out.println(response.getExperience().getLocation());
		
	}

	@Test
	public void testShouldGetExperience()
	{
		Experience newexp = new Experience();
		ExperienceListResponse rep = new ExperienceListResponse();
		newexp.setId(1);
		newexp.setWorkPlace("CHENNAI");
		newexp.setJobTitle("JAVA DEVELOPER");
		newexp.setLocation("HYD");
		newexp.setDescription("I HAVE 2 YEARS OF WORKING EXPERIENCE IN JAVA");
		newexp.setStartMonth("nov");
		newexp.setStartYear(2);
		newexp.setOrderId(1);
		List<Experience> lstExp = new ArrayList<>();
		lstExp.add(newexp);
		when(expRepository.findExperienceById(1l)).thenReturn(lstExp);
		rep = experienceServiceImpl.getExperience(1l);
		Assert.assertNotNull(rep);
		System.out.println(rep.getStatusMessage());
		
	}
	
	@Test
	public void testShouldDeleteExperience(){
		
		Experience newexp = new Experience();
		Response response = new Response();
		newexp.setId(1);
		newexp.setWorkPlace("CHENNAI");
		newexp.setJobTitle("JAVA DEVELOPER");
		newexp.setLocation("HYD");
		newexp.setDescription("I HAVE 2 YEARS OF WORKING EXPERIENCE IN JAVA");
		newexp.setStartYear(3);
		newexp.setStartMonth("dec");
		newexp.setOrderId(1);
		response = experienceServiceImpl.deleteExperience(1l);
		verify(expRepository).delete(1l);
		Assert.assertNotNull(response);
		System.out.println(response.getStatusMessage());
	}
}
