package com.tyss.salestracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
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
import com.tyss.salestracker.dto.ContactPersonInfoBean;
import com.tyss.salestracker.dto.SalesInfoBean;
import com.tyss.salestracker.service.SalesServiceImpl;

class SalesOperationTest {

	@InjectMocks
	SalesServiceImpl serviceImpl;
	
	@Mock
	SalesDAOImpl daoImpl;
	
	
	
	@PersistenceUnit
	private EntityManagerFactory factory; 
	
	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void addNullValuesRegistrationTest() {
		SalesServiceImpl impl = new SalesServiceImpl();
		SalesInfoBean bean = null;
		boolean expected = false;
		when(daoImpl.registreLead(bean)).thenReturn(expected);
		boolean actual =impl.registreLead(bean) ;
		assertEquals(expected,actual );
		
	}
	
	@Test
	void addSales() {
		
		List<Long> number = new ArrayList<Long>();
		number.add(9879879870l);
		number.add(9879879877l);
		
		List<String> service = new ArrayList<String>();
		service.add("hey");
		service.add("hello");
		
		SalesInfoBean bean = new SalesInfoBean();
		
		List<ContactPersonInfoBean> beans= new ArrayList<ContactPersonInfoBean>();
		
		ContactPersonInfoBean bean2 = new ContactPersonInfoBean();

		bean2.setId(2);
		bean2.setPersonName("Ramya");
		bean2.setDesignation("HR");
		bean2.setEmail("ramya@gmail.com");
		bean2.setNumber(number);
		beans.add(bean2);		
		
		bean.setId(5);
		bean.setClientName("venki");
		bean.setDomain("sdfjg");
		bean.setLocation("sdghhsd");
		bean.setRemarks("shdgfsh");
		bean.setService(service);
		bean.setStatus("DONE");
		bean.setReminder(LocalDate.of(2020, Month.APRIL, 15));
		bean.setCoPersonInfoBean(beans);
		
		boolean expected = true;
		when(daoImpl.registreLead(bean)).thenReturn(expected);
		boolean actual = serviceImpl.registreLead(bean);
		assertEquals(expected, actual);
		
	}
	
	@Test
	void deleteSalesTest() {
		
		boolean expected = true;
		when(daoImpl.removeSales(1)).thenReturn(expected);
		boolean actual = serviceImpl.removeSales(1);
		assertEquals(expected, actual);
		
	}
	
	@Test
	void getSalesByIdTest() {
		
		List<SalesInfoBean> expected = new ArrayList<SalesInfoBean>();
		when(daoImpl.getSales(1)).thenReturn(expected);
		List<SalesInfoBean> actual = serviceImpl.getSales(1);
		assertEquals(expected, actual);
		
	}
	
	@Test
	void getAllSalesTest() {
		
		List<SalesInfoBean> expected = new ArrayList<SalesInfoBean>();
		when(daoImpl.getAllSales()).thenReturn(expected);
		List<SalesInfoBean> actual = serviceImpl.getAllSales();
		assertEquals(expected, actual);
		
	}

}