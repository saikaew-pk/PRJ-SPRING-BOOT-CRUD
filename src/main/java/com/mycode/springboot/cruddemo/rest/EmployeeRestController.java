package com.mycode.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycode.springboot.cruddemo.entity.Employee;
import com.mycode.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllemployee(){
		return employeeService.getAllEmployee();	
	}
	
	@GetMapping("/employees/{empId}")
	public Employee getAllemployeeById(@PathVariable int empId){
		Employee employee = employeeService.findEmployeeById(empId);
		if(employee == null) {
			throw new RuntimeException("Employee ID not found : " + empId);
		}
		return employee;	
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.save(employee);
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee){
		employeeService.save(employee);
		return employee;	
	}
	
	@DeleteMapping("/employees/{empId}")
	public String deleteEmployee(@PathVariable int empId){
		Employee employee = employeeService.findEmployeeById(empId);
		if(employee == null) {
			throw new RuntimeException("Employee ID not found : " + empId);
		}
		employeeService.delete(empId);
		return "Delete Employee ID : " + empId;	
	}
	
	@GetMapping("/employees/findByName/{empName}")
	public List<Employee> getAllemployeeByName(@PathVariable String empName){
		return employeeService.findEmployeeByName(empName);	
	}
}
