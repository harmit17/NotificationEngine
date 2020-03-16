package com.finablr.platform.notification.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
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
	public final Response<?> DataNotFoundException(DataNotFoundException ex, WebRequest request) {
		return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, ex.getMessage(), null);
	}

	@ExceptionHandler(BadInputException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public final Response<?> badInputException(BadInputException ex, WebRequest request) {
		return new Response<>(HttpStatus.BAD_REQUEST.value(), null, ex.getMessage(), null);
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public final Response<?> runTimeException(RuntimeException ex, WebRequest request) {
		return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, ex.getMessage(), null);
	}
	
	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	public final Response<?> BusinessException(BusinessException ex, WebRequest request) {
		return new Response<>(HttpStatus.FORBIDDEN.value(), null, ex.getMessage(), null);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public final Response<?> argumentTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {
		return new Response<>(HttpStatus.BAD_REQUEST.value(), null, "Only Numeric Value Allow", null);
	}		
}
