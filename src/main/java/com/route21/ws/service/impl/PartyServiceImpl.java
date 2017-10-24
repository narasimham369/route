package com.route21.ws.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import com.route21.ws.bean.Party;
import com.route21.ws.bean.PartyType;
import com.route21.ws.bean.UserLogin;
import com.route21.ws.constants.EmailConstants;
import com.route21.ws.exception.DataNotFoundException;
import com.route21.ws.exception.EmailAlreadyRegisteredException;
import com.route21.ws.helper.EncryptDecrypt;
import com.route21.ws.repository.PartyRepository;
import com.route21.ws.repository.PartyTypeRepository;
import com.route21.ws.repository.UserLoginRepository;
import com.route21.ws.request.RegisterPartyRequest;
import com.route21.ws.request.UpdatePartyRequest;
import com.route21.ws.response.NameListResponse;
import com.route21.ws.response.RegisterPartyResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.PartyService;
import com.route21.ws.types.PartyTypeEnum;
import com.route21.ws.util.EmailHtmlSender;

/**
 * 
 * This class gives Party details.
 * 
 * @author viswanath
 *
 */

@Service
@Transactional
public class PartyServiceImpl implements PartyService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PartyServiceImpl.class);

    @Autowired
    protected UserLoginRepository userLoginRepository;

    @Autowired
    Environment env;

    /**
     * It inject {@link Party Service} object
     */
    @Autowired
    protected PartyRepository partyRepository;

    @Autowired
    protected PartyTypeRepository partyTypeRepository;

    @Autowired
    protected EncryptDecrypt encryptDecrypt;

    @Autowired
    protected EmailHtmlSender emailHtmlSender;

    /**
     * 
     * This method is used to register new user.
     * 
     * This method consists of business logic which is used to add details into
     * table.
     * 
     * @param request
     *            contains attribute of {@link RegisterPartyRequest}
     * 
     * @throws EmailAlreadyRegisteredException
     *             if email id already exist.
     *
     * @return the response status message
     * 
     */
    @Override
    public RegisterPartyResponse regiterParty(RegisterPartyRequest request) {
        RegisterPartyResponse response = new RegisterPartyResponse();

        UserLogin loginexist = userLoginRepository.findEmailExist(request.getEmail());
        if (loginexist != null) {
            throw new EmailAlreadyRegisteredException("Already registered user,use Signin to Proceed");
        }

        PartyType ptype = partyTypeRepository.findOne(request.getPartyType());

        Party pty = new Party();
        pty.setName(request.getPartyName());
        pty.setEmail(request.getEmail());
        pty.setDescription("Hi " + request.getName() + " " + request.getLastName());
        pty.setPartyType(ptype);
        pty.setIndustryType(request.getIndusrtyType());
        pty.setOnBoardScreen("YES");
        UserLogin ulogin = new UserLogin();
        ulogin.setFirstName(request.getName());
        ulogin.setLastName(request.getLastName());
        ulogin.setLoginId(request.getEmail());
        if (ptype.getId() == PartyTypeEnum.Student.value) {
            ulogin.setLoginPassword(encryptDecrypt.encrypt(request.getPassword()));

        } else if (ptype.getId() == PartyTypeEnum.Employer.value) {
            pty.setMobileno(request.getMobileno());
            pty.setEmployerWebsite(request.getEmployerWebsite());
            pty.setSocialMedia(request.getSocialMedia());
        }
        ulogin.setVerifyStatus("Y");
        ulogin.setParty(pty);
        ulogin.setStatus(request.getStatus());

        UserLogin newUser = userLoginRepository.save(ulogin);

        Context context = new Context();
        LOGGER.info("EMAIL CONSTANTS "+EmailConstants.SIGN_IN);
        if (ptype.getId() == PartyTypeEnum.Student.value) {

            context.setVariable("email", request.getEmail());
            LOGGER.info("PASSWORD " + request.getPassword());
            context.setVariable("password", request.getPassword());
            context.setVariable("profile", EmailConstants.PROFILE);
            context.setVariable("dashboard", EmailConstants.DASHBOARD);
            context.setVariable("signin", EmailConstants.SIGN_IN);
            context.setVariable("name", request.getName());
            emailHtmlSender.send(request.getEmail(), EmailConstants.REGISTERATION_SUB + request.getName(), "email/register", context);
        } else if (ptype.getId() == PartyTypeEnum.Employer.value) {

            context.setVariable("email", request.getEmail());
         
            context.setVariable("profile", EmailConstants.PROFILE);
            context.setVariable("dashboard", EmailConstants.DASHBOARD);

            context.setVariable("firstName", request.getName());
            context.setVariable("lastName", request.getLastName());
            context.setVariable("organizationName", request.getPartyName());
            context.setVariable("mobileNumber", request.getMobileno());
            context.setVariable("stories", EmailConstants.STORIES);
            
            LOGGER.info("LINK  "+EmailConstants.SIGN_IN);
            emailHtmlSender.send(request.getEmail(), EmailConstants.REGISTERATION_SUB, "email/emp-register", context);
             emailHtmlSender.send(env.getProperty("spring.adminmail"), EmailConstants.REGISTERATION_ADMIN, "email/adminEmp-Register", context);
        }
        response.setStatusCode(200);
        response.setStatusMessage("Party Registered Successfully");
        response.setUserLogin(newUser);

        return response;
    }

    /**
     * 
     * This method is used to get the list of users from Party table.
     * 
     * This method consists of business logic which is used to get details of
     * Party table.
     * 
     * @return the response status message
     * 
     */
    @Override
    public NameListResponse getNameListofEmployeerandInstitute() {

        NameListResponse response = new NameListResponse();
        List<Party> partyList = partyRepository.getNameListofEmployeerandInstitute();
        HashMap<String, List> map = new HashMap<String, List>();
        ArrayList alEmployeer = new ArrayList();
        ArrayList alInstitute = new ArrayList();
        for (Iterator<Party> itr = partyList.iterator(); itr.hasNext();) {
            Party pty = (Party) itr.next();
            if (pty.getPartyType().getId() == PartyTypeEnum.Employer.value)
                alEmployeer.add(pty.getName());
            else
                alInstitute.add(pty.getName());
        }
        map.put("EMPLOYEER", alEmployeer);
        map.put("INSTITUTE", alInstitute);

        response.setStatusCode(200);
        response.setStatusMessage("Successfully Received");
        response.setMap(map);

        return response;
    }

    @Override
    public Response updateparty(Long id, UpdatePartyRequest request) throws IOException {

                Response response = new Response();

        Party pty = partyRepository.findOne(id);
        if (pty == null)
            throw new DataNotFoundException("Party Not Found");
        pty.setDescription(request.getDescription());
        pty.setDob(request.getDob());
        pty.setName(request.getName());
        pty.setOnBoardScreen(request.getOnBoardScreen());
        pty.setEmployerWebsite(request.getEmployerWebsite());
        pty.setLocation(request.getLocation());
        pty.setSocialMedia(request.getSocialMedia());
        String folderName = "Party-" + id.toString();
        LOGGER.info("IMAGE PATH " + env.getProperty("party.image.path"));

        if (Files.isDirectory(Paths.get(env.getProperty("party.image.path") + "/" + folderName))) {
            File folder = new File(env.getProperty("party.image.path") + "/" + folderName);
            folder.mkdirs();
        }
        
        if(request.getImage() != null && request.getImage().entrySet().iterator().hasNext())
        {
        	Map.Entry<String, String> imageentry1 = request.getImage().entrySet().iterator().next();
        		String imageName1 = imageentry1.getKey();
        		String imageValue1 = imageentry1.getValue();

        		String ext = FilenameUtils.getExtension(imageName1);
        		imageName1 = FilenameUtils.getBaseName(imageName1);
        		imageName1 += new DateTime().toString() + "." + ext;

        		String imagePathForDB = env.getProperty("party.image.path.db") + folderName + "/" + imageName1;
        		String imagePath = env.getProperty("party.image.path") + folderName + "/";

        		String imagePath1 = imagePath + imageName1;
        		if (!imageValue1.isEmpty()) {
        			FileUtils.writeByteArrayToFile(new File(imagePath1), Base64.decodeBase64(imageValue1));
        			pty.setImage(imagePathForDB);
        		}
        	
        }
        Party upatedParty = partyRepository.save(pty);
        response.setStatusCode(200);
        response.setStatusMessage("Updated Successfully");

        return response;
    }

	
}
