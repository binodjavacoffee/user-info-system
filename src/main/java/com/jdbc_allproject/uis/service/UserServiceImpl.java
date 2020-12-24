package com.jdbc_allproject.uis.service;

import java.util.List;

import com.jdbc_allproject.uis.dao.UserDao;
import com.jdbc_allproject.uis.dao.UserDaoImpl;
import com.jdbc_allproject.uis.model.User;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();

	@Override
	public int saveUserInfo(User user) {

		return userDao.saveUserInfo(user);
	}

	@Override
	public int updateUserInfo(User user) {

		return userDao.updateUserInfo(user);
	}

	@Override
	public int deleteUserInfo(int id) {

		return userDao.deleteUserInfo(id);
	}

	@Override
	public List<User> getAllUserInfo() {

		return userDao.getAllUserInfo();
	}

	@Override
	public User getUserById(int id) {
		
		return userDao.getUserById(id);
	}

}
