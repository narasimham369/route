package com.route21.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.route21.ws.bean.Qualification;
import com.route21.ws.repository.QualificationRepository;
import com.route21.ws.response.QualificationListResponse;
import com.route21.ws.response.QualificationResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.QualificationService;

/**
* 
* This class gives Qualification details of party.
* 
* It throws exceptions like DataNotFoundException when user data not available.
* 
* @author admin-pc
*
*/

@Service
public class QualificationServiceImpl implements QualificationService{

	/**
	 * It inject {@link Qualification Service} object
	 */
	@Autowired
	QualificationRepository qualificationRepository;
	
	/**
	 * 
	 * This  method is used to insert data into Qualification table.
	 * 
	 * This method consists of business logic which is used to add details into table.
	 * 
	 * @param q contains attribute of {@link Qualification}
	 *
	 * @return the response status message
	 * 
	 */
	
	@Override
	public QualificationResponse addQualification(Qualification q) {

		QualificationResponse res = new QualificationResponse();
		Qualification qual =  qualificationRepository.save(q);
		res.setQualification(qual);
		res.setStatusCode(200);
		res.setStatusMessage("SUCCESSFULLY INSERTED");
		return res;
	}

	/**
	 * 
	 * This  method is used to update data into Qualification table.
	 * 
	 * This method consists of business logic which is used to update details of Qualification table.
	 * 
	 * @param q contains attributes of {@link Qualification}
	 *
	 * @return the response status message
	 * 
	 */
	
	@Override
	public QualificationResponse updateQualification(Qualification q) {

		QualificationResponse response = new QualificationResponse();
		Qualification qual = qualificationRepository.findOne(q.getId());
		qual.setName(q.getName());
		Qualification updatedQual = qualificationRepository.save(qual);
		response.setQualification(updatedQual);
		response.setStatusCode(200);
		response.setStatusMessage("UPDATED SUCCESSFULLY");
		return response;
	}

	/**
	 * 
	 * This  method is used to get data from Qualification table.
	 * 
	 * This method consists of business logic which is used to get details of Qualification table.
	 * 
	 * @return the response status message
	 * 
	 */
	@Override
	public QualificationListResponse getQualification() {

		QualificationListResponse response = new QualificationListResponse();
		List<Qualification> lstQualification = qualificationRepository.findAll();
		response.setLstQualification(lstQualification);
		response.setStatusCode(200);
		response.setStatusMessage("RETRIEVED SUCCESSFULLY");
		return response;
	}

	/**
	 * 
	 * This  method is used to delete data from Qualification table.
	 * 
	 * This method consists of business logic which is used to delete details of Qualification table.
	 * 
	 * @param id contains id of qualification.
	 * 
	 * @return the response status message
	 * 
	 */
	@Override
	public Response deleteQualification(Long id) {

		Response response = new Response();
		try
		{
			qualificationRepository.delete(id);
			response.setStatusCode(200);
			response.setStatusMessage("DELETED SUCCESSFULLY");
		}
		catch(Exception ex)
		{
			response.setStatusCode(500);
			response.setStatusMessage("INTERNALSERVER ERROR");
		}
		return response;
	}

}
