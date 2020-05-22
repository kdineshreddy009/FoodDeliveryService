package com.example.swiggy.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
//https://examples.javacodegeeks.com/enterprise-java/hibernate/hibernate-jpa-dao-example/
//https://www.youtube.com/watch?v=lpcOSXWPXTk&list=PLqq-6Pq4lTTbx8p2oCgcAQGQyqN8XeA1x&index=29

/**
 * Base interface for CRUD operations and common queries
 */
public interface DaoBase<T> extends Serializable {

	public List<T> findAll();

    public T persist(T entity);

	public T update(T domain);

	public void delete(Long id);

	public T get(Long id);

	/**
	 * Get list by criteria
	 * 
	 * @param detachedCriteria the domain query criteria, include condition and the
	 *                         orders.
	 * @return
	 *
	 */
	public List<T> getListByCriteria(DetachedCriteria detachedCriteria);

	public List<T> getListByCriteria(DetachedCriteria detachedCriteria, int offset, int size);

}