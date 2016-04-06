package com.rec.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseDAOImpl {

	@PersistenceContext
	protected EntityManager entityManager;

}
