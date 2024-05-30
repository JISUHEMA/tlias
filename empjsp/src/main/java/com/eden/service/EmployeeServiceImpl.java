package com.eden.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eden.dao.EmployeeDao;
import com.eden.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	private EmployeeDao employeesDao ;

	@Override
	public void add(Employee employee) {
		
		employeesDao.add(employee);
	}

	@Override
	public List<Employee> list() {
		
		return employeesDao.list();
	}

	@Override
	public void delete(Integer id) {
		
		employeesDao.delete(id);
	}

	@Override
	public Employee idByEmployee(Integer id) {
		
		return employeesDao.idByEmployee(id);
	}

	@Override
	public void update(Employee employee) {
		employeesDao.update(employee);
		
	}

	@Override
	public List<Employee> searchEmp(String searchName, String dataBegin,String dateEnd) {
		
		return employeesDao.searchEmp(searchName,dataBegin,dateEnd);
	}

	
			
	

	
}
