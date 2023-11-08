package com.valtech.assignment.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {
	
	@Id
	private int orderId;
	private String orderData;
	private int orderCost;
	
	
	public Order(String orderData, int orderCost) {
		super();
		this.orderData = orderData;
		this.orderCost = orderCost;
	}
	public Order(int orderId, String orderData, int orderCost) {
		super();
		this.orderId = orderId;
		this.orderData = orderData;
		this.orderCost = orderCost;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderData() {
		return orderData;
	}
	public void setOrderData(String orderData) {
		this.orderData = orderData;
	}
	public int getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(int orderCost) {
		this.orderCost = orderCost;
	}
	
	

}
