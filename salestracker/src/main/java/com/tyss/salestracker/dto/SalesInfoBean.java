package com.tyss.salestracker.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

//@Data
@Entity
@Table(name = "sales_info")
public class SalesInfoBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private int id;
	
	@Column(nullable = false)
	@Pattern(regexp = "[a-zA-Z]*")
	private String clientName;
	
	@Column(nullable = false)
	private String location;

	@Column(nullable = false)
	private String domain;
	
	@Column(nullable = false)
	private String status;
	
	@Column(nullable = false)
	private String remarks;
	
	@Column
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate reminder;
	
	@ElementCollection
	@CollectionTable(name = "service_proposed")
	@Column(name="service")
	private List<String> service;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "sales_id")
	private List<ContactPersonInfoBean> coPersonInfoBean;
	
	@Column
	private boolean isActive;
	
	@Column
	private boolean isFollowed;
	
	@Column
	private boolean isDealClosed;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDate getReminder() {
		return reminder;
	}

	public void setReminder(LocalDate reminder) {
		this.reminder = reminder;
	}

	public List<String> getService() {
		return service;
	}

	public void setService(List<String> service) {
		this.service = service;
	}

	public List<ContactPersonInfoBean> getCoPersonInfoBean() {
		return coPersonInfoBean;
	}

	public void setCoPersonInfoBean(List<ContactPersonInfoBean> coPersonInfoBean) {
		this.coPersonInfoBean = coPersonInfoBean;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isFollowed() {
		return isFollowed;
	}

	public void setFollowed(boolean isFollowed) {
		this.isFollowed = isFollowed;
	}

	public boolean isDealClosed() {
		return isDealClosed;
	}

	public void setDealClosed(boolean isDealClosed) {
		this.isDealClosed = isDealClosed;
	}	
	
}