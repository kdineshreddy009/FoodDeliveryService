package com.example.swiggy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.swiggy.ReadRestaurant;
import com.example.swiggy.entities.Restaurant;
import com.example.swiggy.entities.RestaurantAddress;
import com.example.swiggy.service.RestaurantService;

@RestController
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@GetMapping("/restaurants")
	public List<Restaurant> getRestaurants() {
		return restaurantService.getRestaurants();
	}

	// @PostMapping("/restaurants") Or below
	@RequestMapping(method = RequestMethod.POST, value = "/restaurants")
	public void addRestaurant(@Valid @RequestBody Restaurant restaurant) {
		restaurantService.createRestaurant(restaurant);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/restaurants")
	public void updateRestaurant(@RequestBody Restaurant restaurant) {
		restaurantService.updateRestaurant(restaurant);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/restaurants/{id}")
	public void deleteRestaurantbyId(@PathVariable Long id) {
		restaurantService.deleteRestaurant(id);
	}

}
