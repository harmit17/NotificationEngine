package com.finablr.platform.notification.exceptionhandler.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotificationRequestIdNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotificationRequestIdNotFoundException(String exception) {
		super(exception);
	}
}
