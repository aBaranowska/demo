package com.rec.demo.dao.embedded;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.rec.demo.entity.embedded.UserEntity;
import com.rec.demo.exception.UserDAOException;

@Repository
public class UserDAOImpl extends BaseDAOImpl implements UserDAO {

	public List<UserEntity> getAllUsers() {
		TypedQuery<UserEntity> query = entityManager.createQuery("from UserEntity", UserEntity.class);
		return query.getResultList();
	}

	public UserEntity getUser(final String firstName, final String lastName, final String login)
			throws UserDAOException {
		if (firstName == null || lastName == null || login == null) {
			throw new UserDAOException(UserDAOException.NULL_QUERY_PARAMETER);
		}
		TypedQuery<UserEntity> query = entityManager.createQuery(
				"from UserEntity where firstName = :firstName and lastName = :lastName and login = :login",
				UserEntity.class);
		query.setParameter("firstName", firstName);
		query.setParameter("lastName", lastName);
		query.setParameter("login", login);
		List<UserEntity> list = query.getResultList();
		if (list.size() == 0) {
			return null;
		}
		if (list.size() > 1) {
			throw new UserDAOException(UserDAOException.MORE_THAN_ONE_USER_EXIST);
		}
		return list.get(0);
	}

	public void addUser(final UserEntity user) {
		entityManager.persist(user);
	}

}
