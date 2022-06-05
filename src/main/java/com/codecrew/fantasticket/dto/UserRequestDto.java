package com.codecrew.fantasticket.dto;

import com.codecrew.fantasticket.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

public class UserRequestDto {
	
	@JsonProperty(value = "username")
	@NotEmpty
	private String username;
	
	@JsonProperty(value = "email")
	@NotEmpty
	private String email;
	
	@JsonProperty(value = "phone")
	@NotEmpty
	private String phone;
	
	@JsonProperty(value = "address")
	@NotEmpty
	private String address;
	
	@JsonProperty(value = "fullName")
	@NotEmpty
	private String fullName;
	
	@JsonProperty(value = "password")
	@NotEmpty
	private String password;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}