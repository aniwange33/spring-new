package com.mnater.learningspringboot;

import com.mnater.learningspringboot.clientproxy.UserResourceV1;
import com.mnater.learningspringboot.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import java.util.UUID;
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
	void  shouldCreateUser(){
		//given
		UUID userUuid = UUID.randomUUID();
		User user = new User(userUuid, "John", "Mark", 19, "john@gmail.com", User.Gender.Male);
		//when
		userResourceV1.createUser(user);
		//then
		User john = userResourceV1.getUser(userUuid);
		assertThat(user).usingRecursiveComparison().isEqualTo(john);
	}

}
