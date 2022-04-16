package com.company.comnpanyservice.model;

public class BusinessUnitEntitity {

	private Integer buId;
	
	private String buName;
	
	private String buHead;
	
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
		return "BusinessUnitEntitity [buId=" + buId + ", buName=" + buName + ", buHead=" + buHead + "]";
	}
}
