package com.employee.employeeportal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employeeportal.entity.Employee;
import com.employee.employeeportal.exceptions.EmployeeException;
import com.employee.employeeportal.service.EmployeeService;
import com.employee.employeeportal.utils.ErrorConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "EmployeeController")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/v1/employees")
	@ApiOperation(value = "Get list of All Employees")
	public ResponseEntity<?> getAllEmployeeDetails() throws Exception {
		List<Employee> employeeList = employeeService.getAllEmployeeDetails();
		if (!employeeList.isEmpty()) {
			return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
		}
		//TODO: added to check exception case
		throw new EmployeeException(ErrorConstants.EMPL_FETCH_FAIL.getErrorCode(),
				ErrorConstants.EMPL_FETCH_FAIL.getErrorMsg());

	}

	@PostMapping("/v1/employees")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Register an employee")
	public ResponseEntity<?> registerEmployee(@Valid @RequestBody Employee employee) throws Exception {
		Employee emp = employeeService.registerEmployee(employee);
		if (Optional.ofNullable(emp).isPresent()) {
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		}
		throw new EmployeeException(ErrorConstants.EMPL_REG_FAIL.getErrorCode(),
				ErrorConstants.EMPL_REG_FAIL.getErrorMsg());
	}
}
