package com.tyss.salestracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.salestracker.dataresponse.FollowUpListResponse;
import com.tyss.salestracker.dataresponse.SalesFollowUpResponse;
import com.tyss.salestracker.dataresponse.SalesListResponse;
import com.tyss.salestracker.dataresponse.SalesResponse;
import com.tyss.salestracker.dto.FollowUpInfoBean;
import com.tyss.salestracker.dto.SalesInfoBean;
import com.tyss.salestracker.service.SalesService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class SalesRestController {

	@Autowired
	private SalesService service;

	@PostMapping(path = "/Register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SalesResponse register(@RequestBody SalesInfoBean salesInfoBean) {

		SalesResponse response = new SalesResponse();

		if (service.registreLead(salesInfoBean)) {

			response.setError(false);
			response.setMessage("OK");

		} else {
			response.setError(true);
			response.setMessage("Not Ok");
		}

		return response;
	}

	@GetMapping(path = "/Sales/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public SalesListResponse getSales(@PathVariable("id") int id) {
		List<SalesInfoBean> bean = service.getSales(id);
		SalesListResponse response = new SalesListResponse();
		if (bean != null) {
			response.setError(false);
			response.setMessage(bean);

		} else {
			response.setError(true);
			response.setMessage(null);

		}
		return response;
	}

	@GetMapping(path = "/Sales", produces = MediaType.APPLICATION_JSON_VALUE)
	public SalesListResponse getCustomer() {
		List<SalesInfoBean> bean = service.getAllSales();
		SalesListResponse response = new SalesListResponse();
		if (bean != null) {
			response.setError(false);
			response.setMessage(bean);

		} else {
			response.setError(true);
			response.setMessage(null);

		}
		return response;
	}

	@PutMapping(path = "/updateSales", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SalesResponse updateCustomer(@RequestBody SalesInfoBean bean) {
		SalesResponse response = new SalesResponse();
		if (service.updateSales(bean)) {

			response.setError(false);
			response.setMessage("OK");

		} else {
			response.setError(true);
			response.setMessage("Not OK");

		}
		return response;
	}

	@DeleteMapping(path = "/deleteSales/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public SalesResponse removeCustomer(@PathVariable("id") int id) {
		SalesResponse response = new SalesResponse();
		if (service.removeSales(id)) {
			response.setError(false);
			response.setMessage("OK");

		} else {
			response.setError(true);
			response.setMessage("Not OK");

		}
		return response;

	}

	@PostMapping(path = "/sales/followup", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SalesFollowUpResponse followup(@RequestBody FollowUpInfoBean bean) {
		SalesFollowUpResponse response = new SalesFollowUpResponse();
		if (service.registerFollowUp(bean)) {
			response.setError(false);
			response.setMessage("OK");
		} else {
			response.setError(true);
			response.setMessage("Not OK");
		}
		return response;
	}

	@GetMapping(path = "/sales/followers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public FollowUpListResponse getFollowList(@PathVariable("id") int id) {
		List<FollowUpInfoBean> bean = service.getAllFollowedList(id);
		FollowUpListResponse response = new FollowUpListResponse();
		if (bean != null) {

			response.setError(false);
			response.setMessage(bean);

		} else {
			response.setError(true);
			response.setMessage(null);

		}
		return response;
	}
	
	
	@DeleteMapping(path = "/sales/removefollow/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public SalesResponse removeFollow(@PathVariable("id") int id) {
		SalesResponse response = new SalesResponse();
		if (service.removeFollow(id)) {
			response.setError(false);
			response.setMessage("OK");

		} else {
			response.setError(true);
			response.setMessage("Not OK");

		}
		return response;

	}
	
	@GetMapping(path = "/sales/followers", produces = MediaType.APPLICATION_JSON_VALUE)
	public SalesListResponse getfollow() {
		List<SalesInfoBean> bean = service.getAllFollow();
		SalesListResponse response = new SalesListResponse();
		if (bean != null) {
			response.setError(false);
			response.setMessage(bean);

		} else {
			response.setError(true);
			response.setMessage(null);

		}
		return response;
	}
	
	@GetMapping(path = "/sales/saleslist", produces = MediaType.APPLICATION_JSON_VALUE)
	public SalesListResponse getAllList() {
		List<SalesInfoBean> bean = service.getAllSalesList();
		SalesListResponse response = new SalesListResponse();
		if (bean != null) {
			response.setError(false);
			response.setMessage(bean);

		} else {
			response.setError(true);
			response.setMessage(null);

		}
		return response;
	}
	
	@DeleteMapping(path = "/sales/closeDeal/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public SalesResponse closeSalesDeal(@PathVariable("id") int id) {
		SalesResponse response = new SalesResponse();
		if (service.closeDeal(id)) {
			response.setError(false);
			response.setMessage("OK");

		} else {
			response.setError(true);
			response.setMessage("Not OK");

		}
		return response;

	}
	

}
