package com.route21.ws.service;

import java.io.IOException;

import com.route21.ws.request.PartyActivityRequest;
import com.route21.ws.response.PartyActivityListResponse;
import com.route21.ws.response.PartyActivityResponse;
import com.route21.ws.response.Response;


public interface PartyActivityService {

	public PartyActivityResponse savePartyActivity(PartyActivityRequest request) throws IOException;

	public PartyActivityResponse updatePartyActivity(Long partyActivityId, PartyActivityRequest request) throws IOException;

	public PartyActivityListResponse getPartyActivityById(Long id);
	
	public Response deletePartyActivityById(Long id);

}
