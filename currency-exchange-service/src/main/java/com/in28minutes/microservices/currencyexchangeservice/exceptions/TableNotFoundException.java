package com.in28minutes.microservices.currencyexchangeservice.exceptions;

public class TableNotFoundException extends RuntimeException {
	public TableNotFoundException(String msg){
		super(msg);
	}
}
