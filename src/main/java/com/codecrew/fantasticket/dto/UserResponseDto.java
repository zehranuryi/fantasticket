package com.codecrew.fantasticket.dto;

import com.codecrew.fantasticket.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

public class UserResponseDto {
	public UserResponseDto(String username, String email, String phone, String address, String fullName, Role role) {
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.fullName = fullName;
		this.role = role;
	}
	
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
}