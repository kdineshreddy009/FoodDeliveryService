package com.example.swiggy;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.example.EmfProvider;
import com.example.swiggy.entities.Restaurant;

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
 * for (Object o : resultlist) { Restaurant e = (Restaurant) o;
 * System.out.println("EID : " + e.getRestaurant_id() + " Ename : " +
 * e.getRestaurant_name()); }
 */
