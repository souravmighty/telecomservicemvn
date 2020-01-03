package com.deloitte.telecom.exceptions;

public class CustomerAccountNotFoundException extends RuntimeException{
	
	public CustomerAccountNotFoundException(String msg) {
		super(msg);
	}

}
