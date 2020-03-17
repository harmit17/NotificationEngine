package com.finablr.platform.notification.exceptionhandler.model;

public class DataNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String exception) {
		super(exception);
	}
}
