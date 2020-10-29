package com.tyss.salestracker.dto;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Data
@Entity
@Table(name = "contact_person_info")
public class ContactPersonInfoBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private int id;
	
	@Column
	private String personName;
	
	@Column
	private String designation;
	
	@Column(unique = true, length = 120)
	private String email;
	
	@ElementCollection
	@CollectionTable(name = "Contact_number")
	@Column(name="number", length = 10)
	private List<Long> number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Long> getNumber() {
		return number;
	}

	public void setNumber(List<Long> number) {
		this.number = number;
	}

}
