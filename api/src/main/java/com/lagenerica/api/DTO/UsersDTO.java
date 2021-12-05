package com.lagenerica.api.DTO;

public class UsersDTO {
	
	private Integer identification;
	private String email;
	private String username;
	private String password;
	private String user;
	
	public UsersDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsersDTO(Integer identification, String email, String username, String password, String user) {
		super();
		this.identification = identification;
		this.email = email;
		this.username = username;
		this.password = password;
		this.user = user;
	}
	public Integer getIdentification() {
		return identification;
	}
	public void setIdentification(Integer identification) {
		this.identification = identification;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}


}
