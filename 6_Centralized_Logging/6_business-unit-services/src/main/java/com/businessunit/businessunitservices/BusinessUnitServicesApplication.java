package com.businessunit.businessunitservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ="com.businessunit.businessunitservices.*")
public class BusinessUnitServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessUnitServicesApplication.class, args);	
	}
}
