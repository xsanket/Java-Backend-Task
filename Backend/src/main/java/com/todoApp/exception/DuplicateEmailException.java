package com.todoApp.exception;

public class DuplicateEmailException extends RuntimeException {
	
	
	public DuplicateEmailException(String message) {
		super(message);
	}
}
