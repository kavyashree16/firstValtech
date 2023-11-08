package com.valtech.assignment.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private int customer_id;
	private String customer_name;
	private long phonenumber;
	
	
	public Customer() {}
	
	public Customer(String customer_name, long phonenumber) {
		super();
		this.customer_name = customer_name;
		this.phonenumber = phonenumber;
	}
	public Customer(int customer_id, String customer_name, long phonenumber) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.phonenumber = phonenumber;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	

}
