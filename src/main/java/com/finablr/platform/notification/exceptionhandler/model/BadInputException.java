package com.finablr.platform.notification.exceptionhandler.model;

public class BadInputException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public BadInputException(String Exception) {
		super(Exception);
	}
}
