package com.route21.ws.service;

import java.io.IOException;

import com.route21.ws.request.MailChimpSubscriptionRequest;

public interface MailChimpService {

	com.route21.ws.response.Response subscribeMail(MailChimpSubscriptionRequest request) throws IOException;

}
