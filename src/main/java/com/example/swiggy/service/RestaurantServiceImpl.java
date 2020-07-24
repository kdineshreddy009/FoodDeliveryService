package com.example.swiggy.service;

import java.io.Serializable;
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
	@Autowired
	private RestaurantAddressServiceImpl restaurantAddressService;

	@Override
	public Restaurant getRestaurantWithId(Long id) {
		return restaurantdao.get(id);
	}

	@Override
	public List<Restaurant> getRestaurants() {
		List<Restaurant> listOfRestaurants = restaurantdao.findAll();
		return listOfRestaurants;
	}

	@Override
	public Restaurant createRestaurant(String newRestaurantName, Long restaurantAddressId) {
		Restaurant newRestaurant = new Restaurant();
		newRestaurant.setRestaurantName(newRestaurantName);
		newRestaurant.setRestaurantAddress(restaurantAddressService.getRestaurantAddress(restaurantAddressId));
		return restaurantdao.persist(newRestaurant);
	}

	@Override
	public Restaurant updateRestaurant(Long restaurantId, String restaurantName, Long addressId) {
//		restaurantdao.update(restaurant);
		return null;
	}

	@Override
	public Restaurant deleteRestaurant(Long id) {
		restaurantdao.delete(id);
		return null;
	}

}
