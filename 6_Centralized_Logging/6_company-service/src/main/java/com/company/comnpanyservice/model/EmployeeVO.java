package com.company.comnpanyservice.model;

public class EmployeeVO {

	private Integer empId;
	
	private String empName;
	
	private String empDesig;
	
	private String employeeAddress;
	
	private Double empSal;
	
	private Integer buId;
	
	private String buName;
	
	private String buHead;
	
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
	public Integer getBuId() {
		return buId;
	}
	public void setBuId(Integer buId) {
		this.buId = buId;
	}
	public String getBuName() {
		return buName;
	}
	public void setBuName(String buName) {
		this.buName = buName;
	}
	public String getBuHead() {
		return buHead;
	}
	public void setBuHead(String buHead) {
		this.buHead = buHead;
	}
	@Override
	public String toString() {
		return "EmployeeVO [empId=" + empId + ", empName=" + empName + ", empDesig=" + empDesig + ", employeeAddress="
				+ employeeAddress + ", empSal=" + empSal + ", buId=" + buId + ", buName=" + buName + ", buHead="
				+ buHead + "]";
	}
	
}
