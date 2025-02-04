package com.eden.dao;

import java.util.List;

import com.eden.entity.Employee;

public interface EmployeeDao {

	 

	void add(Employee employee);

	List<Employee> list();

	void delete(Integer id);

	Employee idByEmployee(Integer id);

	void update(Employee employee);

	List<Employee> searchEmp(String searchName, String dataBegin, String dateEnd);

	

	

	
	 
	
}
