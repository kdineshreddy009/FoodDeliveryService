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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(updatable = false, nullable = false) // name = "CategoryId",
	private Long categoryId;

	private String categoryName;

	@ManyToMany
	private List<Restaurant> restaurants;

	@ManyToMany
	private List<Dish> dishes;

	public Category() {
	}

	public Category(Long categoryId, String name, List<Restaurant> restaurants, List<Dish> dishes) {
		super();
		this.categoryId = categoryId;
		this.categoryName = name;
		this.restaurants = restaurants;
		this.dishes = dishes;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory_name() {
		return categoryName;
	}

	public void setName(String categoryname) {
		this.categoryName = categoryname;
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
}
