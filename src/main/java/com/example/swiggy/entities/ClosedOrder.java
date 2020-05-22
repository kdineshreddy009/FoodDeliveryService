package com.example.swiggy.entities;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AttributeOverride(name = "OrderId", column = @Column(name = "ClosedOrderId"))
public class ClosedOrder extends CustomerOrder {
	@Id
	@Column(name = "ClosedOrderId")
	private Long order_id;

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
}