package com.seven.team01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seven.team01.dao.UserDAO;
import com.seven.team01.model.User;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO udao;

	@Override
	public void createUser(User user) {
		udao.insertUser(user);
	}

	@Override
	public int checkID(String userID) {
		int result = udao.checkID(userID);
		return result;
	}
}
