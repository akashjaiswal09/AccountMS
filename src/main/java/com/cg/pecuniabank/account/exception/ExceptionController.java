package com.cg.pecuniabank.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(AccountNotFoundException.class)
	public String handleException(AccountNotFoundException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(AccountExistException.class)
	public String handleException(AccountExistException e) {
		return e.getMessage();
				
	}
	@ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
	public ResponseEntity<ErrorMessage> genericException(Exception e) {
		ErrorMessage error=new ErrorMessage();
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(e.getMessage());
		return new ResponseEntity<>(error,HttpStatus.OK);
	}
	

	
}
