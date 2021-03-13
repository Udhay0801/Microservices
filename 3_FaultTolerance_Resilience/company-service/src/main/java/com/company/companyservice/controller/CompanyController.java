package com.company.companyservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.company.comnpanyservice.model.BusinessUnitEntitity;
import com.company.comnpanyservice.model.EmployeeEntity;
import com.company.comnpanyservice.model.EmployeeVO;
import com.company.companyservice.service.CompanyService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CompanyController {
	
	@Autowired
	public CompanyService service;
	
	@GetMapping(value = "/company/allEmpDetails/{isExceptionTrigger}", produces = "application/json")
	public List<EmployeeVO> getCompanyEmpDetails(@PathVariable("isExceptionTrigger") boolean isExceptionTrigger)
	{
	    List<EmployeeEntity> empList = service.getAllEmployees(isExceptionTrigger);
	    List<BusinessUnitEntitity> buList = service.getAllBUDetails();
		return service.getConsolidatedEmpDetails(empList, buList);
	}
	
	@GetMapping("/company/empDetail{empId}")
	public EmployeeVO getCompanyEmpDetailByEmpId(@PathVariable("empId") Integer empId)
	{
		return new EmployeeVO();
	}
}
