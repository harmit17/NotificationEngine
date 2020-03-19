package com.finablr.platform.notification.exceptionhandler.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class UniqueKeyException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public UniqueKeyException(String exception) {
		super(exception);
	}

}
