package com.lagenerica.api.DTO;

public class ProvidersDTO {
	
	private Integer nit;
	private String name;
	private String address;
	private String phone;
	
	public ProvidersDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProvidersDTO(Integer nit, String name, String address, String phone) {
		super();
		this.nit = nit;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	public Integer getNit() {
		return nit;
	}
	public void setNit(Integer nit) {
		this.nit = nit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
