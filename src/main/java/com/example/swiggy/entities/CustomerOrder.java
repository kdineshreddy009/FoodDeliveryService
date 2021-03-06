package com.example.swiggy.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//@MappedSuperclass
@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CustomerOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(updatable = false, nullable = false) // name = "OrderId",
	private Long orderId;

	private OrderStatus orderStatus;

	private double price;

	@OneToMany(mappedBy = "customerOrder")
	private List<Item> items;

	@ManyToOne //	@JoinColumn(name = "customerId")
	private Customer customer;

	@ManyToOne //@JoinColumn(name = "restaurantId")
	private Restaurant restaurant;

	@OneToOne
//	@JoinColumn(name = "deliveryAddressId")
	private CustomerAddress customerAddress;

	public Long getOrder_id() {
		return orderId;
	}

	public void setOrder_id(Long order_id) {
		this.orderId = order_id;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public CustomerAddress getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}

}
