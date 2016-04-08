package com.rec.demo.dao.embedded;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rec.demo.config.EmbeddedJpaConfig;

public class BaseDAOImpl {

	@PersistenceContext(unitName = EmbeddedJpaConfig.PU)
	protected EntityManager entityManager;

}
