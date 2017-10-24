package com.route21.ws.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.route21.ws.bean.Experience;
import com.route21.ws.bean.Party;
import com.route21.ws.endpoint.ExperienceController;
import com.route21.ws.exception.DataNotFoundException;
import com.route21.ws.repository.ExperienceRepository;
import com.route21.ws.repository.PartyRepository;
import com.route21.ws.request.ExperienceRequest;
import com.route21.ws.response.ExperienceListResponse;
import com.route21.ws.response.ExperienceResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.ExperienceService;

/**
 * 
 * This class gives Experience details.
 * 
 * It throws exceptions like DataNotFoundException when user data not available.
 * 
 * @author admin-pc
 * @param <applyOpnty>
 *
 */

@Transactional
@Service
public class ExperienceServiceImpl implements ExperienceService{

	private static final Logger LOGGER = LoggerFactory.getLogger(ExperienceServiceImpl.class);
	/**
	 * It inject {@link Experience Service} object
	 */
	
	@Autowired
	ExperienceRepository expRepository;
	
	@Autowired
	PartyRepository partyRepository;

	/**
	 * 
	 * This method is used to insert data into Experience table.
	 * 
	 * This method consists of business logic which is used to add details into
	 * table.
	 * 
	 * @param request
	 *            contains attribute of {@link ExperienceRequest}
	 *
	 * @return the response status message
	 * 
	 */
	@Override
	public ExperienceResponse addExperience(ExperienceRequest request) {
	
		
		Party pty = partyRepository.findOne(request.getPtyId());
		if(pty == null)
		{
			throw new DataNotFoundException("Party Not Found");
		}
		
		Experience exp = new Experience();
		
		exp.setId(request.getId());
		exp.setParty(pty);
		exp.setWorkPlace(request.getWorkPlace());
		exp.setLocation(request.getLocation());
		exp.setJobTitle(request.getJobTitle());
		exp.setDescription(request.getDecription());
		exp.setStartYear(request.getStartYear());
		exp.setStartMonth(request.getStartMonth());
		exp.setEndYear(request.getEndYear());
		exp.setEndMonth(request.getEndMonth());
		exp.setOrderId(request.getOrderId());
		Experience newexp = expRepository.save(exp);
		ExperienceResponse response = new ExperienceResponse();
		
		response.setExperience(newexp);
		response.setStatusCode(200);
		response.setStatusMessage("SAVED SUCCESSFULLY");
		return response;
	}

	/**
	 * 
	 * This method is used to update the data of Experience table.
	 * 
	 * @param request
	 *            contains attributes of {@link ExperienceRequest}
	 * 
	 * @param1 ExperienceId id of Experience.
	 *
	 * @return the response status message
	 * 
	 */
	@Override
	public ExperienceResponse updateExperience(ExperienceRequest request, Long id) {

		
		ExperienceResponse response = new ExperienceResponse();
		
		Experience exp = expRepository.findOne(id);
		if(exp== null)
		{
			throw new DataNotFoundException("Experience Not Found");
		}
		Party pty = partyRepository.findOne(request.getPtyId());
		if(pty == null)
		{
			throw new DataNotFoundException("Party Not Found");
		}
		exp.setParty(pty);
		exp.setWorkPlace(request.getWorkPlace());
		exp.setLocation(request.getLocation());
		exp.setJobTitle(request.getJobTitle());
		exp.setDescription(request.getDecription());
		exp.setStartYear(request.getStartYear());
		exp.setStartMonth(request.getStartMonth());
		exp.setEndYear(request.getEndYear());
		exp.setEndMonth(request.getEndMonth());
		exp.setOrderId(request.getOrderId());
		Experience updatedexp = expRepository.save(exp);
		
		response.setExperience(updatedexp);
		response.setStatusCode(200);
		response.setStatusMessage("UPDATED SUCCESSFULLY");
		return response;

	}

	/**
	 * This method is used to get data from Experience table using partyid.
	 * 
	 * @param id contains id of party.
	 * 
	 * @return the response status message
	 */
	@Override
	public ExperienceListResponse getExperience(Long id) {

		
		ExperienceListResponse rep = new ExperienceListResponse();
		List<Experience> lstExp = expRepository.findExperienceById(id);
		LOGGER.info("service"+id);
		if(lstExp != null)
		{
			rep.setLstExp(lstExp);
			rep.setStatusCode(200);
			rep.setStatusMessage("RETREIVED SUCCESSFULLY");
		}
		else
		{
			rep.setStatusCode(204);
			rep.setStatusMessage("Empty List");
		}
		
		return rep;
	}

	/**
	 * 
	 * This method is used to delete data from Experience table.
	 * 
	 * @param ExperienceId id of Experience.
	 *
	 * @return the response status message
	 * 
	 */
	
	@Override
	public Response deleteExperience(Long id) {

		
		Response response = new Response();
		try
		{
			expRepository.delete(id);
			response.setStatusCode(200);
			response.setStatusMessage("DELETED SUCCESSFULLY");
		}
		catch(Exception ex)
		{
			response.setStatusCode(500);
			response.setStatusMessage("INTERNAL SERVER ERROR");
		}
		return response;
	
	}
	
	

}
