package com.employee.employeeportal.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.employee.employeeportal.entity.Employee;
import com.employee.employeeportal.service.EmployeeService;
import com.employee.employeeportal.utils.Gender;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

	@InjectMocks
	EmployeeController controller = new EmployeeController();

	@Mock
	EmployeeService employeeService;

	Employee employee = new Employee();
	List<Employee> listEmp = new ArrayList<>();

	@Before
	public void setUp() throws ParseException {
		MockitoAnnotations.initMocks(this);
		employee.setFirstName("Sri");
		employee.setLastName("Lalitha");
		employee.setGender(Gender.FEMALE);
		employee.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("18-11-1980"));
		employee.setDepartment("IT");

		Employee employee1 = new Employee("Jit", "Rana", Gender.MALE,
				new SimpleDateFormat("yyyy-MM-dd").parse("11-11-1990"), "IT");

		listEmp.add(employee);
		listEmp.add(employee1);
	}

	@Test
	public void registerEmployeeTest() throws Exception {
		Mockito.when(employeeService.registerEmployee(employee)).thenReturn(employee);
		assertNotNull(employee);
		Employee emp = (Employee) controller.registerEmployee(employee).getBody();
		assertEquals(employee.getFirstName(), emp.getFirstName());
	}

	@Test(expected = Exception.class)
	public void registerEmployeeNullTest() throws Exception {
		assertNotNull(employee);
		assertNull(controller.registerEmployee(null));
	}

	@Test
	public void getAllEmployeeDetailsTest() throws Exception {
		Mockito.when(employeeService.getAllEmployeeDetails()).thenReturn(listEmp);
		assertNotNull(listEmp);
		assertEquals(listEmp, (List<Employee>) controller.getAllEmployeeDetails().getBody());
	}

}
