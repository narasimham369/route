package com.route21.ws.service;

import java.io.IOException;

import com.route21.ws.request.RegisterPartyRequest;
import com.route21.ws.request.UpdatePartyRequest;
import com.route21.ws.response.NameListResponse;
import com.route21.ws.response.RegisterPartyResponse;
import com.route21.ws.response.Response;

public interface PartyService {

	public RegisterPartyResponse regiterParty(RegisterPartyRequest request);

	public NameListResponse getNameListofEmployeerandInstitute();

	public Response updateparty(Long id, UpdatePartyRequest request) throws IOException;
	
}
