package com.valtech.EmployeeDepartment.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.EmployeeDepartment.entity.Department;
import com.valtech.EmployeeDepartment.entity.Employee;
import com.valtech.EmployeeDepartment.repository.DepartmentRepo;
import com.valtech.EmployeeDepartment.repository.EmployeeRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private DepartmentRepo departmentRepo;

	@PostConstruct
	public void populateEmployee() {
		
		Employee emp = new Employee("Kavya ",21,1,1,45000);
		Employee emp1 = new Employee("Shree",20,1,1,45000);
		Employee emp2 = new Employee("priya",22,1,1,45000);
		Employee emp3 = new Employee("Shreya",20,1,1,45000);
		Employee emp4 = new Employee("Ramya",22,1,1,45000);
		
		Department dep = new Department("HR","Bangalore");
		Department dep1 = new Department("Manager","Bangalore");
		Department dep2 = new Department("Sales","Bangalore");
		Department dep3 = new Department("ForntEnd","Bangalore");
		Department dep4 = new Department("BackEnd","Bangalore");
		
		departmentRepo.save(dep);
		departmentRepo.save(dep1);
		departmentRepo.save(dep2);
		departmentRepo.save(dep3);
		departmentRepo.save(dep4);
		
		emp.setDepartment(dep);
		employeeRepo.save(emp);
		
		emp1.setDepartment(dep1);
		employeeRepo.save(emp1);
		
		emp2.setDepartment(dep2);
		employeeRepo.save(emp2);
		
		emp3.setDepartment(dep3);
		employeeRepo.save(emp3);
		
		emp4.setDepartment(dep4);
		employeeRepo.save(emp4);
	
	}
	
	@Override
	public Employee createEmployee(Employee emp) {
		
		System.out.println(employeeRepo.getClass().getName());
		return employeeRepo.save(emp);
	}
	
	@Override
	public Employee updateEmployee(Employee emp) {

		return employeeRepo.save(emp);
	}

	@Override
	public void deleteEmployee(int id) {
		
		employeeRepo.deleteById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepo.findAll();
	}

	@Override
	public Employee getEmployee(int id) {
		
		return employeeRepo.getReferenceById(id);
	}
	
	@Override
	public Department createDepartment(Department dep) {
		
		System.out.println(departmentRepo.getClass().getName());
		return departmentRepo.save(dep);
	}
	
	@Override
	public Department updateDepartment(Department dep) {

		return departmentRepo.save(dep);
	}

	@Override
	public List<Department> getAllDepartments() {

		return departmentRepo.findAll();
	}

	@Override
	public Department getDepartment(int id) {
		
		return departmentRepo.findById(id).orElse(null);
	}
	
	@Override
	public int getFirstId() {
		
		return departmentRepo.findMinId();
	}

	@Override
	public int getLastId() {

		return departmentRepo.findMaxId();
	}

	@Override
	public int getPreviousId(int id) {

		int id1 = departmentRepo.findPreviousId(id);
		return id1 == 0 ? getLastId() : id1;
	}

	@Override
	public int getNextId(int id) {

		int id1 = departmentRepo.findNextId(id);
		return id1 == 0 ? getFirstId() : id1;
	}
	
	@Override
	public List<Employee> getAllEmployeesByDepartmentId(int did) {

		return employeeRepo.findEmployeeByDepartmentId(did);
	}
	
}