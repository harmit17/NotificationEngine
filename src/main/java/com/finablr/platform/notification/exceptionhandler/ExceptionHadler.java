package com.finablr.platform.notification.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.finablr.platform.notification.exceptionhandler.model.BadInputException;
import com.finablr.platform.notification.exceptionhandler.model.BusinessException;
import com.finablr.platform.notification.exceptionhandler.model.DataNotFoundException;
import com.finablr.platform.notification.util.Response;

@ControllerAdvice
public class ExceptionHadler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DataNotFoundException.class)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public final Response<?> handleUserNotFoundException(DataNotFoundException ex, WebRequest request) {
		return new Response<>(HttpStatus.OK.value(), null, ex.getMessage(), null);
	}

	@ExceptionHandler(BadInputException.class)
	public final Response<?> handleUserNotFoundException(BadInputException ex, WebRequest request) {
		return new Response<>(HttpStatus.OK.value(), null, ex.getMessage(), null);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public final Response<?> handleUserNotFoundException(RuntimeException ex, WebRequest request) {
		return new Response<>(HttpStatus.OK.value(), null, ex.getMessage(), null);
	}
	
	@ExceptionHandler(BusinessException.class)
	public final Response<?> handleUserNotFoundException(BusinessException ex, WebRequest request) {
		return new Response<>(HttpStatus.OK.value(), null, ex.getMessage(), null);
	}

}
