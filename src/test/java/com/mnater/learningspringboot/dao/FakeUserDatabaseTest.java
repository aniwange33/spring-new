package com.mnater.learningspringboot.dao;

import com.mnater.learningspringboot.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class FakeUserDatabaseTest {

	private FakeUserDatabase fakeUserDatabase;

	@BeforeEach
	void setUp() {
		fakeUserDatabase = new FakeUserDatabase();
	}

	@Test
	void ShouldSelectAllUsers() {
		List<User> users = fakeUserDatabase.selectAllUsers();
		assertThat(users).hasSize(1);
		User user = users.get(0);
		assertThat(user.getGender()).isEqualTo(User.Gender.Male);
		assertThat(user.getAge()).isEqualTo(19);

	}

	@Test
	void ShouldSelectUser() {
	}

	@Test
	void deleteUser() {
	}

	@Test
	void updateUser() {
	}

	@Test
	void insertUser() {
	}
}