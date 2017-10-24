package com.route21.ws.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import com.route21.ws.bean.ApplyOpportunity;
import com.route21.ws.bean.Opportunity;
import com.route21.ws.bean.Party;
import com.route21.ws.bean.PartyActivity;
import com.route21.ws.bean.PartyQualification;
import com.route21.ws.bean.UserLogin;
import com.route21.ws.constants.EmailConstants;
import com.route21.ws.exception.DataNotFoundException;
import com.route21.ws.repository.ApplyOpportunityRepository;
import com.route21.ws.repository.OpportunityRepository;
import com.route21.ws.repository.PartyActivityRepository;
import com.route21.ws.repository.PartyQualificationRepository;
import com.route21.ws.repository.PartyRepository;
import com.route21.ws.request.ApplyOpportunityRequest;
import com.route21.ws.response.ApplyOpportunityListResponse;
import com.route21.ws.response.ApplyOpportunityMapResponse;
import com.route21.ws.response.ApplyOpportunityResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.ApplyOpportunityService;
import com.route21.ws.types.PartyActivityTypeEnum;
import com.route21.ws.util.EmailHtmlSender;


/**
 * 
 * This class gives ApplyOpportunity details.
 * 
 * It throws exceptions like DataNotFoundException when user data not available.
 * 
 * @author admin-pc
 * @param <applyOpnty>
 *
 */

@Transactional
@Service
public class ApplyOpportunityServiceImpl implements ApplyOpportunityService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplyOpportunityServiceImpl.class);
	/**
	 * It inject {@link PartyActivity Service} object
	 */

	@Autowired
	ApplyOpportunityRepository applyOpntyRepository;

	@Autowired
	PartyRepository ptyRepository;

	@Autowired
	OpportunityRepository opntyRepository;

	@Autowired
	PartyQualificationRepository partyQualificationRepository;

	@Autowired
	PartyActivityRepository ptyActRepository;

	@Autowired
	protected EmailHtmlSender emailHtmlSender;

	/**
	 * 
	 * This method is used to insert data into Applyopportunity table.
	 * 
	 * This method consists of business logic which is used to add details into
	 * table.
	 * 
	 * @param request
	 *            contains attribute of {@link ApplyOpportunityRequest}
	 *
	 * @return the response status message
	 * 
	 */

	@Override
	public ApplyOpportunityResponse saveApplyopportunity(ApplyOpportunityRequest request) {


		ApplyOpportunityResponse resp = new ApplyOpportunityResponse();
		UserLogin ul = new UserLogin();
		Party pty = ptyRepository.findOne(request.getPartyId());

		if (pty == null) {
			throw new DataNotFoundException(" Party not found");
		}

		Opportunity opnty = opntyRepository.findOne(request.getOpportunityId());
		if (opnty == null) {

			throw new DataNotFoundException("Opportunity not found");
		}
		List<PartyQualification> lstPtyQualification = partyQualificationRepository.findByPtyId(request.getPartyId());
		
		List<PartyActivity> partyActivitylstskills = ptyActRepository
				.findPtyActivityListByPtyIdAndActId(request.getPartyId(), PartyActivityTypeEnum.SKILLS.type);
		List<PartyActivity> partyActivitylstAchivements = ptyActRepository
				.findPtyActivityListByPtyIdAndActId(request.getPartyId(), PartyActivityTypeEnum.ACHIEVEMENTS.type);
		List<PartyActivity> partyActivitylstHobbies = ptyActRepository.findPtyActivityListByPtyIdAndActId(
				request.getPartyId(), PartyActivityTypeEnum.HOBBIESANDINTEREST.type);
		PartyActivity ptyAct = ptyActRepository.findPtyActivityByPtyIdAndActid(request.getPartyId(),
				PartyActivityTypeEnum.COVERIMAGE.type);

		Context context = new Context();
	
		if (lstPtyQualification.isEmpty() || lstPtyQualification == null ) 		
			throw new DataNotFoundException("Looks like you blanked out! Please complete your profile to proceed.");
		if (partyActivitylstskills == null || partyActivitylstskills.isEmpty()) 
			throw new DataNotFoundException(" Looks like you blanked out! Please complete your profile to proceed. ");
		if (partyActivitylstAchivements == null || partyActivitylstAchivements.isEmpty())				
			throw new DataNotFoundException("Looks like you blanked out! Please complete your profile to proceed.");					
		if (partyActivitylstHobbies == null || partyActivitylstHobbies.isEmpty()) 
			throw new DataNotFoundException("Looks like you blanked out! Please complete your profile to proceed.");
		if (ptyAct == null) 
			throw new DataNotFoundException("Looks like you blanked out! Please complete your profile to proceed.");
		
		ApplyOpportunity applyOpnty = new ApplyOpportunity();
		applyOpnty.setParty(pty);
		applyOpnty.setOpportunity(opnty);
		applyOpnty.setStatus(request.getStatus());
		applyOpnty.setStatusReason(request.getStatusReason());

		applyOpnty.setApplyDate(request.getApplyDate());

		ApplyOpportunity newapplyOpnty = applyOpntyRepository.save(applyOpnty);
		LOGGER.info("before send");
		context.setVariable("fname", ul.getFirstName());
		context.setVariable("id", opnty.getId());
		context.setVariable("lname", ul.getLastName());
		context.setVariable("name", pty.getName());
		context.setVariable("orgName", opnty.getParty().getName());
		context.setVariable("post", opnty.getRole());
		context.setVariable("opportunity", EmailConstants.OPPORTUNITY_LINK + opnty.getId());
		context.setVariable("link", EmailConstants.STUDENTPROFILE_LINK + pty.getId());
		emailHtmlSender.send(pty.getEmail(), EmailConstants.APPLYINGJOB_STUDENT + opnty.getParty().getName(),
				"email/applyJob-student", context);
		emailHtmlSender.send(opnty.getParty().getEmail(), pty.getName() + EmailConstants.APPLYINGJOB_EMPLOYER,
				"email/applyJob-emp", context);
		LOGGER.info("after send");
		resp.setApplyOpportunity(newapplyOpnty);
		resp.setStatusCode(200);
		resp.setStatusMessage("You have successfully applied for the job");
		return resp;
				
	}

	/**
	 * 
	 * This method is used to update data into ApplyOpportunity table.
	 * 
	 * This method consists of business logic which is used to update details of
	 * ApplyOpportunity table.
	 * 
	 * @param request
	 *            contains attributes of {@link ApplyOpportunityRequest}
	 * 
	 * @param1 ApplyOpportunityId id of ApplyOpportunity.
	 *
	 * @return the response status message
	 * 
	 */

	@Override
	public ApplyOpportunityResponse updateApplyOpportunity(Long id, ApplyOpportunityRequest request) {


		ApplyOpportunityResponse resp = new ApplyOpportunityResponse();

		ApplyOpportunity applyOpnty = applyOpntyRepository.findOne(id);
		if (applyOpnty == null) {
			throw new DataNotFoundException("Applyopportunity not found");
		}
		Opportunity opty = opntyRepository.findOne(request.getOpportunityId());
		if (opty == null) {
			throw new DataNotFoundException("Opportunity not found");
		}
		Party pty = ptyRepository.findOne(request.getPartyId());
		if (pty == null) {
			throw new DataNotFoundException("Party not found");
		}

		applyOpnty.setParty(pty);
		applyOpnty.setOpportunity(opty);
		applyOpnty.setStatus(request.getStatus());
		applyOpnty.setStatusReason(request.getStatusReason());
		applyOpnty.setApplyDate(request.getApplyDate());
		ApplyOpportunity updatedApplyOpnty = applyOpntyRepository.save(applyOpnty);

		resp.setApplyOpportunity(updatedApplyOpnty);
		resp.setStatusCode(200);
		resp.setStatusMessage("UPDATED SUCCESSFULLY");
		return resp;
	}

	// map key is Opportunity id, value is list of students who applied for
	// particular job.
	@Override
	public ApplyOpportunityMapResponse getApplyOpportunity() {


		ApplyOpportunityMapResponse resp = new ApplyOpportunityMapResponse();

		List<Opportunity> listOpnty = opntyRepository.findAll();
		
		Map<Integer, List<ApplyOpportunity>> map = new HashMap<Integer, List<ApplyOpportunity>>();
		for (Opportunity opportunity : listOpnty) {

			List<ApplyOpportunity> listApplyOpnty = applyOpntyRepository
					.findApplyOpportunityByOpportunityId(opportunity.getId());
			if (listApplyOpnty.isEmpty() || !(listApplyOpnty == null)) {
				map.put((int) opportunity.getId(), listApplyOpnty);

			}
		}
		if (map != null) {

			resp.setStatusCode(200);
			resp.setStatusMessage("RETREIVED SUCCESSFULLY");
			resp.setMapResponse(map);
		} else {
			resp.setStatusCode(204);
			resp.setStatusMessage("Empty List");
		}

		return resp;
	}

	@Override
	public ApplyOpportunityListResponse getApplyOpportunityByPartyId(Long id) {


		ApplyOpportunityListResponse resp = new ApplyOpportunityListResponse();
		List<ApplyOpportunity> lstApplyOpnty = applyOpntyRepository.findApplyOpportunityByPartyId(id);

		if (lstApplyOpnty != null) {
			resp.setLstApplyOpnty(lstApplyOpnty);
			resp.setStatusCode(200);
			resp.setStatusMessage("RETREIVED SUCCESSFULLY");
		}

		else {
			resp.setStatusCode(204);
			resp.setStatusMessage("LIST IS EMPTY");
		}

		return resp;

	}

	

	/**
	 * 
	 * This method is used to list out data from ApplyOpportunity table.
	 * 
	 * This method consists of business logic which is used to get details of
	 * PartyActivity table.
	 * 
	 * @param id
	 *            id of ApplyOpportunity.
	 * 
	 * @return the response status message
	 * 
	 */

	@Override
	public Response deleteApplyOpportunityById(Long id) {


		Response response = new Response();

		ApplyOpportunity ApplyOpnty = applyOpntyRepository.findOne(id);

		if (ApplyOpnty != null) {
			try {

				applyOpntyRepository.delete(id);
				response.setStatusCode(200);
				response.setStatusMessage("DELETE SUCCESSFULLY");
			} catch (Exception e) {
				response.setStatusCode(500);
				response.setStatusMessage("INTERNAL SERVER ERROR");
			}
		}

		return response;
	}

}
