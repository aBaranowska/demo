package com.rec.demo.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.rec.demo.entity.UserEntity;

@Repository
public class UserDAOImpl extends BaseDAOImpl implements UserDAO {

	public List<UserEntity> getAllUsers() {
		TypedQuery<UserEntity> query = entityManager.createQuery("from UserEntity", UserEntity.class);
		return query.getResultList();
	}

}
