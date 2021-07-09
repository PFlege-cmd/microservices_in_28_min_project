package com.in28minutes.microservices.currencyexchangeservice.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@Validated
@RestController
@ControllerAdvice
public class CustomizedExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleTableNotFoundException(TableNotFoundException ex, WebRequest request) {
		var errorlist = List.of(ex.getClass(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<Object>(errorlist, HttpStatus.NOT_FOUND);
	}
	

}
