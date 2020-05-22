package com.example.swiggy;

import org.hibernate.cfg.Configuration;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import com.example.swiggy.HibernateSessionFactory;

import com.example.EmfProvider;
import com.example.swiggy.entities.Restaurant;

//import com.example.swiggy.Restaurant;

public class ReadRestaurant {

	public static List<Object> readRestaurants() {
		try {
			EntityManagerFactory emf = EmfProvider.getInstance().getEntityManagerFactory();
			EntityManager entitymanager = emf.createEntityManager();
			CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			
			Root<Restaurant> from = criteriaQuery.from(Restaurant.class);
			// select all records
			System.out.println("Select all records");
			
			CriteriaQuery<Object> select = criteriaQuery.select(from);
			
			TypedQuery<Object> typedQuery = entitymanager.createQuery(select);
			
			List<Object> resultlist = typedQuery.getResultList();
			
			entitymanager.close();
			return resultlist;
		} catch (Throwable e) {
			System.err.println("Error in creating SessionFactory object." + e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
	}
}

/*
 * for (Object o : resultlist) {
Restaurant e = (Restaurant) o;
System.out.println("EID : " + e.getRestaurant_id() + " Ename : " + e.getRestaurant_name());
}
 * */
