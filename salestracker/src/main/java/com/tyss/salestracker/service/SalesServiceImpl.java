package com.tyss.salestracker.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.salestracker.dao.SalesDAO;
import com.tyss.salestracker.dto.FollowUpInfoBean;
import com.tyss.salestracker.dto.SalesInfoBean;
import com.tyss.salestracker.exception.InvalidIdException;
import com.tyss.salestracker.utility.SalesDataValidation;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	private SalesDAO dao;
	
	final Pattern validEmail = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");

	final Pattern validName = Pattern.compile("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");

	final Pattern validId = Pattern.compile("^[0-9]*$");
	
	String email ;
	String designation;
	List<Long> number;
	String personName;
	
	@Override
	public boolean registreLead(SalesInfoBean salesInfoBean) {
		
		SalesDataValidation validation = new SalesDataValidation();
		
		if (salesInfoBean == null || (!validation.registration(salesInfoBean) || !validation.designation(salesInfoBean)
				|| !validation.emailValidation(salesInfoBean) || !validation.personName(salesInfoBean) )) {
			
			return false;
		}else {
			return dao.registreLead(salesInfoBean);
		}
		
	}

	@Override
	public List<SalesInfoBean> getAllSales() {

		return dao.getAllSales();

	}

	@Override
	public List<SalesInfoBean> getSales(int id) {

		return dao.getSales(id);

	}

	@Override
	public boolean updateSales(SalesInfoBean salesInfoBean) {

		return dao.updateSales(salesInfoBean);
	}

	@Override
	public boolean removeSales(int id) {

		Matcher idMatcher = validId.matcher(String.valueOf(id));

		if (id > -1 && idMatcher.find()) {

			if (String.valueOf(id).length() < 3) {

				return dao.removeSales(id);
			} else {

				throw new InvalidIdException("max length is 3");
			}
		} else {
			throw new InvalidIdException("Invalid Id");
		}

	}

	@Override
	public boolean registerFollowUp(FollowUpInfoBean bean) {
		
		return dao.registerFollowUp(bean);
	}

	@Override
	public List<FollowUpInfoBean> getAllFollowedList(int id) {
		
		return dao.getAllFollowedList(id);
	}

	@Override
	public boolean removeFollow(int id) {
		
		return dao.removeFollow(id);
	}

	@Override
	public List<SalesInfoBean> getAllFollow() {
		
		return dao.getAllFollow();
	}

	@Override
	public List<SalesInfoBean> getAllSalesList() {
		
		return dao.getAllSalesList();
	}

	@Override
	public boolean closeDeal(int id) {
		return dao.closeDeal(id);
	}
	
	
	
	
	
}
