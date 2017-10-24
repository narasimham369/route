package com.route21.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
/**
 * 
 * @author viswanath
 * This Class contains the main method to initialize the application.
 *
 */
@SpringBootApplication
public class Route21Application extends SpringBootServletInitializer {
	
	
	public static void main(String[] args) {
        SpringApplication.run(Route21Application.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Route21Application.class);
	}

}
