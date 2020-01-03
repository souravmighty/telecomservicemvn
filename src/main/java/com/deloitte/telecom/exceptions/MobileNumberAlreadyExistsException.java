package com.deloitte.telecom.exceptions;

public class MobileNumberAlreadyExistsException extends RuntimeException{
	
	public MobileNumberAlreadyExistsException(String msg) {
		super(msg);
	}

}
