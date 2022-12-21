package com.mnater.learningspringboot.service;

import com.mnater.learningspringboot.dao.UserDao;
import com.mnater.learningspringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
	
	
	public Optional<User> getUser(UUID userUid) {
	 return userDao.selectUser(userUid);
	}
	
	
	public int removeUser(UUID userUid) {
		Optional<User> user = userDao.selectUser(userUid);
		if (user.isPresent()) {
		   return userDao.deleteUser(userUid);
		}
		return -1;
		
	}
	
	
	public int updateUser(UUID userUid, User user) {
		Optional<User> userOpt = userDao.selectUser(userUid);
		if (userOpt.isPresent()) {
			return userDao.updateUser(userUid, user);
		}
		return -1;
	}
	

	public int createUser(User user) {
		return userDao.insertUser(user);
	}
}
