package com.hiber.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ReportDAOImpl implements ReportDAO{
	@Autowired
	SessionFactory factory;
	
	@Override
	public List<Object[]> inventoryByCategory() {
		String hql = "SELECT p.category.nameCategory, SUM(p.quantity), SUM(p.quantity * p.price), MAX(p.price), MIN(p.price)" + 
				" FROM product p" + 
				" GROUP BY p.category.nameCategory" + 
				" ORDER BY p.category.nameCategory";
		Session session = factory.getCurrentSession();
		TypedQuery<Object[]> query = session.createQuery(hql, Object[].class);
		List<Object[]> list = query.getResultList();
		return list;
	}

	@Override
	public List<Object[]> revenueByCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> revenueByCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> revenueByQuarter() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
