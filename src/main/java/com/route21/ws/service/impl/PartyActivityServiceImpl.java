package com.route21.ws.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

import com.route21.ws.bean.ActivityType;
import com.route21.ws.bean.Party;
import com.route21.ws.bean.PartyActivity;
import com.route21.ws.endpoint.ExperienceController;
import com.route21.ws.exception.DataNotFoundException;
import com.route21.ws.repository.ActivityTypeRepository;
import com.route21.ws.repository.PartyActivityRepository;
import com.route21.ws.repository.PartyRepository;
import com.route21.ws.request.PartyActivityRequest;
import com.route21.ws.response.PartyActivityListResponse;
import com.route21.ws.response.PartyActivityResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.PartyActivityService;

/**
 * 
 * This class gives PartyActivity details.
 * 
 * It throws exceptions like DataNotFoundException when user data not available.
 * 
 * @author admin-pc
 *
 */

@Transactional
@Service
public class PartyActivityServiceImpl implements PartyActivityService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PartyActivityServiceImpl.class);

	/**
	 * It inject {@link PartyActivity Service} object
	 */

	@Autowired
	PartyRepository partyRepository;

	@Autowired
	Environment env;

	@Autowired
	ActivityTypeRepository activityTypeRepository;

	@Autowired
	PartyActivityRepository partyActivityRepository;

	/**
	 * 
	 * This method is used to insert data into PartyActivity table.
	 * 
	 * This method consists of business logic which is used to add details into
	 * table.
	 * 
	 * @param request
	 *            contains attribute of {@link PartyActivityRequest}
	 *
	 * @return the response status message
	 * @throws IOException
	 * 
	 */
	@Override
	public PartyActivityResponse savePartyActivity(PartyActivityRequest request) throws IOException {
				PartyActivityResponse response = new PartyActivityResponse();
		LOGGER.info("------------errorrrrr-------------");
		Party pty = partyRepository.findOne(request.getPtyId());
		if (pty == null) {
			throw new DataNotFoundException("Party Not Found");
		}
		ActivityType act = activityTypeRepository.findOne(request.getActId());
		if (act == null) {
			throw new DataNotFoundException("Activity not Found");
		}

		PartyActivity pa = new PartyActivity();
		pa.setParty(pty);
		pa.setActivityType(act);
		pa.setShortDescription(request.getShortDescription());
		pa.setTitle(request.getTitle());
		pa.setDescription(request.getDescription());
		pa.setOrderId(request.getOrderId());
		pa.setActDate(request.getActDate());
		
		String folderName = "Party-" + String.valueOf(request.getPtyId());
		
		if (Files.isDirectory(Paths.get(env.getProperty("party.image.path") + "/" + folderName))) {
			File folder = new File(env.getProperty("party.image.path") + "/" + folderName);
			folder.mkdirs();
		}
		// ===========IMAGE-1===============
		if (request.getImage_1() != null && request.getImage_1().entrySet().iterator().hasNext()) {

				Map.Entry<String, String> image1 = request.getImage_1().entrySet().iterator().next();

				String imageName1 = image1.getKey();
				String imageValue1 = image1.getValue();

				String ext = FilenameUtils.getExtension(imageName1);
				imageName1 = FilenameUtils.getBaseName(imageName1);
				imageName1 += new DateTime().toString() + "." + ext;

				String imagePathForDB = env.getProperty("party.image.path.db") + folderName + "/" + imageName1;
				String imagePath = env.getProperty("party.image.path") + folderName + "/";

				String imagePath1 = imagePath + imageName1;

				if (!imageValue1.isEmpty()) {
					FileUtils.writeByteArrayToFile(new File(imagePath1), Base64.decodeBase64(imageValue1));
					pa.setImage_1(imagePathForDB);
				}

			}

		// ==============IMAGE-2===============
		if (request.getImage_2() != null && request.getImage_2().entrySet().iterator().hasNext()) {
			
				Map.Entry<String, String> image2 = request.getImage_2().entrySet().iterator().next();

				String imageName2 = image2.getKey();
				String imageValue2 = image2.getValue();

				String ext1 = FilenameUtils.getExtension(imageName2);
				imageName2 = FilenameUtils.getBaseName(imageName2);
				imageName2 += new DateTime().toString() + "." + ext1;

				String imagePathForDB1 = env.getProperty("party.image.path.db") + folderName + "/" + imageName2;
				String imagePath2 = env.getProperty("party.image.path") + folderName + "/";

				String imagePath3 = imagePath2 + imageName2;

				if (!imageValue2.isEmpty()) {
					FileUtils.writeByteArrayToFile(new File(imagePath3), Base64.decodeBase64(imageValue2));
					pa.setImage_2(imagePathForDB1);
				}

			}

		// =================IMAGE-3=============================
		if (request.getImage_3() != null && request.getImage_3().entrySet().iterator().hasNext()) {

				Map.Entry<String, String> image3 = request.getImage_3().entrySet().iterator().next();

				String imageName3 = image3.getKey();
				String imageValue3 = image3.getValue();

				String ext2 = FilenameUtils.getExtension(imageName3);
				imageName3 = FilenameUtils.getBaseName(imageName3);
				imageName3 += new DateTime().toString() + "." + ext2;

				String imagePathForDB2 = env.getProperty("party.image.path.db") + folderName + "/" + imageName3;
				String imagePath4 = env.getProperty("party.image.path") + folderName + "/";

				String imagePath5 = imagePath4 + imageName3;

				if (!imageValue3.isEmpty()) {
					FileUtils.writeByteArrayToFile(new File(imagePath5), Base64.decodeBase64(imageValue3));
					pa.setImage_3(imagePathForDB2);
				}

			}
		// ======================IMAGE-4=========================
		if (request.getImage_4() != null && request.getImage_4().entrySet().iterator().hasNext()) {
		
				Map.Entry<String, String> image4 = request.getImage_4().entrySet().iterator().next();

				String imageName4 = image4.getKey();
				String imageValue4 = image4.getValue();

				String ext3 = FilenameUtils.getExtension(imageName4);
				imageName4 = FilenameUtils.getBaseName(imageName4);
				imageName4 += new DateTime().toString() + "." + ext3;

				String imagePathForDB3 = env.getProperty("party.image.path.db") + folderName + "/" + imageName4;
				String imagePath6 = env.getProperty("party.image.path") + folderName + "/";

				String imagePath7 = imagePath6 + imageName4;

				if (!imageValue4.isEmpty()) {
					FileUtils.writeByteArrayToFile(new File(imagePath7), Base64.decodeBase64(imageValue4));
					pa.setImage_4(imagePathForDB3);
				}

			}

		PartyActivity partyActivity = partyActivityRepository.save(pa);

		response.setPartyActivity(partyActivity);
		response.setStatusCode(200);
		response.setStatusMessage("SAVED SUCCESSFULLY");

		return response;
	}

	/**
	 * 
	 * This method is used to update data into PartyActivity table.
	 * 
	 * This method consists of business logic which is used to update details of
	 * PartyActivity table.
	 * 
	 * @param request
	 *            contains attributes of {@link PartyActivityRequest}
	 * 
	 * @param1 partyActivityId id of PartyActivity.
	 *
	 * @return the response status message
	 * 
	 */

	@Override
	public PartyActivityResponse updatePartyActivity(Long partyActivityId, PartyActivityRequest request)
			throws IOException {
		PartyActivityResponse response = new PartyActivityResponse();
		PartyActivity pa = partyActivityRepository.findOne(partyActivityId);
		if (pa == null)
			throw new DataNotFoundException("PartyActivity not Found");
		Party pty = partyRepository.findOne(request.getPtyId());
		if (pty == null)
			throw new DataNotFoundException("Party Not Found");
		ActivityType act = activityTypeRepository.findOne(request.getActId());
		if (act == null)
			throw new DataNotFoundException("Activity not Found");
		pa.setParty(pty);
		pa.setActivityType(act);
		pa.setShortDescription(request.getShortDescription());
		pa.setTitle(request.getTitle());
		pa.setDescription(request.getDescription());
		pa.setOrderId(request.getOrderId());
		pa.setActDate(request.getActDate());
		String folderName = "Party-" + String.valueOf(request.getPtyId());

		if (Files.isDirectory(Paths.get(env.getProperty("party.image.path") + "/" + folderName))) {
			File folder = new File(env.getProperty("party.image.path") + "/" + folderName);
			folder.mkdirs();
		}
		// ===========IMAGE-1===============

		if (request.getImage_1() != null && request.getImage_1().entrySet().iterator().hasNext()) {
	
				Map.Entry<String, String> image1 = request.getImage_1().entrySet().iterator().next();

				String imageName1 = image1.getKey();
				String imageValue1 = image1.getValue();

				String ext = FilenameUtils.getExtension(imageName1);
				imageName1 = FilenameUtils.getBaseName(imageName1);
				imageName1 += new DateTime().toString() + "." + ext;

				String imagePathForDB = env.getProperty("party.image.path.db") + folderName + "/" + imageName1;
				String imagePath = env.getProperty("party.image.path") + folderName + "/";

				String imagePath1 = imagePath + imageName1;

				if (!imageValue1.isEmpty()) {
					FileUtils.writeByteArrayToFile(new File(imagePath1), Base64.decodeBase64(imageValue1));
					pa.setImage_1(imagePathForDB);
				}
			}

		
		// ==============IMAGE-2===============

		if (request.getImage_2() != null && request.getImage_2().entrySet().iterator().hasNext()) {
			
				Map.Entry<String, String> image2 = request.getImage_2().entrySet().iterator().next();

				String imageName2 = image2.getKey();
				String imageValue2 = image2.getValue();

				String ext1 = FilenameUtils.getExtension(imageName2);
				imageName2 = FilenameUtils.getBaseName(imageName2);
				imageName2 += new DateTime().toString() + "." + ext1;

				String imagePathForDB1 = env.getProperty("party.image.path.db") + folderName + "/" + imageName2;
				String imagePath2 = env.getProperty("party.image.path") + folderName + "/";

				String imagePath3 = imagePath2 + imageName2;

				if (!imageValue2.isEmpty()) {
					FileUtils.writeByteArrayToFile(new File(imagePath3), Base64.decodeBase64(imageValue2));
					pa.setImage_2(imagePathForDB1);
				}
			}
		
		// =================IMAGE-3=============================

		if (request.getImage_3() != null && request.getImage_3().entrySet().iterator().hasNext()) {
		
				Map.Entry<String, String> image3 = request.getImage_3().entrySet().iterator().next();

				String imageName3 = image3.getKey();
				String imageValue3 = image3.getValue();

				String ext2 = FilenameUtils.getExtension(imageName3);
				imageName3 = FilenameUtils.getBaseName(imageName3);
				imageName3 += new DateTime().toString() + "." + ext2;

				String imagePathForDB2 = env.getProperty("party.image.path.db") + folderName + "/" + imageName3;
				String imagePath4 = env.getProperty("party.image.path") + folderName + "/";

				String imagePath5 = imagePath4 + imageName3;

				if (!imageValue3.isEmpty()) {
					FileUtils.writeByteArrayToFile(new File(imagePath5), Base64.decodeBase64(imageValue3));
					pa.setImage_3(imagePathForDB2);
				}
			}
		
		// ======================IMAGE-4=========================
		if (request.getImage_4() != null && request.getImage_4().entrySet().iterator().hasNext()) {
		
				Map.Entry<String, String> image4 = request.getImage_4().entrySet().iterator().next();

				String imageName4 = image4.getKey();
				String imageValue4 = image4.getValue();

				String ext3 = FilenameUtils.getExtension(imageName4);
				imageName4 = FilenameUtils.getBaseName(imageName4);
				imageName4 += new DateTime().toString() + "." + ext3;

				String imagePathForDB3 = env.getProperty("party.image.path.db") + folderName + "/" + imageName4;
				String imagePath6 = env.getProperty("party.image.path") + folderName + "/";

				String imagePath7 = imagePath6 + imageName4;

				if (!imageValue4.isEmpty()) {
					FileUtils.writeByteArrayToFile(new File(imagePath7), Base64.decodeBase64(imageValue4));
					pa.setImage_4(imagePathForDB3);
				}

			}
		

		PartyActivity updatepartyActivity = partyActivityRepository.save(pa);

		response.setPartyActivity(updatepartyActivity);
		response.setStatusCode(200);
		response.setStatusMessage("UPDATED SUCCESSFULLY");

		return response;
	}

	/**
	 * 
	 * This method is used to list out data from PartyActivity table.
	 * 
	 * This method consists of business logic which is used to get details of
	 * PartyActivity table.
	 * 
	 * @param id
	 *            id of PartyActivity.
	 * 
	 * @return the response status message
	 * 
	 */

	@Override
	public PartyActivityListResponse getPartyActivityById(Long id) {

		PartyActivityListResponse response = new PartyActivityListResponse();
		List<PartyActivity> partyActivitylst = partyActivityRepository.findPartyActivityById(id);
		if (partyActivitylst != null) {
			response.setLstPartyActivity(partyActivitylst);
			response.setStatusCode(200);
			response.setStatusMessage("RETRIVED SUCCESSFULLY");
		} else {
			response.setStatusCode(204);
			response.setStatusMessage("Empty List");
		}

		return response;
	}

	/**
	 * 
	 * This method is used to delete data from PartyActivity table.
	 * 
	 * This method consists of business logic which is used to delete details of
	 * PartyActivity table.
	 * 
	 * @param id
	 *            contains id of PartyActivity.
	 * 
	 * @return the response status message
	 * 
	 */

	@Override
	public Response deletePartyActivityById(Long id) {

		Response response = new Response();

		PartyActivity partyActivity = partyActivityRepository.findOne(id);

		if (partyActivity != null) {
			try {

				partyActivityRepository.delete(id);
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
