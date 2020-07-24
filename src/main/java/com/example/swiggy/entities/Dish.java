package com.example.swiggy.entities;

import java.util.List;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Dishes")
public class Dish {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "DishId", updatable = false, nullable = false)
	private Long id;

	// (cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
//	@JoinTable(name = "DishesToCategories", joinColumns = { @JoinColumn(name = "DishId") }, inverseJoinColumns = {
//			@JoinColumn(name = "CategoryId") })
//	@JsonIgnore
	@ManyToMany(mappedBy = "dishes")
	private List<Category> categories;

	@ManyToOne
	@JoinColumn(name = "restaurantId")
	private Restaurant restaurant;
	
	private String dishName;

	private Double price;
	
	public Dish() {
	}

	public Dish(Long id, List<Category> categories, String dish_name, Double price, Restaurant restaurant) {
		super();
		this.id = id;
		this.categories = categories;
		this.dishName = dish_name;
		this.price = price;
		this.restaurant = restaurant;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getDish_name() {
		return dishName;
	}

	public void setDish_name(String dish_name) {
		this.dishName = dish_name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
