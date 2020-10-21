package com.seven.team01.service;

import com.seven.team01.model.User;

public interface UserService {

	public void createUser(User user);
	public int checkID(String userID);
}
