package com.route21.ws.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.route21.ws.bean.Party;
import com.route21.ws.bean.PartyQualification;
import com.route21.ws.bean.Qualification;
import com.route21.ws.endpoint.ExperienceController;
import com.route21.ws.exception.DataNotFoundException;
import com.route21.ws.repository.PartyQualificationRepository;
import com.route21.ws.repository.PartyRepository;
import com.route21.ws.repository.QualificationRepository;
import com.route21.ws.request.PartyQualificationRequest;
import com.route21.ws.response.PartyQualificationListResponse;
import com.route21.ws.response.PartyQualificationResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.PartyQualificationService;

/**
* 
* This class gives PartyQualification details of party.
* 
* It throws exceptions like DataNotFoundException when user data not available.
* 
* @author admin-pc
*
*/
@Transactional
@Service
public class PartyQualificationServiceImpl implements PartyQualificationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PartyQualificationServiceImpl.class);

	/**
	 * It inject {@link PartyQualification Service} object
	 */
	@Autowired
	PartyRepository partyRepository;
	
	@Autowired
	QualificationRepository qualificationRepository;
	
	@Autowired
	PartyQualificationRepository partyQualificationRepository;
	
	/**
	 * 
	 * This  method is used to insert data into PartyQualification table.
	 * 
	 * This method consists of business logic which is used to add details into table.
	 * 
	 * @param request contains attribute of {@link PartyQualificationRequest}
	 *
	 * @return the response status message
	 * 
	 */
	
	@Override
	public PartyQualificationResponse savePartyQualification(PartyQualificationRequest request) {
		PartyQualificationResponse response = new PartyQualificationResponse();
		
		PartyQualification ptyQual = new PartyQualification();
		Party pty = partyRepository.findOne(request.getPartyId());
		LOGGER.info("id of party"+pty.getId()); 
		if(pty == null)
			throw new DataNotFoundException("Party not Found");
		Qualification qual = qualificationRepository.findOne(request.getQualificationId());
		if(qual == null)
			throw new DataNotFoundException("Qualification not Found");
		ptyQual.setParty(pty);
		ptyQual.setQualification(qual);
		ptyQual.setInstituttionName(request.getInstituteName());
		ptyQual.setCompletedOn(request.getCompletedOn());
		ptyQual.setDescription(request.getDescription());
		ptyQual.setGrade(request.getGrade());
		ptyQual.setMajor(request.getMajor());
		ptyQual.setOrderId(request.getOrderId());
		ptyQual.setStartedOn(request.getStartedOn());
		ptyQual.setOtherQualification(request.getOtherQualification());
		ptyQual.setLocation(request.getLocation());
		PartyQualification savedPtyQual = partyQualificationRepository.save(ptyQual);
		response.setPartyQualification(savedPtyQual);
		response.setStatusCode(200);
		response.setStatusMessage("INSERTED SUCCESSFULLY");
		
		return response;
	}

	/**
	 * 
	 * This  method is used to update data into PartyQualification table.
	 * 
	 * This method consists of business logic which is used to update details of PartyQualification table.
	 * 
	 * @param request contains attributes of {@link PartyQualificationRequest}
	 * 
	 * @param1 id of PartyQualification
	 *
	 * @return the response status message
	 * 
	 */
	
	@Override
	public PartyQualificationResponse updatePartyQualification(Long id,PartyQualificationRequest request) {
		
		PartyQualificationResponse response = new PartyQualificationResponse();
		
		PartyQualification ptyQual = partyQualificationRepository.findOne(id);
		if(ptyQual == null)
			throw new DataNotFoundException("PartyQualification not Found");
		Party pty = partyRepository.findOne(request.getPartyId());
		if(pty == null)
			throw new DataNotFoundException("Party not Found");
		Qualification qual = qualificationRepository.findOne(request.getQualificationId());
		if(qual == null)
			throw new DataNotFoundException("Qualification not Found");
		ptyQual.setParty(pty);
		ptyQual.setQualification(qual);
		ptyQual.setInstituttionName(request.getInstituteName());
		ptyQual.setCompletedOn(request.getCompletedOn());
		ptyQual.setDescription(request.getDescription());
		ptyQual.setGrade(request.getGrade());
		ptyQual.setMajor(request.getMajor());
		ptyQual.setOrderId(request.getOrderId());
		ptyQual.setStartedOn(request.getStartedOn());
		ptyQual.setOtherQualification(request.getOtherQualification());
		ptyQual.setLocation(request.getLocation());
		PartyQualification savedPtyQual = partyQualificationRepository.save(ptyQual);
		response.setPartyQualification(savedPtyQual);
		response.setStatusCode(200);
		response.setStatusMessage("UPDATED SUCCESSFULLY");
		
		return response;
	
	}

	/**
	 * 
	 * This  method is used to get data from PartyQualification table.
	 * 
	 * This method consists of business logic which is used to get details of PartyQualification table.
	 * 
	 * @return the response status message
	 * 
	 */
	
	@Override
	public PartyQualificationListResponse getPartQualificationByPartyId(Long id) {
		PartyQualificationListResponse response = new PartyQualificationListResponse();
		
		List<PartyQualification> lstPtyQualification = partyQualificationRepository.findByPtyId(id);
		if(lstPtyQualification != null)
		{
			response.setPartyQualificationList(lstPtyQualification);
			response.setStatusCode(200);
			response.setStatusMessage("RETRIEVED SUCCESSFULLY");
		}
		else
		{
			response.setStatusCode(204);
			response.setStatusMessage("Empty List");
		}
		
		return response;
	}

	/**
	 * 
	 * This  method is used to delete data from PartyQualification table.
	 * 
	 * This method consists of business logic which is used to delete details of PartyQualification table.
	 * 
	 * @param id contains id of PartyQualification.
	 * 
	 * @return the response status message
	 * 
	 */
	
	@Override
	public Response deletePartyQualificationById(Long id) {

		
		Response response= new Response();
		PartyQualification partyQualification= partyQualificationRepository.findOne(id);
		
		if(partyQualification!= null)
		{
			try{
				partyQualificationRepository.delete(id);
				response.setStatusCode(200);
				response.setStatusMessage("DELETE SUCCESSFULLY");
				
			}
			catch(Exception e){
				
				response.setStatusCode(500);
				response.setStatusMessage("INTERNAL SERVER ERROR");
			}
		}
		
		return response;
	}
	
}
