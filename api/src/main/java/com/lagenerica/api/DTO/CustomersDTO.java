package com.lagenerica.api.DTO;

public class CustomersDTO {
	
	private Integer identification;
	private String address;
	private String email;
	private String name;
	private String phone;
	
	public CustomersDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomersDTO(Integer identification, String address, String email, String name, String phone) {
		super();
		this.identification = identification;
		this.address = address;
		this.email = email;
		this.name = name;
		this.phone = phone;
	}
	public Integer getIdentification() {
		return identification;
	}
	public void setIdentification(Integer identification) {
		this.identification = identification;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
