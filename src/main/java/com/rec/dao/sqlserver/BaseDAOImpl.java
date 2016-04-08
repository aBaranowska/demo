package com.rec.dao.sqlserver;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rec.config.SQLServerJpaConfig;

public class BaseDAOImpl {

	@PersistenceContext(unitName = SQLServerJpaConfig.PU)
	protected EntityManager entityManager;

}
