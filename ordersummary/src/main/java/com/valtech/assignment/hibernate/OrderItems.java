package com.valtech.assignment.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderItems {
	
	@Id
	private int orderItemId;
	private int productQuantity;
	
	
	
	public OrderItems(int orderItemId, int productQuantity) {
		super();
		this.orderItemId = orderItemId;
		this.productQuantity = productQuantity;
	}
	public OrderItems() {}
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

}
