package com.example.swiggy.service;

import java.util.List;

import com.example.swiggy.entities.Restaurant;

public interface RestaurantService {

	public List<Restaurant> getRestaurants();

	public Restaurant createRestaurant(String newRestaurantName,Long restaurantAddressId);

	public Restaurant updateRestaurant(Long restaurantId, String restaurantName, Long addressId);

	public Restaurant deleteRestaurant(Long id);

	public Restaurant getRestaurantWithId(Long id);

}
