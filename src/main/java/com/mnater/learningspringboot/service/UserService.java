package com.mnater.learningspringboot.service;

import com.mnater.learningspringboot.dao.UserDao;
import com.mnater.learningspringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
	
	private final UserDao userDao;
	
	@Autowired
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public List<User> getAllUsers() {
		return userDao.selectAllUsers();
	}
	
	
	public User getUser(UUID userUid) {
	 return getDatabaseUser(userUid);
	}
	
	
	public void removeUser(UUID userUid) {
			User databaseUser = getDatabaseUser(userUid);
			userDao.deleteUser(databaseUser.getUuid());
	}
	
	
	public void updateUser(User user) {
		User databaseUser = getDatabaseUser(user.getUuid());
		userDao.updateUser(databaseUser.getUuid(), user);
	}
	
	private User getDatabaseUser(UUID userUid) {
		return userDao.selectUser(userUid).orElseThrow(() -> new NotFoundException("user not found with id " + userUid));
	}
	
	
	public void createUser(User user) {
		if(user.getUuid() == null) {
			user.setUuid(UUID.randomUUID());
		}
	   userDao.insertUser(user);
	}
	
	public void deleteUser(UUID userId) {
		userDao.deleteUser(userId);
	}
}
