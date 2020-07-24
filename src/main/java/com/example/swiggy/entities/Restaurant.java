// * https://www.baeldung.com/hibernate-many-to-many * primary key of new table
// is
// both columns * https://en.wikibooks.org/wiki/Java_Persistence/ManyToMany

package com.example.swiggy.entities;

import java.util.LinkedList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Restaurants")
public class Restaurant {

	public Restaurant() {
	}

	public Restaurant(Long restaurantId, String restaurantName, RestaurantAddress restaurantAddress) {
		super();
		System.out.println("Restaurant C2");
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantAddress = restaurantAddress;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long restaurantId;

	private String restaurantName;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn 
	private RestaurantAddress restaurantAddress;

	public RestaurantAddress getRestaurantAddress() {
		return restaurantAddress;
	}

	public void setRestaurantAddress(RestaurantAddress restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
}
//@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
//@JoinTable(name = "RestaurantsToCategories", joinColumns = {
//		@JoinColumn(name = "RestaurantId") }, inverseJoinColumns = { @JoinColumn(name = "CategoryId") })
//@ManyToMany(mappedBy = "restaurants")
//private Set<Category> categories;

// (cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy =
// "restaurant")
//@OneToMany
//private Set<Dish> dishes;

//@JoinColumn(name = "restaurantAddress", insertable = false, updatable = false)
//@OneToOne(targetEntity = RestaurantAddress.class, fetch = FetchType.LAZY)
//@NotNull(message = "Car not set")
//@JsonIgnore
//private RestaurantAddress restaurantAddress;

//@Column(name = "restaurantAddress")
//private Long restaurantAddressId;

//@OneToOne(cascade = CascadeType.ALL)
//@JoinColumn(name = "restaurantAddressId")
//private RestaurantAddress restaurantAddress;

//public Long getRestaurantAddressId() {
//	return restaurantAddressId;
//}
//
//public void setRestaurantAddressId(Long restaurantAddressId) {
//	this.restaurantAddressId = restaurantAddressId;
//}

//addressId // @JsonIdentityInfo(generator =
	// ObjectIdGenerators.PropertyGenerator.class, property = "addressId")
	// @JsonIdentityReference(alwaysAsId = true)
	