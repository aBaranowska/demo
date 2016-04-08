package com.rec.exception;

@SuppressWarnings("serial")
public class UserDAOException extends RuntimeException {

	public static final String NULL_QUERY_PARAMETER = "null query parameter";
	public static final String MORE_THAN_ONE_USER_EXIST = "more than one user exist";

	public UserDAOException(final String message) {
		super(message);
	}

}
