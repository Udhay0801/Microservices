package com.company.companyservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.company.comnpanyservice.model.BusinessUnitEntitity;
import com.company.comnpanyservice.model.EmployeeEntity;
import com.company.comnpanyservice.model.EmployeeVO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class CompanyService {

	@Autowired
	public RestTemplate restTemplate;
	
	public List<EmployeeVO> getConsolidatedEmpDetails(List<EmployeeEntity> empList, List<BusinessUnitEntitity> buList)
	{
		//List<EmployeeEntity> empList = getAllEmployees();
		
		//List<BusinessUnitEntitity> buList = getAllBUDetails();

		return empList.stream().map(e -> {
			EmployeeVO vo = new EmployeeVO();
			vo.setEmpId(e.getEmpId());
			vo.setEmpName(e.getEmpName());
			vo.setEmpDesig(e.getEmpDesig());
			vo.setEmployeeAddress(e.getEmployeeAddress());
			vo.setEmpSal(e.getEmpSal());
			vo.setBuId(e.getBuId());
			
			buList.forEach(bu -> {
				if(bu.getBuId().equals(e.getBuId()))
				{
					vo.setBuName(bu.getBuName());
					vo.setBuHead(bu.getBuHead());
				}
			});
			return vo;
		}).collect(Collectors.toList());
	}

	@HystrixCommand(fallbackMethod = "getFallBackAllBUDetails", 
		commandProperties = 
		{
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "6"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
		})
	public List<BusinessUnitEntitity> getAllBUDetails() {
	    List<BusinessUnitEntitity> buList = restTemplate.exchange("http://bu-service/bulist", HttpMethod.GET,
	    		null, new ParameterizedTypeReference<List<BusinessUnitEntitity>>() {
	    		}, new Object[] {}).getBody();
	    return buList;
	}

	@HystrixCommand(fallbackMethod = "getFallbackAllEmployees", 
		commandProperties = 
		{
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "6"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
		})
	public List<EmployeeEntity> getAllEmployees(boolean isExceptionTrigger) {
	    List<EmployeeEntity> empList = restTemplate.exchange("http://employee-service/employees/getallemp/{isExceptionTrigger}", HttpMethod.GET, null,
	    		new ParameterizedTypeReference<List<EmployeeEntity>>() {
	    		}, isExceptionTrigger).getBody();
	    return empList;
	}
	
	public List<EmployeeEntity> getFallbackAllEmployees(boolean isExceptionTrigger) {
	    List<EmployeeEntity> empList = new ArrayList<EmployeeEntity>();
	    EmployeeEntity e = new EmployeeEntity();
	    e.setBuId(0);
	    e.setEmpId(0);
	    e.setEmpDesig("None");
	    e.setEmployeeAddress("None");
	    e.setEmpName("None");
	    empList.add(e);
	    return empList;
	}
	
	public List<BusinessUnitEntitity> getFallBackAllBUDetails() {
	    List<BusinessUnitEntitity> buList = new ArrayList<BusinessUnitEntitity>();
	    BusinessUnitEntitity bu = new BusinessUnitEntitity();
	    bu.setBuHead("None");
	    bu.setBuId(0);
	    bu.setBuName("None");
	    buList.add(bu);
	    return buList;
	}
}
