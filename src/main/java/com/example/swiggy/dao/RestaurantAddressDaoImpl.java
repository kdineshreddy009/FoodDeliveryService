package com.example.swiggy.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.example.EmfProvider;
import com.example.swiggy.entities.Restaurant;
import com.example.swiggy.entities.RestaurantAddress;

@Repository
public class RestaurantAddressDaoImpl implements DaoBase<RestaurantAddress> {

	private EntityManagerFactory emf = EmfProvider.getInstance().getEntityManagerFactory();

	@Override
	public List<RestaurantAddress> findAll() {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		List<RestaurantAddress> restaurantAddresses = entityManager
				.createQuery("Select a From RestaurantAddress a", RestaurantAddress.class).getResultList();
//		Hibernate.initialize();
		entityManager.getTransaction().commit();
		entityManager.close();
		return restaurantAddresses;
	}

	@Override
	public RestaurantAddress get(Long id) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		RestaurantAddress restaurantAddress = entityManager.find(RestaurantAddress.class, id);
		System.out.println(restaurantAddress);
		entityManager.getTransaction().commit();
		entityManager.close();
		return restaurantAddress;
	}

	@Override
	public RestaurantAddress persist(RestaurantAddress entity) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
//		if (!entityManager.contains(entity.getRestaurant())) {
//			entity.setRestaurant(entityManager.merge(entity.getRestaurant()));
//		}
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
		return entity;
	}

	@Override
	public RestaurantAddress update(RestaurantAddress entity) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		RestaurantAddress updateAddress = this.get(entity.getAddress_id());
		if (entity.getAddress_id() != 0)
			updateAddress.setAddress_id(entity.getAddress_id());
		if (entity.getAddressLine2().length() != 0)
			updateAddress.setAddressLine2(entity.getAddressLine2());
		if (entity.getAddressLine1().length() != 0)
			updateAddress.setAddressLine1(entity.getAddressLine1());
		if (entity.getCity().length() != 0)
			updateAddress.setCity(entity.getCity());
		if (entity.getLatitude().length() != 0)
			updateAddress.setLatitude(entity.getLatitude());
		if (entity.getLongitude().length() != 0)
			updateAddress.setLongitude(entity.getLongitude());
		if (entity.getPincode() != 0)
			updateAddress.setPincode(entity.getPincode());
		if (entity.getState().length() != 0)
			updateAddress.setState(entity.getState());
		entityManager.merge(updateAddress);
		entityManager.getTransaction().commit();
		entityManager.close();
		return entity;
	}

	@Override
	public void delete(Long id) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		RestaurantAddress entity = get(id);
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
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
}