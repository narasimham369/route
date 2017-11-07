package com.Route21.ws.service.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.route21.ws.bean.ActivityType;
import com.route21.ws.bean.Experience;
import com.route21.ws.bean.Party;
import com.route21.ws.bean.PartyActivity;
import com.route21.ws.repository.ActivityTypeRepository;
import com.route21.ws.repository.PartyActivityRepository;
import com.route21.ws.repository.PartyRepository;
import com.route21.ws.request.PartyActivityRequest;
import com.route21.ws.response.ExperienceListResponse;
import com.route21.ws.response.PartyActivityListResponse;
import com.route21.ws.response.PartyActivityResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.impl.PartyActivityServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PartyActivityServiceImplTest {
	
	@Mock
	PartyRepository partyRepository;
	
	@Mock
	Environment env;
	
	@Mock
	PartyActivityRepository partyActivityRepository;
	
	@Mock
	ActivityTypeRepository activityTypeRepository;
	
	@InjectMocks
	private final PartyActivityServiceImpl partyActivityServiceImpl= new PartyActivityServiceImpl();
	
	@Test
	public void testShouldAddPartyActivity() throws IOException
	{
		PartyActivityResponse response = new PartyActivityResponse();
		Party pty = new Party();
		pty.setId(1);
		pty.setEmail("email@gmail.com");
		
		ActivityType act = new 	ActivityType();
		act.setId(1);
		act.setType("skills");
		
		PartyActivity pa = new PartyActivity();
		pa.setParty(pty);
		pa.setActivityType(act);
		pa.setShortDescription("I have good knowledge in java");
		pa.setTitle("java");
		pa.setDescription("I have good knowledge in php");
		pa.setOrderId(1l);
		
		PartyActivityRequest ptyReq = new PartyActivityRequest();
		ptyReq.setPtyId(1);
		ptyReq.setActId(1);
		ptyReq.setShortDescription("I have good knowledge in java");
		ptyReq.setTitle("java");
		ptyReq.setDescription("I have good knowledge in php");
		ptyReq.setOrderId(1l);
		
		when(partyRepository.findOne(1l)).thenReturn(pty);
		when(activityTypeRepository.findOne(1l)).thenReturn(act);
		when(partyActivityRepository.save(pa)).thenReturn(pa);
		
		response = partyActivityServiceImpl.savePartyActivity(ptyReq);
		System.out.println(response.getStatusMessage());
	}
	
	@Test
	public void testShouldUpdatePartyActivity() throws IOException{
		
		Party pty = new Party();
		pty.setId(1);
		pty.setEmail("email@gmail.com");
	
		ActivityType act = new 	ActivityType();
		act.setId(1);
		act.setType("skills");
		
		PartyActivity partyActivity = new PartyActivity();
		partyActivity.setDescription("description");
		partyActivity.setId(1);
		partyActivity.setShortDescription("shortDescription");
		partyActivity.setTitle("title");
		
		PartyActivity pa = new PartyActivity();
		pa.setParty(pty);
		pa.setActivityType(act);
		pa.setShortDescription("I have good knowledge in java");
		pa.setTitle("java");
		pa.setDescription("I have good knowledge in php");
		pa.setOrderId(1l);
		
		PartyActivityResponse resp= new PartyActivityResponse();
		PartyActivityRequest ptyReq = new PartyActivityRequest();
		ptyReq.setPtyId(1);
		ptyReq.setActId(1);
		ptyReq.setShortDescription("I have good knowledge in java");
		ptyReq.setTitle("java");
		ptyReq.setDescription("I have good knowledge in php");
		ptyReq.setOrderId(1l);
		when(activityTypeRepository.findOne(1l)).thenReturn(act);
		when(partyRepository.findOne(1l)).thenReturn(pty);
		when(partyActivityRepository.findOne(1l)).thenReturn(partyActivity);
		
		resp = partyActivityServiceImpl.updatePartyActivity(1l, ptyReq);
		
		System.out.println(resp.getStatusMessage());
	}
	
	@Test
	public void testShouldGetPartyActivity(){
		
		PartyActivity partyActivity = new PartyActivity();
		PartyActivityListResponse response = new PartyActivityListResponse();
		List partyActivitylst = new ArrayList<PartyActivity>();
		partyActivity.setDescription("description");
		partyActivity.setId(1);
		partyActivity.setShortDescription("shortDescription");
		partyActivity.setTitle("title");
		partyActivitylst.add(partyActivity);
		
		when(partyActivityRepository.findPartyActivityById(1l)).thenReturn(partyActivitylst);
		response = partyActivityServiceImpl.getPartyActivityById(1l);
		Assert.assertNotNull(response);
		System.out.println(response.getStatusMessage());
	}
	@Test
	public void testShouldDeletePartyActivity(){		
		
		PartyActivity partyActivity = new PartyActivity();
		Response response = new Response();
		partyActivity.setDescription("description");
		partyActivity.setId(1);
		partyActivity.setShortDescription("shortDescription");
		partyActivity.setTitle("title");
		
		when(partyActivityRepository.findOne(1l)).thenReturn(partyActivity);
		response = partyActivityServiceImpl.deletePartyActivityById(1l);
		verify(partyActivityRepository).delete(1l);
		Assert.assertNotNull(response);
		System.out.println(response.getStatusMessage());
		
	}
}
