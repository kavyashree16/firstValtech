package com.valtech.training.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.valtech.training.hibernate.Employee;


@Repository    //all dao classes will be defined using the repository
// @service for all classes that are service class... they will need Tx Support
// @Controller for all classes when we want them to be used for presentation logic
// @component they are general classes which  have to be registered with beanfactory
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void deleteEmployee(Employee emp) {
		Session ses = sessionFactory.getCurrentSession();
		ses.delete(emp);
	}
	
	@Override
	public Employee saveEmployee(Employee emp) {
		Session ses = sessionFactory.getCurrentSession();
		ses.persist(emp);
		return emp;
	}
	
	@Override
	public Employee loadEmployee(int empId) {
		Session ses = sessionFactory.getCurrentSession();
		Employee emp = (Employee)ses.load(Employee.class, empId);
		ses.close();
		return emp;
		
	}
	
	@Override
	public Employee updateEmployee(Employee emp) {
		Session ses = sessionFactory.openSession();
		emp = (Employee)ses.merge(emp);
		ses.close();
		return emp;
	}
	
	
	@Override
	public List<Employee> getAllEmployee(){
		Session ses = sessionFactory.openSession();
		List<Employee> emps = ses.createQuery("from Employee e").list();
		ses.close();
		return emps;
		
	}
	
	public void setSessionfactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	


}
