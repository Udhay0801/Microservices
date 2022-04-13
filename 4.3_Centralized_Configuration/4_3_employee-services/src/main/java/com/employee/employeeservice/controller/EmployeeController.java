package com.employee.employeeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	 @GetMapping(path = "/employees/getallemp/{isExceptionTrigger}")
	    public List<EmployeeEntity> getAllEmployees(@PathVariable("isExceptionTrigger") boolean isExceptionTrigger)
		    throws Exception {
		if (isExceptionTrigger == true) {
		    throw new Exception();
		}
		return empRepo.findAll();
	    }
	
	@GetMapping("/employees/{empId}")
	public EmployeeEntity getEmployeesById(@PathVariable("empId") Integer empId)
	{
		return empRepo.findById(empId).get();
	}
}
