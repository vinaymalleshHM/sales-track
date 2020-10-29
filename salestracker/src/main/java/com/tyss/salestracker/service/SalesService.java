package com.tyss.salestracker.service;

import java.util.List;

import com.tyss.salestracker.dto.FollowUpInfoBean;
import com.tyss.salestracker.dto.SalesInfoBean;

public interface SalesService {

	boolean registreLead( SalesInfoBean salesInfoBean);
	
	boolean updateSales(SalesInfoBean salesInfoBean);
	
	boolean removeSales(int id);
	
	List<SalesInfoBean> getAllSales();
	
	List<SalesInfoBean> getSales(int id);
	
	boolean registerFollowUp(FollowUpInfoBean bean);
	
	List<FollowUpInfoBean> getAllFollowedList(int id);
	
	boolean removeFollow(int id);
	
	List<SalesInfoBean> getAllFollow();
	
	List<SalesInfoBean> getAllSalesList();
	
	boolean closeDeal(int id);

}
