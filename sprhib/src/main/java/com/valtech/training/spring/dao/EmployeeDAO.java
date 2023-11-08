package com.valtech.training.spring.dao;

import java.util.List;

import com.valtech.training.hibernate.Employee;

public interface EmployeeDAO {
	
	void deleteEmployee(Employee emp);

	Employee saveEmployee(Employee emp);

	Employee loadEmployee(int empId);

	Employee updateEmployee(Employee emp);

	List<Employee> getAllEmployee();

}