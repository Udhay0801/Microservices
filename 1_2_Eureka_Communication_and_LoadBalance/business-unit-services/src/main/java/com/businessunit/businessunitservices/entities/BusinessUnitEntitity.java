package com.businessunit.businessunitservices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BUSINESS_UNIT")
public class BusinessUnitEntitity {

	@Id
	@Column(name = "bu_id")
	private Integer buId;
	
	@Column(name = "bu_name")
	private String buName;
	
	@Column(name = "bu_head")
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
	
	
}
