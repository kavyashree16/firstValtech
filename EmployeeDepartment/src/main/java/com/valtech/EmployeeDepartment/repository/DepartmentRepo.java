package com.valtech.EmployeeDepartment.repository;



import org.springframework.stereotype.Repository;

import com.valtech.EmployeeDepartment.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer>{
	
	@Query(value = "SELECT MIN(id) FROM Department")
    int findMinId();

	@Query(value = "SELECT MAX(id) FROM Department")
	int findMaxId();
	
	@Query(value = "SELECT MIN(id) FROM Department WHERE id > ?1")
	int findNextId(int id);
	
	@Query(value = "SELECT MAX(id) FROM Department WHERE id < ?1")
	int findPreviousId(int id);
}
