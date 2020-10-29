package com.tyss.salestracker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.tyss.salestracker.dto.ContactPersonInfoBean;
import com.tyss.salestracker.dto.FollowUpInfoBean;
import com.tyss.salestracker.dto.SalesInfoBean;
import com.tyss.salestracker.exception.EmailAlreadyExistException;

@Repository
public class SalesDAOImpl implements SalesDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

	private final static Logger log = LogManager.getLogger("SalesTracker");

	@Override
	public boolean registreLead(SalesInfoBean salesInfoBean) {

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		log.debug("Hello");
		log.info("sdfsdf");
		try {
			manager.persist(salesInfoBean);
			transaction.commit();
			log.trace("Data inserted");
			System.err.println("Data inserted");
			return true;
		} catch (Exception e) {

		log.info("data not registerd");
			System.out.println(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				System.out.println(element.toString());
			}
			throw new EmailAlreadyExistException("Email Already exists");
		}
	}

	@Override
	public List<SalesInfoBean> getAllSales() {

		EntityManager manager = factory.createEntityManager();
		String jpql = "from SalesInfoBean c where c.isFollowed=false";
		TypedQuery<SalesInfoBean> query = manager.createQuery(jpql, SalesInfoBean.class);
		return query.getResultList();
	}

	@Override
	public List<SalesInfoBean> getSales(int id) {

		EntityManager manager = factory.createEntityManager();
		String jpql = "from SalesInfoBean c where c.id=:id";
		TypedQuery<SalesInfoBean> query = manager.createQuery(jpql, SalesInfoBean.class);
		query.setParameter("id", id);
		return query.getResultList();

	}

	@Override
	public boolean updateSales(SalesInfoBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();

		SalesInfoBean infoBean = manager.find(SalesInfoBean.class, bean.getId());

		infoBean.setClientName(bean.getClientName());
		infoBean.setLocation(bean.getLocation());
		infoBean.setRemarks(bean.getRemarks());
		infoBean.setReminder(bean.getReminder());
		infoBean.setStatus(bean.getStatus());
		infoBean.setService(bean.getService());
		infoBean.setDomain(bean.getDomain());

//		for (FollowUpInfoBean element : infoBean.getFollowUpInfoBeans()) {
//
//			for (FollowUpInfoBean value : bean.getFollowUpInfoBeans()) {
//				
//				if(value.getF_id() == element.getF_id()) {
//					element.setDate(value.getDate());
//					element.setTime(value.getTime());
//					element.setComments(value.getComments());
//				}
//				
//			}
//			
//		}

		for (ContactPersonInfoBean element : infoBean.getCoPersonInfoBean()) {

			for (ContactPersonInfoBean value : bean.getCoPersonInfoBean()) {

				if (value.getId() == element.getId()) {
					element.setDesignation(value.getDesignation());
					element.setEmail(value.getEmail());
					element.setNumber(value.getNumber());
					element.setPersonName(value.getPersonName());

				}

			}

		}

		try {
			manager.persist(infoBean);
			transaction.commit();
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				System.out.println(element.toString());
			}

			return false;

		}
	}

	@Override
	public boolean removeSales(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			SalesInfoBean bean = manager.find(SalesInfoBean.class, id);
			bean.setActive(true);
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				System.out.println(element.toString());
			}
			return false;

		}

	}

	@Override
	public boolean registerFollowUp(FollowUpInfoBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				System.out.println(element.toString());
			}
		}
		return false;
	}

	@Override
	public List<FollowUpInfoBean> getAllFollowedList(int id) {

		EntityManager manager = factory.createEntityManager();
		String jpql = "from FollowUpInfoBean c where c.sales_id=:id ORDER BY c.date ASC";
		TypedQuery<FollowUpInfoBean> query = manager.createQuery(jpql, FollowUpInfoBean.class);
		query.setParameter("id", id);
		return query.getResultList();

	}

	@Override
	public boolean removeFollow(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			SalesInfoBean bean = manager.find(SalesInfoBean.class, id);
			bean.setFollowed(true);
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				System.out.println(element.toString());
			}
			return false;

		}

	}

	@Override
	public List<SalesInfoBean> getAllFollow() {

		EntityManager manager = factory.createEntityManager();
		String jpql = "from SalesInfoBean c where c.isFollowed=true";
		TypedQuery<SalesInfoBean> query = manager.createQuery(jpql, SalesInfoBean.class);
		return query.getResultList();
	}

	@Override
	public List<SalesInfoBean> getAllSalesList() {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from SalesInfoBean c ORDER BY c.clientName ASC";
		TypedQuery<SalesInfoBean> query = manager.createQuery(jpql, SalesInfoBean.class);
		return query.getResultList();
	}

	@Override
	public boolean closeDeal(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			SalesInfoBean bean = manager.find(SalesInfoBean.class, id);
			bean.setDealClosed(true);
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				System.out.println(element.toString());
			}
			return false;

		}
	}
	
	
	

}
