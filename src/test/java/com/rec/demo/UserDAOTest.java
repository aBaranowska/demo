package com.rec.demo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rec.demo.config.JpaConfig;
import com.rec.demo.config.PropertyConfig;
import com.rec.demo.dao.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JpaConfig.class, PropertyConfig.class })
public class UserDAOTest {

	@Autowired
	private UserDAO userDAO;

	@Test
	@Rollback(true)
	public void getAllUsers() {
		assertTrue(userDAO.getAllUsers().size() == 0);
	}

}
