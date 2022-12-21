package com.mnater.learningspringboot.config;



import com.mnater.learningspringboot.resource.UserResource;
import org.glassfish.jersey.server.ResourceConfig;

import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;


@Component
@ApplicationPath("/api/v1/")
public class RestConfig extends ResourceConfig {
	public RestConfig() {
		register(UserResource.class);
	}
}


