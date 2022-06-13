package com.codecrew.fantasticket.dto;

import com.codecrew.fantasticket.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class NotificationResponseDto {
	@JsonProperty(value = "title")
	@NotEmpty
	private String title;
	
	@JsonProperty(value = "message")
	@NotEmpty
	private String message;
	
	@JsonProperty(value = "date")
	@NotNull
	private LocalDateTime date;
	
	@JsonProperty(value = "userId")
	@NotNull
	private Integer userId;
}