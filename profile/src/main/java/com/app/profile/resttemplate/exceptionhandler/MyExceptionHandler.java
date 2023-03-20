package com.app.profile.resttemplate.exceptionhandler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyExceptionHandler.class);

	@ExceptionHandler(value = MyRestTemplateException.class)
	ResponseEntity<ErrorResponse> handleMyRestTemplateException(MyRestTemplateException ex,
			HttpServletRequest request) {
		LOGGER.error("An error happened while calling {} Downstream API: {}", ex.getDownStreamApi(), ex.toString());
		return new ResponseEntity<>(new ErrorResponse(ex, request.getRequestURI()), ex.getStatus());
	}
}