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

@Entity
@Table(name = "Dishes")
public class Dish {
	public Dish(Long id, List<Category> categories, Restaurant restaurant, String name, Double price) {
		super();
		this.id = id;
		this.categories = categories;
		this.restaurant = restaurant;
		this.name = name;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "DishId", updatable = false, nullable = false)
	private Long id;

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

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "DishesToCategories", joinColumns = { @JoinColumn(name = "DishId") }, inverseJoinColumns = {
			@JoinColumn(name = "CategoryId") })
	private List<Category> categories;

	/*
	 * this tells that, this is the owner of relationship:A foreign Key
	 * https://www.edureka.co/community/26873/difference-between-joincolumn-mappedby
	 * -onetomany-association
	 */
	@ManyToOne
	@JoinColumn(name = "RestaurantId")
	private Restaurant restaurant;

	@Column(name = "Name")
	private String name;

	@Column(name = "Price")
	private Double price;

	public Dish() {
	}
}
