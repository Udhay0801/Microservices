package com.businessunit.businessunitservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.businessunit.businessunitservices.entities.BusinessUnitEntitity;
import com.businessunit.businessunitservices.repo.BusinessUnitRepo;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BusinessUnitController {

	@Autowired
	private BusinessUnitRepo buRepo;
	
	@GetMapping("/bulist")
	public List<BusinessUnitEntitity> getAllEmployees()
	{
		return buRepo.findAll();
	}
}
