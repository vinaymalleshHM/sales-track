package com.tyss.salestracker.dataresponse;

import java.util.List;

import com.tyss.salestracker.dto.SalesInfoBean;

//@Data
public class SalesListResponse {

	
	private boolean error;
	
	private List<SalesInfoBean> message;

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public List<SalesInfoBean> getMessage() {
		return message;
	}

	public void setMessage(List<SalesInfoBean> message) {
		this.message = message;
	}
	
//	private List<SalesInfoBean> salesInfoBean;
//	private int statusCode;
//	private String message;
//	private String description;	
	
	
}