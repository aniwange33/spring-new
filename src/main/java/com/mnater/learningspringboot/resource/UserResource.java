package com.mnater.learningspringboot.resource;

import com.mnater.learningspringboot.model.User;
import com.mnater.learningspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("users")
public class UserResource {
	private final UserService userService;
	
	@Autowired
	public UserResource(UserService userService) {
		this.userService = userService;
	}
	
	@Path("/getAllUsers")
	@GET
	@Produces(APPLICATION_JSON)
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
	@Path("{userUuid}")
	@GET
	@Produces(APPLICATION_JSON)
	public Response getUser(@PathParam("userUuid") UUID userId) {
		Optional<User> userOptional = userService.getUser(userId);
		if(userOptional.isPresent()) {
			return Response.ok(userOptional.get()).build();
		}else return Response.status(Response.Status.NOT_FOUND)
				.entity("user with userId "+userId+" is not found")
				.build();

	}

	@Path("/create")
	@POST
	@Produces(APPLICATION_JSON)
	@Consumes(APPLICATION_JSON)
	public Response createUser(@RequestBody User user) {
		int result = userService.createUser(user);
		if(result == 1){
			return Response.ok().build();
		}
		return Response.status(Response.Status.BAD_REQUEST).build();
	}

	@Path("/edit/{userId}")
	@PUT
	@Produces(APPLICATION_JSON)
	@Consumes(APPLICATION_JSON)
	public Response editUser(@PathParam("userId") UUID userId, @RequestBody User user){
		int result = userService.updateUser(userId, user);
		if(result == -1){
			return Response.ok().build();
		}
		return Response.status(Response.Status.BAD_REQUEST).build();
	}
}
