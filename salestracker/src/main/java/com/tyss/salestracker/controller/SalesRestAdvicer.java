package com.tyss.salestracker.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tyss.salestracker.dataresponse.SalesResponse;
import com.tyss.salestracker.exception.EmailAlreadyExistException;
import com.tyss.salestracker.exception.InvalidIdException;
import com.tyss.salestracker.exception.InvalidNameFormatException;
import com.tyss.salestracker.exception.InvalidNumberException;

@RestControllerAdvice
public class SalesRestAdvicer {

	@ExceptionHandler(InvalidNameFormatException.class)
	public SalesResponse invalidName(InvalidNameFormatException e) {
		SalesResponse response = new SalesResponse();
		response.setError(true);
		response.setDescription(e.getMessage());
		response.setMessage("InvalidNameFormatException");
		return response;
	}
	
	@ExceptionHandler(InvalidIdException.class)
	public SalesResponse invalidId(InvalidIdException e) {
		SalesResponse response = new SalesResponse();
		response.setError(true);
		response.setDescription(e.getMessage());
		response.setMessage("InvalidIdException");
		return response;
	}
	
	@ExceptionHandler(EmailAlreadyExistException.class)
	public SalesResponse invalidEmail(EmailAlreadyExistException e) {
		SalesResponse response = new SalesResponse();
		response.setDescription(e.getMessage());
		response.setError(true);
		response.setMessage("EmailAlreadyExistException");
		return response;
	}
	
	@ExceptionHandler(InvalidNumberException.class)
	public SalesResponse invalidNumber(InvalidNumberException e) {
		SalesResponse response = new SalesResponse();
		response.setDescription(e.getMessage());
		response.setError(true);
		response.setMessage("InvalidNumberException");
		return response;
	}

	
}
