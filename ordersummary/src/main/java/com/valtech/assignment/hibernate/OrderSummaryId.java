package com.valtech.assignment.hibernate;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Id;

public class OrderSummaryId implements Serializable{

	private int OrderId;

	private int itemId;
	public OrderSummaryId(int orderId, int itemId) {
		super();
		OrderId = orderId;
		this.itemId = itemId;
	}
	public OrderSummaryId() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(OrderId, itemId);
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
		return OrderId == other.OrderId && itemId == other.itemId;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

}
