package com.rec.demo.dao.sqlserver;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rec.demo.config.SQLServerJpaConfig;

public class BaseDAOImpl {

	@PersistenceContext(unitName = SQLServerJpaConfig.PU)
	protected EntityManager entityManager;

}
