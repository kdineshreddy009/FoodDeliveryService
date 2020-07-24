package com.example.swiggy.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "RestaurantAddress")
public class RestaurantAddress extends Address {
	public RestaurantAddress() {
	}

	public RestaurantAddress(Long address_id, String addressLine1, String addressLine2, String state, String city,
			Long pincode, String latitude, String longitude) {
		super(address_id, addressLine1, addressLine2, state, city, pincode, latitude, longitude);
	}
}