package com.landisgyr.employeemangementsystem.exception;


public class InvalidIdException extends RuntimeException {

	public InvalidIdException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "InvalidIdException [toString()=" + super.getMessage() + "]";
	}

	
	
}
