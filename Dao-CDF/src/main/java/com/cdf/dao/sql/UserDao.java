package com.cdf.dao.sql;

import com.cdf.dao.entity.Username;


public interface UserDao extends GenericDao<Username> {
	/**
	 * Returns an User object that matches the username given
	 * 
	 * @param username
	 * @return
	 */
	public Username loadUserByUsername(long id);
}