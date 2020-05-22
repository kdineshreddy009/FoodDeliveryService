package com.example.swiggy.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "RESTAURANT_ADDRESSES")
public class RestaurantAddress extends Address {

	public RestaurantAddress(Long address_id, String addressLine1, String addressLine2, String state, String city,
			Long pincode, String latitude, String longitude, Restaurant restaurant) {
		super(address_id, addressLine1, addressLine2, state, city, pincode, latitude, longitude);
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurantId", unique = true)
	private Restaurant restaurant;
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public RestaurantAddress() {
	}
}
