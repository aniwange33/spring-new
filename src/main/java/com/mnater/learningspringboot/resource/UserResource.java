package com.mnater.learningspringboot.resource;

import com.mnater.learningspringboot.model.User;
import com.mnater.learningspringboot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.List;
import java.util.UUID;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("users")
@Validated
@Api(value = "User resource", produces = "application/json")
public class UserResource {
	private final UserService userService;
	
	@Autowired
	public UserResource(UserService userService) {
		this.userService = userService;
	}
	
	@GET
	@Produces(APPLICATION_JSON)
	@ApiOperation(value = "Get users resource. Version 1 - (version in URL)", response = User.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "users resource found")
	})
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
	public User createUser(@Valid User user) {
	 return userService.createUser(user);
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
