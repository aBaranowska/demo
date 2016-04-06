package com.rec.demo.dao;

import java.util.List;

import com.rec.demo.dao.exception.UserDAOException;
import com.rec.demo.entity.UserEntity;

public interface UserDAO {

	List<UserEntity> getAllUsers();

	UserEntity getUser(final String firstName, final String lastName, final String login) throws UserDAOException;

	void addUser(final UserEntity user);

}
