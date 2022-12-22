package com.mnater.learningspringboot.resource;

import com.mnater.learningspringboot.model.User;
import com.mnater.learningspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.List;
import java.util.UUID;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("users")
@Validated
public class UserResource {
	private final UserService userService;
	
	@Autowired
	public UserResource(UserService userService) {
		this.userService = userService;
	}
	
	@GET
	@Produces(APPLICATION_JSON)
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
	@Path("{userUuid}")
	@GET
	@Produces(APPLICATION_JSON)
	public User getUser(@PathParam("userUuid") UUID userId) {
		return userService.getUser(userId);
	}

	//@Path("/create")
	@POST
	@Produces(APPLICATION_JSON)
	@Consumes(APPLICATION_JSON)
	public void createUser(@Valid User user) {
	 userService.createUser(user);
	}
	
	@PUT
	@Produces(APPLICATION_JSON)
	@Consumes(APPLICATION_JSON)
	public void editUser(User user){
	userService.updateUser(user);
	}
	
	@Path("{userUuid}")
	@DELETE
	@Produces(APPLICATION_JSON)
	public void deleteUser(@PathParam("userUuid") UUID userId){
		userService.deleteUser(userId);
	}
	
}
