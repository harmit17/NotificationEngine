package com.finablr.platform.notification.exceptionhandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.finablr.platform.notification.exceptionhandler.model.NotificationRequestIdNotFoundException;

@ControllerAdvice
public class ExceptionHadler extends ResponseEntityExceptionHandler {
	private String NOT_FOUND = "Notification Request Id Not Found";

	@ExceptionHandler(NotificationRequestIdNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleUserNotFoundException(NotificationRequestIdNotFoundException ex,
			WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(NOT_FOUND, details);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
