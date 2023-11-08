package com.valtech.training.hibernate;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Id;
public class OrderSummaryId implements Serializable{
	
private int orderId;
	
private int itemId;
	
	
	
	public OrderSummaryId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderSummaryId(int orderId, int itemId) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
	}
 
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
 
	@Override
	public int hashCode() {
		return Objects.hash(itemId, orderId);
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderSummaryId other = (OrderSummaryId) obj;
		return itemId == other.itemId && orderId == other.orderId;
	}
	
}