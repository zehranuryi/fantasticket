package com.codecrew.fantasticket.dto;

import com.codecrew.fantasticket.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
public class UserResponseDto {
	public UserResponseDto() {
	}
	
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

	@JsonProperty(value = "role")
	private Role role;
	
	@JsonProperty(value = "token")
	private String token;
	
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
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
}