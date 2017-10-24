package com.route21.ws.service;

import com.route21.ws.bean.Qualification;
import com.route21.ws.response.QualificationListResponse;
import com.route21.ws.response.QualificationResponse;
import com.route21.ws.response.Response;


public interface QualificationService {

	QualificationResponse addQualification(Qualification q);

	QualificationResponse updateQualification(Qualification q);

	QualificationListResponse getQualification();

	Response deleteQualification(Long id);

}
