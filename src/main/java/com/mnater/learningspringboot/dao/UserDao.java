package com.mnater.learningspringboot.dao;
import com.mnater.learningspringboot.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface UserDao {
	List<User> selectAllUsers();
	Optional<User>  selectUser(UUID userUid);
	int deleteUser(UUID userUid);
	int  updateUser(UUID userUid, User user);
	int  insertUser(User user);
}
