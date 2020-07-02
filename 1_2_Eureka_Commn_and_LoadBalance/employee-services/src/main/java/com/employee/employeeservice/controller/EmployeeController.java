package com.employee.employeeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employeeservices.entity.EmployeeEntity;
import com.employee.employeeservices.repo.EmployeeRepo;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/employees")
	public List<EmployeeEntity> getAllEmployees()
	{
		System.out.println("Request Came in : +" +env.getProperty("server.port")+"++++++++++++++++++++++++++++++++++++++++++++++++");
		return empRepo.findAll();
	}
	
	@GetMapping("/employees/{empId}")
	public EmployeeEntity getEmployeesById(@PathVariable("empId") Integer empId)
	{
		return empRepo.findById(empId).get();
	}
}
