package com.rec.demo.dao.exception;

public class ProjectDAOException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public static final String NULL_QUERY_PARAMETER = "null query parameter";

	public static final String MORE_THAN_ONE_PROJECT_EXIST = "more than one project exist";

	public ProjectDAOException(final String message) {
		super(message);
	}

}
