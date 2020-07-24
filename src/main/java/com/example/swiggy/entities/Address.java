package com.example.swiggy.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//https://www.objectdb.com/api/java/jpa/MappedSuperclass
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@MappedSuperclass
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(updatable = false, nullable = false)
	private Long addressId;

	private String addressLine1;

	private String addressLine2;

	private String state;

	private String city;

	private Long pincode;

	private String latitude;

	private String longitude;
	
	public Address() {
	}

	public Address(Long address_id, String addressLine1, String addressLine2, String state, String city, Long pincode,
			String latitude, String longitude) {
		super();
		this.addressId = address_id;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getAddress_id() {
		return addressId;
	}

	public void setAddress_id(Long address_id) {
		this.addressId = address_id;
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
}
