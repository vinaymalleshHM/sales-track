package com.tyss.salestracker.exception;

@SuppressWarnings("serial")
public class InvalidIdException extends RuntimeException {
	public  InvalidIdException(String msg) {
		super(msg);
	}

}
