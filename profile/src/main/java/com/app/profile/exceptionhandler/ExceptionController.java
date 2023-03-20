package com.app.profile.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value=DataNotFoundException.class)
	public ResponseEntity dataNotFound(DataNotFoundException dataNotFoundException) {
		return new ResponseEntity(dataNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = InvalidDataException.class)
	public ResponseEntity invalidData(InvalidDataException InvalidDataException) {
		return new ResponseEntity(InvalidDataException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity runTimeExceptions(NullPointerException nullpointer) {
		return new ResponseEntity(nullpointer.getMessage(), HttpStatus.NOT_FOUND);
	}
}
