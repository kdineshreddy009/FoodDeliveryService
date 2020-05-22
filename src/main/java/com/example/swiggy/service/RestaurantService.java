package com.example.swiggy.service;

import java.util.List;

import com.example.swiggy.entities.Restaurant;

public interface RestaurantService {

	public List<Restaurant> getRestaurants();

	public Restaurant createRestaurant(Restaurant res);

	public void updateRestaurant(Restaurant restaurant);

	public void deleteRestaurant(Long id);

}
