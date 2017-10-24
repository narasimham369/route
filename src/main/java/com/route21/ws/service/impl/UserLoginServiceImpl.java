package com.route21.ws.service.impl;

import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import com.route21.ws.bean.UserLogin;
import com.route21.ws.constants.EmailConstants;
import com.route21.ws.exception.DataNotFoundException;
import com.route21.ws.exception.EmployerNotApprovedException;
import com.route21.ws.exception.LoginCredentialNotMatchedException;
import com.route21.ws.exception.LoginIdNotExistsException;
import com.route21.ws.helper.EncryptDecrypt;
import com.route21.ws.helper.JWTokenUtility;
import com.route21.ws.repository.PartyRepository;
import com.route21.ws.repository.UserLoginRepository;
import com.route21.ws.request.LoginRequest;
import com.route21.ws.request.ResetPasswordRequest;
import com.route21.ws.request.UserStatusRequest;
import com.route21.ws.response.RegisterPartyResponse;
import com.route21.ws.response.RegisteredPartyListResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.UserLoginService;
import com.route21.ws.types.PartyTypeEnum;
import com.route21.ws.util.EmailHtmlSender;

/**
 * 
 * It is the implementation of user login service interface.
 * 
 * This class contains Logger tool for showing the structure.
 * 
 * It has implementation for methods which are declared in login service
 * interface.
 * 
 * It has some annotations to inject an object from one layer to another layer.
 * 
 * It has exceptions like LoginCredentialNotMatchedException when Either Userid
 * or password is not Correct.
 * 
 * @author admin-pc
 *
 */
@Service
@Transactional
public class UserLoginServiceImpl implements UserLoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginServiceImpl.class);
    @Autowired
    protected UserLoginRepository userLoginRepository;

    @Autowired
    protected PartyRepository partyRepository;

    @Autowired
    protected EmailHtmlSender emailHtmlSender;

    @Autowired
    protected EncryptDecrypt encryptDecrypt;

    @Autowired
    protected JWTokenUtility jwtTokenUtility;

    PartyTypeEnum pa;

    /**
     * 
     * This user login method is implementation for user login abstract
     * 
     * method which was declared in user login service interface.
     * 
     * It checks whether user successfully logged in or not.
     * 
     * @throws LoginCredentialNotMatchedException
     *             If user gave any incorrect credentials, then it throws this
     *             exception.
     * 
     */
    @Override
    public RegisterPartyResponse userLogin(LoginRequest request, HttpServletResponse httpresponse) {
    	System.out.println("reached serviceimpl");
        RegisterPartyResponse response = new RegisterPartyResponse();
        System.out.println("LoginId ::::: " +request.getLoginId());
        UserLogin userlogin = userLoginRepository.findUserLogin(request.getLoginId(),
               encryptDecrypt.encrypt(request.getLoginPwd()));

        if (userlogin != null && userlogin.getStatus().equalsIgnoreCase("N"))
            throw new LoginCredentialNotMatchedException("Your Account is not Active,Contact Route21 admin");

        if (userlogin != null && userlogin.getVerifyStatus().equalsIgnoreCase("Y")) {
            String partyName = userlogin.getParty().getName();
            String role = userlogin.getParty().getPartyType().getType();
            String email = userlogin.getLoginId();
            long ptyId = userlogin.getParty().getId();
            UUID cookie = UUID.randomUUID();
            userlogin.setCookie(cookie.toString());
            userLoginRepository.save(userlogin);

            response.setStatusCode(200);
            response.setStatusMessage("Login Successful");
           
            response.setUserLogin(userlogin);

            String token = jwtTokenUtility.buildJWT(cookie.toString(), partyName, role, email, ptyId);// JWT Tocken generated

           // httpresponse.setHeader("Authorization", "Bearer " + token);
            response.setAuthtoken(token);
            System.out.println("service ended");
             } else
            throw new LoginCredentialNotMatchedException("Either Userid or password is not Correct");

        return response;
    }

    /**
     * 
     * This method is used for user forgot password at any time.
     * 
     * If user forgot password, a email will be send to the mail to recover that
     * password.
     * 
     * It will send a temporary password.
     * 
     * @throws LoginIdNotExistsException
     *             If login id does not exist.
     * 
     * @return the response of object which says about status of the request.
     * 
     */
	@Override
	public Response userForgotPwd(LoginRequest request) {
		UserLogin userLogin = userLoginRepository.findByLoginId(request.getLoginId());
		Response response = new Response();
		if (userLogin != null) {
			System.out.println("status"+ userLogin.getStatus());
			if (userLogin.getStatus().equals("Y")) {
				String temporaryPwd = emailHtmlSender.pwdGenerate();
				userLogin.setVerifyCode(temporaryPwd);
				userLogin.setVerifyStatus("N");
				userLoginRepository.saveAndFlush(userLogin);
				/*
				 * Forgot password email
				 */
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();

				String pwdEncryption = dateFormat.format(date) + "|" + userLogin.getLoginId() + "|" + temporaryPwd;
				System.out.println("PWD " + pwdEncryption);

				String baseencode_str = "", res1;

				try {
					res1 = UserLoginServiceImpl.encode(pwdEncryption);
					baseencode_str = UserLoginServiceImpl.encode(res1);
				} catch (Exception e) {
		
					e.printStackTrace();
				}
				LOGGER.debug("BASE ENCODE STRING " + baseencode_str);
				LOGGER.info("BASE 64 ENCODE " + baseencode_str);
				Context context = new Context();
				context.setVariable("name", userLogin.getFirstName());
				context.setVariable("link", EmailConstants.RESET_LINK + baseencode_str);
				emailHtmlSender.send(userLogin.getLoginId(), EmailConstants.FORGOT_PWD_SUB, "email/forgot-password",
						context);

				response.setStatusCode(200);
				response.setStatusMessage("Email has been sent to your email!");
			} else {
				throw new EmployerNotApprovedException("Your account is not approved, please contact Route21 admin.");
			}
		} else {
			throw new LoginIdNotExistsException("Email not exists!");
		}
		return response;
	}

    /**
     * 
     * This method is used for reset the password.
     * 
     * If any time user want to change the password then this method will be
     * used.
     * 
     * @throws LoginCredentialNotMatchedException
     *             if credentials are not matched with the data base details.
     * 
     * @return response object which has login details status.
     */
    public RegisterPartyResponse resetPassword(ResetPasswordRequest request) {
        RegisterPartyResponse response = new RegisterPartyResponse();
        UserLogin userlogin;
        if (request.getOldLoginPass() != null && !(request.getOldLoginPass().equals("")))
            userlogin = userLoginRepository.findUserLogin(request.getLoginId(),
                    encryptDecrypt.encrypt(request.getOldLoginPass()));
        else
            userlogin = userLoginRepository.findUserByIdandVerifycode(request.getLoginId(), request.getVerifyCode());
        if (userlogin != null) {
            userlogin.setVerifyStatus("Y");
            userlogin.setLoginPassword(encryptDecrypt.encrypt(request.getNewLoginPass()));
            UserLogin user = userLoginRepository.save(userlogin);
            response.setStatusCode(200);
            response.setStatusMessage("Password Changed Successfully");
            response.setUserLogin(user);
        } else {
            throw new LoginCredentialNotMatchedException("Either email or password incorrect!");
        }

        return response;
    }

    /**
     * 
     * It encrypted the password with the date to send an email to the user.
     * 
     * @param value
     *            encrypted value.
     * 
     * @return value which will be encrypted.
     * 
     * @throws Exception
     */
    public static String encode(String value) throws Exception {
        return DatatypeConverter.printBase64Binary(value.getBytes(StandardCharsets.UTF_8)); // use
                                                                                            // "utf-8"
                                                                                            // if
                                                                                            // java
                                                                                            // 6
    }

    /**
     * 
     * This method says about the list of users who are registered.
     * 
     * @return response list object which contains the users list.
     * 
     */
    @Override
    public RegisteredPartyListResponse getUserList() {
                RegisteredPartyListResponse responseList = new RegisteredPartyListResponse();
        List<UserLogin> ulList = userLoginRepository.findAll(orderBy("id"));
        responseList.setLstUserLogin(ulList);
        responseList.setStatusCode(200);
        responseList.setStatusMessage("Successfully Received");

        return responseList;
    }

    /**
     * 
     * This method puts the records in ascending order using user id.
     * 
     * @param id
     *            user id.
     * 
     * @return list and ids of the user.
     * 
     */
    private Sort orderBy(String id) {
        return new Sort(Sort.Direction.DESC, id);
    }

    @Override
    public Response updateUserStatus(UserStatusRequest request) {
                Response response = new Response();
        UserLogin ul = userLoginRepository.findOne(request.getUserId());
        if (ul != null && ul.getLoginId().equalsIgnoreCase(request.getLoginId())) {

            if (ul.getParty().getPartyType().getId() == PartyTypeEnum.Employer.value && ul.getStatus().equalsIgnoreCase("W")
                    && request.getStatus().equalsIgnoreCase("Y")) {
                ul.setStatus("Y");

                String temporaryPwd = emailHtmlSender.pwdGenerate();
                ul.setVerifyCode(temporaryPwd);
                ul.setVerifyStatus("N");
                UserLogin userlogin = userLoginRepository.saveAndFlush(ul);
                /*
                 * Forgot password email
                 */

                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();

                String pwdEncryption = dateFormat.format(date) + "|" + userlogin.getLoginId() + "|" + temporaryPwd;
                System.out.println("PWD " + pwdEncryption);

                String baseencode_str = "", res1;

                try {
                    res1 = UserLoginServiceImpl.encode(pwdEncryption);
                    baseencode_str = UserLoginServiceImpl.encode(res1);
                } catch (Exception e) {
                                        e.printStackTrace();
                }
                LOGGER.debug("BASE ENCODE STRING " + baseencode_str);
                System.out.println("BASE 64 ENCODE " + baseencode_str);
                Context context = new Context();
                context.setVariable("name", userlogin.getFirstName());
                context.setVariable("link", EmailConstants.RESET_LINK + baseencode_str);
                context.setVariable("organizationName", ul.getParty().getName());
                emailHtmlSender.send(userlogin.getLoginId(), EmailConstants.AUTHORIZE_EMPLOYEER, "email/authorize-emp",
                        context);

                response.setStatusCode(200);
                response.setStatusMessage("Email has been sent to your email!");

            } else
                ul.setStatus(request.getStatus());

            UserLogin updated = userLoginRepository.save(ul);
            response.setStatusCode(200);
            response.setStatusMessage("Updated Successfully");
        } else
            throw new DataNotFoundException("UserLogin Not Found");

        return response;
    }

    @Override
    public RegisterPartyResponse userLogin(LoginRequest request) {
                return null;
    }

	@Override
	public RegisterPartyResponse getUserById(Long id) {
				RegisterPartyResponse resp = new RegisterPartyResponse();
		
		UserLogin userLogin = userLoginRepository.findByPartyId(id);

		if(userLogin != null)
		{
			
			resp.setUserLogin(userLogin);
			resp.setStatusCode(200);
			resp.setStatusMessage("Successfully Received");
		}
		else
		{
			resp.setStatusCode(204);
			resp.setStatusMessage("Empty List");
		}
		return resp;
	}
	
	@Override
	public Response lifeRayAdmin(LoginRequest request, HttpServletResponse httpresponse) {
		System.out.println("reach serviceimpl");
		Response response = new Response();
		
		if(request.getLoginId().equals("admin@liferay.com") && request.getLoginPwd().equals("Route21"))
		{
		
			String token = jwtTokenUtility.buildJWT(" ", "lifeRayAdmin", "ADMIN", "admin@liferay.com", 0);// JWT Tocken generated
        
			httpresponse.setHeader("Authorization", "Bearer " + token);
        
			response.setStatusCode(200);
			response.setStatusMessage("liferay admin token generated");
		}
		else
			 throw new LoginCredentialNotMatchedException(" Userid/password is not Correct");
        return response;
	}
	
}
