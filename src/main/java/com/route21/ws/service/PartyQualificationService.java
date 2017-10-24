package com.route21.ws.service;

import com.route21.ws.request.PartyQualificationRequest;
import com.route21.ws.response.PartyQualificationListResponse;
import com.route21.ws.response.PartyQualificationResponse;
import com.route21.ws.response.Response;


public interface PartyQualificationService {

	public PartyQualificationResponse savePartyQualification(PartyQualificationRequest request);

	public PartyQualificationResponse updatePartyQualification(Long id, PartyQualificationRequest request);

	public PartyQualificationListResponse getPartQualificationByPartyId(Long id);

	public Response deletePartyQualificationById(Long id);

}
