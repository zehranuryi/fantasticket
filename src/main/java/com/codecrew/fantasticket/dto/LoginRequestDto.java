package com.codecrew.fantasticket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class LoginRequestDto {
	@JsonProperty(value = "identity")
	@NotEmpty
	private String identity;
	
	@JsonProperty(value = "password")
	@NotEmpty
	private String password;
}