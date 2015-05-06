package com.puc.hibernate.dao;


import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.puc.commons.exceptions.DAOException;

public abstract class DAOHibernate implements DAO {
	
	protected Transaction transaction;
	protected Session session;
	
	@Override
	public void create(Object object) throws DAOException {
		try {
			
			this.transaction = this.session.beginTransaction();
			this.session.save(object);
			transaction.commit();
			
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object retrieve(Class clazz, Serializable id) throws DAOException {
		try {
			
			this.transaction = this.session.beginTransaction();
			Object object = this.session.get(clazz, id);
			transaction.commit();
			
			return object;
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void update(Object object) throws DAOException {
		
		try {
			this.transaction = this.session.beginTransaction();
			this.session.merge(object);
			this.transaction.commit();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void delete(Object object) throws DAOException {
		try {
			this.transaction = this.session.beginTransaction();
			this.session.delete(object);
			this.transaction.commit();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void saveOrUpdate(Object object) throws DAOException {
		try {
			this.transaction = this.session.beginTransaction();
			this.session.saveOrUpdate(object);
			this.transaction.commit();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List list(Class clazz, String orderBy) throws DAOException {
		try {
			
			this.transaction = this.session.beginTransaction();
			
			Criteria c = this.session.createCriteria(clazz);
			c.addOrder(Order.asc(orderBy));
			List list = c.list();
			
			this.transaction.commit();

			return list;
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List listWithPagination(Class clazz, String orderBy, Integer firstResult, Integer maxResults, Boolean asc) throws DAOException {
		
		try {
			this.transaction = this.session.beginTransaction();
			
			Criteria criteria = this.session.createCriteria(clazz);
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(maxResults);
			
			if (asc) {
				criteria.addOrder(Order.asc(orderBy));
			} else {
				criteria.addOrder(Order.desc(orderBy));
			}

			List list = criteria.list();
			transaction.commit();
			
			return list;
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Long count(Class clazz) throws DAOException {
		
		try {
			
			this.transaction = this.session.beginTransaction();
			Long count = (Long) this.session.createCriteria(clazz).setProjection(Projections.rowCount()).uniqueResult();
			this.transaction.commit();
			
			return count;
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void setSession(Session session) {
		this.session = session;
	}
	
}
