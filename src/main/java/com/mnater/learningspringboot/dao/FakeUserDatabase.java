package com.mnater.learningspringboot.dao;

import com.mnater.learningspringboot.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FakeUserDatabase  implements UserDao {
	private Map<UUID, User> database;
	
	public FakeUserDatabase() {
		database = new HashMap<>();
		UUID jackUuid = UUID.randomUUID();
		User user = new User(jackUuid ,"Jack", "John", 19, "test@gmail.com", User.Gender.Male);
		database.put(jackUuid, user);
	}
	
	@Override
	public List<User> selectAllUsers() {
		return new ArrayList<>(database.values());
	}
	
	@Override
	public Optional<User> selectUser(UUID userUid) {
		return Optional.ofNullable(database.get(userUid));
	}
	
	@Override
	public int deleteUser(UUID userUid) {
		database.remove(userUid);
		return 1;
	}
	
	@Override
	public int updateUser(UUID userUid, User user) {
		 database.put(userUid, user);
		return 1;
	}
	
	@Override
	public int insertUser(User user) {
		 database.put(user.getUuid(), user);
		 return 1;
	}
}
