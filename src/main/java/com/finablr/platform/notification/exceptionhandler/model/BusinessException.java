package com.finablr.platform.notification.exceptionhandler.model;

public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public BusinessException(String Exception) {
		super(Exception);
	}
}
