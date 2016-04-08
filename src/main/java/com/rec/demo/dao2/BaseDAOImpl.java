package com.rec.demo.dao2;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseDAOImpl {

	@PersistenceContext(unitName = "pu2")
	protected EntityManager entityManager;

}
