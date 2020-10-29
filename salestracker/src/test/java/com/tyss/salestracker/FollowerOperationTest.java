package com.tyss.salestracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tyss.salestracker.dao.SalesDAOImpl;
import com.tyss.salestracker.dto.FollowUpInfoBean;
import com.tyss.salestracker.dto.SalesInfoBean;
import com.tyss.salestracker.service.SalesServiceImpl;

class FollowerOperationTest {

		
	@InjectMocks
	SalesServiceImpl impl;
	
	@Mock
	SalesDAOImpl dao;
	
	@PersistenceUnit
	private EntityManagerFactory factory; 
	
	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void addNullValuesFolloweTest() {
		FollowUpInfoBean bean = null;
		boolean expected = false;
		when(dao.registerFollowUp(bean)).thenReturn(expected);
		boolean actual =impl.registerFollowUp(bean) ;
		assertEquals(expected,actual);
	}
	
	@Test
	void addDataFollowUpTest() {
		FollowUpInfoBean bean = new FollowUpInfoBean();
		bean.setF_id(1);
		bean.setName("rajesg");
		bean.setSales_id(1);
		bean.setTime(LocalTime.of(12, 32));
		bean.setDate(LocalDate.of(2012, Month.JUNE, 12));
		bean.setComments("hgfhgfh");
		
		Boolean expected = true;
		when(dao.registerFollowUp(bean)).thenReturn(expected);
		boolean actual = impl.registerFollowUp(bean);
		assertEquals(expected, actual);
		
	}
	
	@Test
	void getDataTest() {
		
		List<SalesInfoBean> expected = new ArrayList<SalesInfoBean>();
		when(dao.getAllFollow()).thenReturn(expected);
		List<SalesInfoBean> actual = impl.getAllFollow();
		assertEquals(expected, actual);
	}
	
	@Test
	void getDataById() {
		
		List<FollowUpInfoBean> expected = new ArrayList<FollowUpInfoBean>();
		when(dao.getAllFollowedList(1)).thenReturn(expected);
		List<FollowUpInfoBean> actual = impl.getAllFollowedList(1);
		assertEquals(expected, actual);
	}
	
	@Test
	void deleteFollowTest() {
		
		boolean expected = true;
		when(dao.removeFollow(1)).thenReturn(expected);
		boolean actual = impl.removeFollow(1);
		assertEquals(expected, actual);
		
	}
	
	@Test
	void getAllSalesListTest() {
		
		List<SalesInfoBean> expected = new ArrayList<SalesInfoBean>();
		when(dao.getAllSalesList()).thenReturn(expected);
		List<SalesInfoBean> actual = impl.getAllSalesList();
		assertEquals(expected, actual);
		
	}
	
	
}
