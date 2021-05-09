package com.mycode.springboot.cruddemo.service;

import java.util.List;

import com.mycode.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployee();
	
	public Employee findEmployeeById(int empId);
	
	public void save(Employee employee);
	
	public void delete(int empId);
}
