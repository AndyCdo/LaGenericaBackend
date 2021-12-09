package com.lagenerica.api.DTO;

import java.util.ArrayList;

public class SalesDTO {
	
	private Integer code;
	private Integer identification;
	private ArrayList<SalesDetailsDTO> details;
	private Integer total;
	private Integer value;
	private String customerName;
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public SalesDTO() {
		super();
	}

	public SalesDTO(Integer code, Integer identification, ArrayList<SalesDetailsDTO> details, Integer total,
			Integer value) {
		super();
		this.code = code;
		this.identification = identification;
		this.details = details;
		this.total = total;
		this.value = value;
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Integer getIdentification() {
		return identification;
	}
	public void setIdentification(Integer identification) {
		this.identification = identification;
	}
	public ArrayList<SalesDetailsDTO> getDetails() {
		return details;
	}
	public void setDetails(ArrayList<SalesDetailsDTO> details) {
		this.details = details;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
}
