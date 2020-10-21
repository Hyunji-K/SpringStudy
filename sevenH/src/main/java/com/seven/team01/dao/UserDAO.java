package com.seven.team01.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seven.team01.model.User;
@Repository
public class UserDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void insertUser(User user) {
		int rowcnt = sqlSessionTemplate.insert("user_ns.insertUser", user);
		System.out.println(rowcnt + "행 삽입");
		}

	public int checkID(String userID) {
		int result = sqlSessionTemplate.selectOne("user_ns.checkID", userID);
		return result;
	}
	
}
