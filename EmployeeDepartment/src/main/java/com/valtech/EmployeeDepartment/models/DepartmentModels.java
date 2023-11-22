package com.valtech.EmployeeDepartment.models;

import java.util.List;

import com.valtech.EmployeeDepartment.entity.Department;
import com.valtech.EmployeeDepartment.entity.Employee;

public class DepartmentModels {
	
	private int id;
	private String dname;
	private String dlocation;
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
	
	public DepartmentModels() {
	}
	
	public DepartmentModels(Department dep) {
		this.id = dep.getId();
		this.dname = dep.getDname();
		this.dlocation = dep.getDlocation();
	}
		
	public Department getDepartment() {
		
		return new Department(id,dname,dlocation);
	}
}
