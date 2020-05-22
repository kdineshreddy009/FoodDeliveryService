package com.example.swiggy.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@IdClass(ItemPrimaryKey.class)
@Table(name = "OrderedItems")
public class Item {
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OrderId")
	private CustomerOrder customerOrder;
	
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dishId")
	private Dish dish;
	
	@Column(name = "Quantity")
	private Integer quantity;

	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
