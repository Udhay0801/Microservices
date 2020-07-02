package com.company.companyservice.service;

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

@Service
public class CompanyService {

	@Autowired
	public RestTemplate restTemplate;
	
	public List<EmployeeVO> getConsolidatedEmpDetails()
	{
		List<EmployeeEntity> empList = restTemplate.exchange("http://employee-service/employees", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<EmployeeEntity>>() {
				}, new Object[] {}).getBody();
		
		List<BusinessUnitEntitity> buList = restTemplate.exchange("http://bu-service/bulist", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<BusinessUnitEntitity>>() {
				}, new Object[] {}).getBody();

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
}
