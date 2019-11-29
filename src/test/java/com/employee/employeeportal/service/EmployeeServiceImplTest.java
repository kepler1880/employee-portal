package com.employee.employeeportal.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.text.IsEqualIgnoringCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.employee.employeeportal.entity.Employee;
import com.employee.employeeportal.repository.EmployeeRepository;
import com.employee.employeeportal.utils.Gender;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {
	
	@InjectMocks
	EmployeeServiceImpl service = new EmployeeServiceImpl();

	@Mock
	EmployeeRepository employeeRepo;

	Employee employee = new Employee();
	List<Employee> listEmp = new ArrayList<>();
	@Before
	public void setUp() throws ParseException {
		MockitoAnnotations.initMocks(this);
		employee.setFirstName("Sri");
		employee.setLastName("lalitha");	
		employee.setGender(Gender.FEMALE);
		employee.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("18-11-1980"));
		employee.setDepartment("IT");
		listEmp.add(employee);
	}
	
	@Test
	public void registerEmployeeTest() {
		Mockito.when(employeeRepo.save(employee)).thenReturn(employee);
		assertNotNull(employee);
		assertNotNull(service.registerEmployee(employee));
		assertThat("sri", IsEqualIgnoringCase.equalToIgnoringCase(service.registerEmployee(employee).getFirstName()));
	}

	@Test
	public void getAllEmployeeDetailsTest() {
		Mockito.when(employeeRepo.findAll()).thenReturn(listEmp);
		assertNotNull(listEmp);
		assertEquals(listEmp,service.getAllEmployeeDetails());
	}
}
