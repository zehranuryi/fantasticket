package com.codecrew.fantasticket.dto;

import com.codecrew.fantasticket.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationDto {
	@JsonProperty(value = "title")
	private String title;
	
	@JsonProperty(value = "message")
	private String message;
	
	@JsonProperty(value = "date")
	private LocalDateTime date;
	
	@JsonProperty(value = "userId")
	private Integer userId;
}