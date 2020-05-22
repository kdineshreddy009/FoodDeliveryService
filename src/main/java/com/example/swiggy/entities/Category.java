package com.example.swiggy.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Categories")
public class Category {
	public Category(Long categoryId, String name, List<Restaurant> restaurants, List<Dish> dishes) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.restaurants = restaurants;
		this.dishes = dishes;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "CategoryId", updatable = false, nullable = false)
	private Long categoryId;

	@Column(name = "Name")
	private String name;
	// https://vladmihalcea.com/hibernate-multiplebagfetchexception/ Eager loading
	// causes this
	@ManyToMany(mappedBy = "categories")
	private List<Restaurant> restaurants;

	@ManyToMany(mappedBy = "categories")
	private List<Dish> dishes;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	public List<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}

	public Category() {
	}
}
