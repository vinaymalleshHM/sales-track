package com.tyss.salestracker.dataresponse;

//@Data
public class SalesResponse {

//	private int statusCode;
//	private String message;
	
	private String description;
	
	private boolean error;
	
	private String message;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
