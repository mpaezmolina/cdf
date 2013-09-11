package com.cdf.dao;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cdf.dao.entity.Username;
 
public class PersonTest {
 
    private EntityManagerFactory emf;
    private EntityManager em;
 
    @Before
    public void initEmfAndEm() {
        BasicConfigurator.configure();
        Logger.getLogger("org").setLevel(Level.ERROR);
 
        emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }
 
    @After
    public void cleanup() {
        em.close();
    }
 
    @SuppressWarnings("unchecked")
    @Test
    public void insertAndRetrieve() {
        em.getTransaction().begin();
        
        
        Username res = em.find(Username.class, (long)31);
        System.out.println(res.getUsername());
        
        Username username = new Username();
        username.setEmail("paezmolina@gmail.com");
        username.setFirstname("Matias");
        username.setLastname("Paez Molina");
        username.setUsername("omplog");
        username.setPassword("123");
        
        em.persist(username);
        em.getTransaction().commit();
 
    }
}