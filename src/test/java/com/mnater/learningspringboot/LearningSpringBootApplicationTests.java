package com.mnater.learningspringboot;

import com.mnater.learningspringboot.clientproxy.UserResourceV1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class LearningSpringBootApplicationTests {

	@Autowired
	private UserResourceV1 userResourceV1;
//	@Test
//	void contextLoads() {
//	}
	
	@Test
	void  shouldGetAllUsers(){
		assertThat(userResourceV1.getUsers()).hasSize(1);
		assertThat(userResourceV1.getUsers().get(0)).isNotNull();
	}

}
