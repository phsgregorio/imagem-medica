package com.puc.hibernate.dao;


import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.puc.commons.exceptions.DAOException;

public interface DAO {

	public void create(Object object) throws DAOException;

	@SuppressWarnings("rawtypes")
	public Object retrieve(Class clazz, Serializable id) throws DAOException;

	public void update(Object object) throws DAOException;

	public void delete(Object object) throws DAOException;
	
	public void saveOrUpdate(Object object) throws DAOException;

	@SuppressWarnings("rawtypes")
	public List list(Class clazz, String orderBy) throws DAOException;
	
	@SuppressWarnings("rawtypes")
	public List listWithPagination(Class clazz, String orderBy, Integer firstResult, Integer maxResults, Boolean asc) throws DAOException;
	
	@SuppressWarnings("rawtypes")
	public Long count(Class clazz) throws DAOException;
	
	public void setSession(Session session);
}