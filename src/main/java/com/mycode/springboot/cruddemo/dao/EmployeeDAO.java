package com.mycode.springboot.cruddemo.dao;

import java.util.List;

import com.mycode.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getAllEmployee();
	
	public Employee findEmployeeById(int empId);
	
	public void save(Employee employee);
	
	public void delete(int empId);

}
