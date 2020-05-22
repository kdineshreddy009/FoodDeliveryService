package com.example.swiggy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.swiggy.dao.DaoBase;
import com.example.swiggy.dao.RestaurantAddressDaoImpl;
//import com.example.swiggy.dao.RestaurantRepository;
import com.example.swiggy.entities.Restaurant;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private DaoBase<Restaurant> restaurantdao;
//	@Autowired
//	private RestaurantAddressServiceImpl raService;

	@Override
	public List<Restaurant> getRestaurants() {
		List<Restaurant> listOfRestaurants = restaurantdao.findAll();
		return listOfRestaurants;
	}

	@Override
	public Restaurant createRestaurant(Restaurant restaurant) {
		return restaurantdao.persist(restaurant);
	}

	@Override
	public void updateRestaurant(Restaurant entity) {
		restaurantdao.update(entity);
	}

	@Override
	public void deleteRestaurant(Long id) {
		restaurantdao.delete(id);
	}
}
