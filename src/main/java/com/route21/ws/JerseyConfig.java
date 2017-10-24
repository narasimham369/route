package com.route21.ws;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.route21.ws.filter.AuthenticationFilter;
import com.route21.ws.filter.CORSResponseFilter;
import com.route21.ws.filter.JWTRequestFilter;
/**
 * 
 * @author viswanath
 *
 *JerseyConfiguration Class used to register endpoint classes, exceptionmapper and filters
 */

@Configuration
public class JerseyConfig extends ResourceConfig {	
	
	public JerseyConfig() {
		packages("com.route21.ws.endpoint");
		register(CORSResponseFilter.class);
		register(AuthenticationFilter.class);
		register(JWTRequestFilter.class);
		packages("com.route21.ws.exceptionmapper");
		JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JodaModule());
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		property(ServletProperties.FILTER_FORWARD_ON_404, true);
		provider.setMapper(new JodaMapper());
		register(provider);
		
	}
	
	
}
