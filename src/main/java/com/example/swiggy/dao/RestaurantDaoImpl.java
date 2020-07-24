package com.example.swiggy.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.EmfProvider;
import com.example.swiggy.entities.Category;
import com.example.swiggy.entities.Restaurant;
import com.example.swiggy.entities.RestaurantAddress;
import com.example.swiggy.service.RestaurantAddressServiceImpl;

@Repository
public class RestaurantDaoImpl implements DaoBase<Restaurant> {

	@Autowired
	private RestaurantAddressServiceImpl restaurantAddressServiceImpl;
	private EntityManagerFactory emf = EmfProvider.getInstance().getEntityManagerFactory();

	@Override
	public Restaurant get(Long id) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		Restaurant restaurant = entityManager.find(Restaurant.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		return restaurant;
	}

	@Override
	public List<Restaurant> findAll() {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		List<Restaurant> restaurants = entityManager.createQuery("Select a From Restaurant a", Restaurant.class)
				.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return restaurants;
	}

	@Override
	public Restaurant persist(Restaurant entity) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		entity = entityManager.merge(entity);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
		return entity;
	}

	@Override
	public Restaurant update(Restaurant entity) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
//		Restaurant updateRestaurant = get(entity.getRestaurantId());
//		if (entity.getCategories() != null)
//			updateRestaurant.setCategories(entity.getCategories());
//		if (entity.getDishes() != null)
//			updateRestaurant.setDishes(entity.getDishes());
//		if (entity.getRestaurantName() != null)
//			updateRestaurant.setRestaurantName(entity.getRestaurantName());
		
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
		return entity;
	}

	@Override
	public void delete(Long id) {
		Restaurant res;
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		if (!entityManager.contains(get(id))) {
			res = entityManager.merge(get(id));
		} else {
			res = get(id);
		}
		entityManager.remove(res);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public List getListByCriteria(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getListByCriteria(DetachedCriteria detachedCriteria, int offset, int size) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Restaurant update(Restaurant domain) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
