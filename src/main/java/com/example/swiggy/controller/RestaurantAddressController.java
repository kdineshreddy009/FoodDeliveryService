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

import com.example.swiggy.entities.RestaurantAddress;
import com.example.swiggy.service.RestaurantAddressServiceImpl;

@RestController
public class RestaurantAddressController {
	@Autowired
	private RestaurantAddressServiceImpl restaurantAddressService;

	@GetMapping("/restaurantAddress/{id}")
	public RestaurantAddress getRestaurantbyId(@PathVariable Long id) {
		return restaurantAddressService.getRestaurantAddress(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/restaurantAddress")
	public void addRestaurant(@RequestBody RestaurantAddress restaurantAddress) {
		restaurantAddressService.createRestaurantAddress(restaurantAddress);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/restaurantAddress")
	public void updateRestaurant(@RequestBody RestaurantAddress restaurantAddress) {
		restaurantAddressService.updateRestaurantAddress(restaurantAddress);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/restaurantAddress/{id}")
	public void deleteRestaurant(@PathVariable Long id) {
		restaurantAddressService.deleteRestaurantAddress(id);
	}

}
