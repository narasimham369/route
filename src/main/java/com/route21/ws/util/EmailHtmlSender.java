package com.route21.ws.util;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.route21.ws.constants.EmailConstants;


@Component
public class EmailHtmlSender {
    @Autowired
    private EmailSender emailSender;
    
    @Autowired
    Environment env;
    
    @Autowired
    private TemplateEngine templateEngine;
 
    public EmailStatus send(String to, String subject, String templateName, Context context) {
    	
    	/**
    	 * Site URL
    	 */
    	context.setVariable("site_url", EmailConstants.BASE_URL);
    	
    	context.setVariable("image_path", env.getProperty("context.url"));
    	/**
    	 * Social link
    	 */
    	context.setVariable("facebook_url", EmailConstants.FACEBOOK_URL);
    	context.setVariable("twitter_url", EmailConstants.TWITTER_URL);
    	context.setVariable("instagram_url", EmailConstants.INSTAGRAM_URL);
    	
    	/**
    	 * Footer menu link
    	 */
    	context.setVariable("privacy_policy", EmailConstants.PRIVACY_POLICY);
    	context.setVariable("tc_url", EmailConstants.TERMS_AND_CONDITIONS);
    	context.setVariable("unsubscribe", EmailConstants.UNSUBSCRIBE);
    	
        String body = templateEngine.process(templateName, context);
       
      
        
        return emailSender.sendHtml(to, subject, body);
    }
    
    /**
     * This method is used to generate the password.
     * 
     * @return string value contains the generated password.
     */
    public String pwdGenerate() {
    	int genNo = 10000000;
		Random r = new Random( System.currentTimeMillis() );
		int generatedNo = ((1 + r.nextInt(10)) * genNo + r.nextInt(genNo));
	    return Integer.toString(generatedNo);    	
    }
}
