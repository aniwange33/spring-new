package com.mnater.learningspringboot;

import com.mnater.learningspringboot.clientproxy.UserResourceV1;
import com.mnater.learningspringboot.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ExceptionHandler;



import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class LearningSpringBootApplicationTests {

	@Autowired
	private UserResourceV1 userResourceV1;

	
	@Test
	void  shouldGetAllUsers(){
		assertThat(userResourceV1.getUsers()).hasSize(2);
		assertThat(userResourceV1.getUsers().get(0)).isNotNull();
	}
	
	@Test
	@ExceptionHandler()
	void  shouldCreateUser(){
		//given
		User user = new User("John", "Mark", 19, "john@gmail.com", User.Gender.Male);
		
		//when
		User user1 = userResourceV1.createUser(user);
		
		//then
		assertThat(user1).usingRecursiveComparison().isEqualTo(user);
	}

}
