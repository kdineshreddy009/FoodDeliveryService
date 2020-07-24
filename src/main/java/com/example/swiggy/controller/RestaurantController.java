package com.example.swiggy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.swiggy.ReadRestaurant;
import com.example.swiggy.entities.Restaurant;
import com.example.swiggy.entities.RestaurantAddress;
import com.example.swiggy.service.RestaurantService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@CrossOrigin("*")
@RestController
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@RequestMapping(method = RequestMethod.GET, value = "/restaurants/{id}")
	public Restaurant getRestaurantbyId(@PathVariable Long id) {
		if (id != null && id != 0)
			return restaurantService.getRestaurantWithId(id);
		return null;
	}

	@GetMapping("/restaurants")
	public List<Restaurant> getRestaurants() {
		return restaurantService.getRestaurants();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/restaurants")
	public Restaurant addRestaurant(@RequestBody ObjectNode inputJson) {
		String newRestaurantName = null;
		Long mappingAddressId = null;
		if (inputJson.has("restaurantName")) {
			newRestaurantName = inputJson.get("restaurantName").asText();
		}
		if (inputJson.has("restaurantAddressId")) {
			mappingAddressId = inputJson.get("restaurantAddressId").asLong();
		}
		if (newRestaurantName == null || mappingAddressId == null)
			System.out.println("throw custom class Exception");
		return restaurantService.createRestaurant(newRestaurantName, mappingAddressId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/restaurants")
	public Restaurant updateRestaurant(@RequestBody ObjectNode inputJson) {
		Long restaurantAddressId = null;
		String restaurantName = null;
		if (!inputJson.has("restaurantId")) {
			System.out.println("Exception");
		}
		if (inputJson.has("restaurantName")) {
			restaurantName = inputJson.get("restaurantName").asText();
		}
		if (inputJson.has("restaurantAddressId")) {
			restaurantAddressId = inputJson.get("restaurantName").asLong();
		}
		return restaurantService.updateRestaurant(inputJson.get("restaurantId").asLong(), restaurantName,
				restaurantAddressId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/restaurants/{id}")
	public void deleteRestaurantbyId(@PathVariable Long id) {
		restaurantService.deleteRestaurant(id);
	}

}
