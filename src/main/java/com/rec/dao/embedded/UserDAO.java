package com.rec.dao.embedded;

import java.util.List;

import com.rec.entity.embedded.UserEntity;
import com.rec.exception.UserDAOException;

public interface UserDAO {

	List<UserEntity> getAllUsers();

	UserEntity getUser(final String firstName, final String lastName, final String login) throws UserDAOException;

	void addUser(final UserEntity user);

}
