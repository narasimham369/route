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

import com.route21.ws.bean.ActivityType;
import com.route21.ws.bean.Qualification;
import com.route21.ws.repository.QualificationRepository;
import com.route21.ws.response.ActivityTypeListResponse;
import com.route21.ws.response.QualificationListResponse;
import com.route21.ws.response.QualificationResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.impl.QualificationServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class QualificationServiceImplTest {
	
	@Mock
	QualificationRepository qualificationRepository;
	
	@InjectMocks
  	private final QualificationServiceImpl qualServiceImpl =new QualificationServiceImpl();
	
	
	@Test
	public void testShouldAddQualification()
	{
		QualificationResponse res = new QualificationResponse();
		Qualification newqualification = new Qualification();
		newqualification.setId(1);
		newqualification.setName("Btech");
		
		when(qualificationRepository.save(newqualification)).thenReturn(newqualification);
		res = qualServiceImpl.addQualification(newqualification);
		Assert.assertNotNull(res);
		
		System.out.println(res.getStatusMessage());
	}
	
	@Test
	public void testShouldUpdateQualification()
	{
		QualificationResponse response = new QualificationResponse();
		Qualification newqualification = new Qualification();
		newqualification.setId(1);
		newqualification.setName("Btech");
		when(qualificationRepository.findOne(1l)).thenReturn(newqualification);
		newqualification.setName("Mtech");
		when(qualificationRepository.save(newqualification)).thenReturn(newqualification);
		response = qualServiceImpl.updateQualification(newqualification);
		Assert.assertNotNull(response);
		System.out.println(response.getStatusMessage());
	}
	
	@Test
	public void testShouldGetQualification()
	{
		
		QualificationListResponse response = new QualificationListResponse();
		Qualification newqualification = new Qualification();
		newqualification.setId(1);
		newqualification.setName("Btech");
		List<Qualification> lstqual = new ArrayList<>();
		lstqual.add(newqualification);
		when(qualificationRepository.findAll()).thenReturn(lstqual);
		response = qualServiceImpl.getQualification();
		Assert.assertNotNull(response);
		System.out.println(response.getStatusMessage());
		
	}
	@Test
	public void testShouldDeleteQualification()
	{
		Qualification newqualification = new Qualification();
		Response response = new Response();
		newqualification.setId(1);
		newqualification.setName("Btech");
		response = qualServiceImpl.deleteQualification(1l);
		verify(qualificationRepository).delete(1l);
		Assert.assertNotNull(response);
		System.out.println(response.getStatusMessage());
	}
}
