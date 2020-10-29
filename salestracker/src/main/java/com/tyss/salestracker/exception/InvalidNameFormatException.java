package com.tyss.salestracker.exception;

@SuppressWarnings("serial")
public class InvalidNameFormatException extends RuntimeException {

	public InvalidNameFormatException(String msg) {
		super(msg);
	}
}
