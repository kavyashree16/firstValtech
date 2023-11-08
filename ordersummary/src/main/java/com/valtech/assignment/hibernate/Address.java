package com.valtech.assignment.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	
	@Id
	private int AddressId;
	private String street;
	private String City;
	private String State;
	private String Country;
	private int zipcode;
		
	public Address() {}
	
	public Address(String street, String city, String state, String country, int zipcode) {
		super();
		this.street = street;
		City = city;
		State = state;
		Country = country;
		this.zipcode = zipcode;
	}


	public int getAddressId() {
		return AddressId;
	}
	public void setAddressId(int addressId) {
		AddressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
		
}
