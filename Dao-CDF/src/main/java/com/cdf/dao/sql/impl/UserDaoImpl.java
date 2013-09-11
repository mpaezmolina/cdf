package com.cdf.dao.sql.impl;

import org.springframework.stereotype.Repository;

import com.cdf.dao.entity.Username;
import com.cdf.dao.sql.UserDao;

//@Component("userDao")
@Repository
public class UserDaoImpl extends GenericDaoImpl<Username> implements UserDao {

	/*
	public Username loadUserByUsername(String username) {
		Query query = this.em
				.createQuery("select u FROM User u where u.username= :username");
		query.setParameter("username", username);
		List<Username> users = query.getResultList();
		if (users != null && users.size() == 1) {
			return users.get(0);
		}
		return null;
	}
	*/
	
	public Username loadUserByUsername(long id) {
		return em.find(Username.class, id);
	}

}