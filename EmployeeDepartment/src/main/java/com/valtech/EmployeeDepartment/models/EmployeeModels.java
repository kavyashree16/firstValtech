package com.valtech.EmployeeDepartment.models;

import com.valtech.EmployeeDepartment.entity.Department;
import com.valtech.EmployeeDepartment.entity.Employee;

public class EmployeeModels {

	private int id;
	private String name;
	private int age;
	private int experience;
	private int seniority;
	private int salary;
	private Department department;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public int getSeniority() {
		return seniority;
	}
	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public EmployeeModels() {
	}
	
	public EmployeeModels(Employee emp) {
		this.id = emp.getId();
		this.name = emp.getName();
		this.age = emp.getAge();
		this.experience = emp.getExperience();
		this.seniority = emp.getSeniority();
		this.salary = emp.getSalary();
		this.department = emp.getDepartment();
	}
		
	public Employee getEmployee() {
		
		return new Employee(id,name,age,experience,seniority,salary,department);
	}
}
