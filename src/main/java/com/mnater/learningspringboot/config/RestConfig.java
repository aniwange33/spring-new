package com.mnater.learningspringboot.config;



import com.mnater.learningspringboot.resource.UserResource;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;


@Component
@ApplicationPath("/api/v1/")
public class RestConfig extends ResourceConfig {
	
	
	public RestConfig() {
		register(UserResource.class);
	}
	
	@PostConstruct
	public void init() {
		// Register components where DI is needed
		this.configureSwagger();
	}
	private void configureSwagger() {
		// Available at localhost:port/api/swagger.json
		this.register(ApiListingResource.class);
		this.register(SwaggerSerializers.class);
		
		BeanConfig config = new BeanConfig();
		config.setConfigId("learning spring boot with Nelson");
		config.setTitle("Spring boot using jersey and swagger");
		config.setVersion("v1");
		config.setContact("tertese amos @data-fi");
		config.setSchemes(new String[] { "http", "https" });
		config.setBasePath("/api/v1");
		config.setResourcePackage("com.mnater.learningspringboot.resource");
		config.setPrettyPrint(true);
		config.setScan(true);
	}
}


