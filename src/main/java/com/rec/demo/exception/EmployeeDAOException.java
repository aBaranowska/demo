package com.rec.demo.exception;

@SuppressWarnings("serial")
public class EmployeeDAOException extends RuntimeException {

	public static final String MORE_THAN_ONE_EMPLOYEE_EXIST = "more than one employee exist";

	public EmployeeDAOException(final String message) {
		super(message);
	}

}
