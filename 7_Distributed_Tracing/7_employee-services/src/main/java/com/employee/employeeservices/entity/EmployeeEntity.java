package com.employee.employeeservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEES")
public class EmployeeEntity {

	@Id
	@GeneratedValue
	@Column(name = "emp_id")
	private Integer empId;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "emp_desig")
	private String empDesig;
	
	@Column(name = "emp_address")
	private String employeeAddress;
	
	@Column(name = "emp_sal")
	private Double empSal;
	
	@Column(name = "bu_id")
	private Integer buId;
	
	public Integer getBuId() {
		return buId;
	}
	public void setBuId(Integer buId) {
		this.buId = buId;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesig() {
		return empDesig;
	}
	public void setEmpDesig(String empDesig) {
		this.empDesig = empDesig;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public Double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}
	
}
