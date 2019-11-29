package com.employee.employeeportal.service;

import java.util.List;

import com.employee.employeeportal.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployeeDetails();
	
	public Employee registerEmployee(Employee emp);
	
}
