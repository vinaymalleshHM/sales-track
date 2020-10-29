package com.tyss.salestracker.exception;

@SuppressWarnings("serial")
public class InvalidNumberException extends RuntimeException{
	
	public InvalidNumberException(String msg) {
		super(msg);
	}

}
