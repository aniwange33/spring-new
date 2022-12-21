package com.mnater.learningspringboot.clientproxy;

import com.mnater.learningspringboot.model.User;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public interface UserResourceV1 {
	
	@Path("/getAllUsers")
	@GET
	@Produces(APPLICATION_JSON)
	public List<User> getUsers();
	
	@Path("{userUuid}")
	@GET
	@Produces(APPLICATION_JSON)
	public Response getUser(@PathParam("userUuid") UUID userId);
	
	@Path("/create")
	@POST
	@Produces(APPLICATION_JSON)
	@Consumes(APPLICATION_JSON)
	public Response createUser(@RequestBody User user) ;
	
	@Path("/edit/{userId}")
	@PUT
	@Produces(APPLICATION_JSON)
	@Consumes(APPLICATION_JSON)
	public Response editUser(@PathParam("userId") UUID userId, @RequestBody User user);
}
