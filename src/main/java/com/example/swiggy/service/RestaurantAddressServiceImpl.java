package com.example.swiggy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.swiggy.dao.DaoBase;
import com.example.swiggy.entities.Restaurant;
import com.example.swiggy.entities.RestaurantAddress;

@Service
public class RestaurantAddressServiceImpl {

	@Autowired
	private DaoBase<RestaurantAddress> restaurantAddressDao;

	public RestaurantAddress createRestaurantAddress(RestaurantAddress address) {
		return restaurantAddressDao.persist(address);
	}

	public RestaurantAddress getRestaurantAddress(Long Id) {
		return restaurantAddressDao.get(Id);
	}

	public RestaurantAddress updateRestaurantAddress(RestaurantAddress entity) {
		return restaurantAddressDao.update(entity);
	}

	public void deleteRestaurantAddress(Long Id) {
		restaurantAddressDao.delete(Id);
	}
}
