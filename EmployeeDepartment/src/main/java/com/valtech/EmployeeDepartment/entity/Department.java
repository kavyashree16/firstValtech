package com.valtech.EmployeeDepartment.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class Department {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String dname;
	private String dlocation;
	@OneToMany(targetEntity = Employee.class, fetch = FetchType.LAZY,mappedBy = "department")
	private List<Employee> employees;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	public String getDlocation() {
		return dlocation;
	}
	public void setDlocation(String dlocation) {
		this.dlocation = dlocation;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public Department() {
	}
	
	public Department(int id, String dname, String dlocation) {
		this.id = id;
		this.dname = dname;
		this.dlocation = dlocation;
	}
	
	public Department(String dname, String dlocation) {
		this.dname = dname;
		this.dlocation = dlocation;
	}

}
