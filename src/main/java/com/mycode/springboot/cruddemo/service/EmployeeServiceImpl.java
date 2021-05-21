package com.mycode.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycode.springboot.cruddemo.dao.EmployeeDAO;
import com.mycode.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO thisEmployeeDAO) {
		employeeDAO = thisEmployeeDAO;
	}
	
	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		return employeeDAO.getAllEmployee();
	}

	@Override
	@Transactional
	public Employee findEmployeeById(int empId) {
		return employeeDAO.findEmployeeById(empId);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public void delete(int empId) {
		employeeDAO.delete(empId);
	}
	
	@Override
	@Transactional
	public List<Employee> findEmployeeByName(String name){
		return employeeDAO.findEmployeeByName(name);
	}

}
