package com.employee.employeeportal.exceptions;

public class EmployeeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7419075155021837653L;

	private int errorCode;
	private String message;

	public EmployeeException() {
		super();
	}

	public EmployeeException(int errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
