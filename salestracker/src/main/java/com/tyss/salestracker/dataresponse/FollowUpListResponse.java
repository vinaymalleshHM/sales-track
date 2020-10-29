package com.tyss.salestracker.dataresponse;

import java.util.List;

import com.tyss.salestracker.dto.FollowUpInfoBean;

//@Data
public class FollowUpListResponse {
	
	private boolean error;
	private List<FollowUpInfoBean> message;
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public List<FollowUpInfoBean> getMessage() {
		return message;
	}
	public void setMessage(List<FollowUpInfoBean> message) {
		this.message = message;
	}
	
	

}