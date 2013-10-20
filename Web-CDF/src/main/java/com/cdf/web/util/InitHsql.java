package com.cdf.web.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdf.dao.entity.Username;

public class InitHsql {
	private static final Logger logger = LoggerFactory
			.getLogger(InitHsql.class);
	
	private EntityManagerFactory emf;
	private EntityManager em;

	public void initIt() throws Exception {
		logger.info("Init HSQL.");

		emf = Persistence.createEntityManagerFactory("hsqlCdf");
		em = emf.createEntityManager();

		em.getTransaction().begin();

		Username username = new Username();
		username.setEmail("paezmolina@gmail.com");
		username.setFirstname("Matias");
		username.setLastname("Paez Molina");
		username.setUsername("MatiasPM");
		username.setPassword("123");

		em.persist(username);
		em.getTransaction().commit();

	}

	public void cleanUp() throws Exception {
		logger.info("Destroy.");
	}

}