package com.cdf.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdf.dao.entity.Username;
import com.cdf.dao.sql.UserDao;
import com.cdf.dao.sql.impl.UserDaoImpl;
import com.cdf.web.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;


	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	@Override
	public void createUser(String uname, String upwd) {
		Username u = new Username();
		u.setUsername(uname);
		u.setPassword(upwd);
		userDao.create(u);
	}

	@Override
	public Username loadUserByUsername(long id) {
		return userDao.loadUserByUsername(id);
	}
}