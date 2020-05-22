package com.example.swiggy.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

/*
 * {
	"addressLine1": "Street-1",
	"addressLine2": "Kalyan Nagar",
	"state":"Karnataka",
	"city": "bengaluru",
	"pincode":500021,
	"latitude":"22.21",
	"longitude":"23.41"
}
 */

@MappedSuperclass
public class Address {

	public Address(Long address_id, String addressLine1, String addressLine2, String state, String city, Long pincode,
			String latitude, String longitude) {
		super();
		this.address_id = address_id;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "AddressId", updatable = false, nullable = false)
	private Long address_id;

	@Column(name = "AddressLine1")
	private String addressLine1;

	@Column(name = "AddressLine2")
	private String addressLine2;

	public Long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Long address_id) {
		this.address_id = address_id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Column(name = "State")
	private String state;

	@Column(name = "City")
	private String city;

	@Column(name = "Pincode")
	private Long pincode;

	@Column(name = "Latitude")
	private String latitude;

	@Column(name = "Longitude")
	private String longitude;

	public Address() {
	}

}
