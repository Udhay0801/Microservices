package com.businessunit.businessunitservices.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.businessunit.businessunitservices.entities.BusinessUnitEntitity;
import com.businessunit.businessunitservices.repo.BusinessUnitRepo;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BusinessUnitController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BusinessUnitRepo buRepo;
	
	@GetMapping("/bulist")
	public List<BusinessUnitEntitity> getAllBusinessUnits()
	{
		log.info("Inside "+this.getClass().getSimpleName()+" getAllBusinessUnits() method");
		return buRepo.findAll();
	}
}
