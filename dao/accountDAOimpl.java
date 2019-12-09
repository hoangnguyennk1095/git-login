package com.hiber.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hiber.entity.Accounts;

@Transactional
@Repository
public class accountDAOimpl implements accountDAO {
	@Autowired
	SessionFactory facetory;

	@Override
	public Accounts findbyUer(String username) {
		// TODO Auto-generated method stub
		Session session = facetory.getCurrentSession();
		return session.find(Accounts.class, username);
	}

	@Override
	public Accounts creatAccount(Accounts entity) {
		// TODO Auto-generated method stub
		Session session = facetory.getCurrentSession();
		session.save(entity);
		return entity;
	}

	@Override
	public void update(Accounts entity) {
		Session session = facetory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public List<Accounts> findAll() {
		String hql = " FROM Accounts";
		Session session = facetory.getCurrentSession();
		TypedQuery<Accounts> query = session.createQuery(hql, Accounts.class);
		return query.getResultList();

	}

	@Override
	public List<Accounts> findAccountCus() {
		// TODO Auto-generated method stub
		String hql = " FROM Accounts WHERE 	role = 2";
		Session session = facetory.getCurrentSession();
		TypedQuery<Accounts> query = session.createQuery(hql, Accounts.class);
		return query.getResultList();
	}

	@Override
	public Accounts delete(String username) {
		// TODO Auto-generated method stub
		Accounts entity = this.findbyUer(username);
		Session session = facetory.getCurrentSession();
		session.remove(entity);
		return entity;
	}

}
