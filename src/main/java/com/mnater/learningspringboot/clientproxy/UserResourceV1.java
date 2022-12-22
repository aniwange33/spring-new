package com.mnater.learningspringboot.clientproxy;

import com.mnater.learningspringboot.model.User;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.List;
import java.util.UUID;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public interface UserResourceV1 {
	
	@GET
	@Produces(APPLICATION_JSON)
	public List<User> getUsers();
	
	@Path("{userUuid}")
	@GET
	@Produces(APPLICATION_JSON)
	public User getUser(@PathParam("userUuid") UUID userId);
	
	
	@POST
	@Produces(APPLICATION_JSON)
	@Consumes(APPLICATION_JSON)
	public void createUser(@Valid  User user) ;
	
	@PUT
	@Produces(APPLICATION_JSON)
	@Consumes(APPLICATION_JSON)
	public void editUser(@Valid User user);
}
