// * https://www.baeldung.com/hibernate-many-to-many * primary key of new table
// is
// both columns * https://en.wikibooks.org/wiki/Java_Persistence/ManyToMany

package com.example.swiggy.entities;

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

@Entity
@Table(name = "Restaurants")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RestaurantId")
	private Long restaurantId;

	@Column(name = "RestaurantName")
	private String restaurantName;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "RestaurantsToCategories", joinColumns = {
			@JoinColumn(name = "RestaurantId") }, inverseJoinColumns = { @JoinColumn(name = "CategoryId") })
	private Set<Category> categories;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "restaurant")
	private Set<Dish> dishes;

	public Restaurant() {
	}

	public Restaurant(Long restaurantId, Set<Category> categories, String restaurantName, Set<Dish> dishes) {
		super();
		this.restaurantId = restaurantId;
		this.categories = categories;
		this.restaurantName = restaurantName;
		this.dishes = dishes;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Set<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(Set<Dish> dishes) {
		this.dishes = dishes;
	}
}