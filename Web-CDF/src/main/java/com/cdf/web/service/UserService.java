package com.cdf.web.service;

import org.springframework.transaction.annotation.Transactional;

import com.cdf.dao.entity.Username;

public interface UserService {

	@Transactional
	void createUser(String uname, String upwd);
	public Username loadUserByUsername(long id);
}