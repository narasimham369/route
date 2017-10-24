package com.route21.ws.service;

import javax.servlet.http.HttpServletResponse;

import com.route21.ws.request.LoginRequest;
import com.route21.ws.request.ResetPasswordRequest;
import com.route21.ws.request.UserStatusRequest;
import com.route21.ws.response.RegisterPartyResponse;
import com.route21.ws.response.RegisteredPartyListResponse;
import com.route21.ws.response.Response;

public interface UserLoginService {

	public RegisterPartyResponse userLogin(LoginRequest request);
	
	public Response userForgotPwd(LoginRequest request);

	public RegisterPartyResponse resetPassword(ResetPasswordRequest request);

	public RegisteredPartyListResponse getUserList();
	
	public RegisterPartyResponse getUserById(Long id);

	public Response updateUserStatus(UserStatusRequest request);

	public RegisterPartyResponse userLogin(LoginRequest request, HttpServletResponse httpresponse);
	
	public Response lifeRayAdmin(LoginRequest request, HttpServletResponse httpresponse);

}
