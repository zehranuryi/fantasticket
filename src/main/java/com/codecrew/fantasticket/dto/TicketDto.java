package com.codecrew.fantasticket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketDto {
	@JsonProperty(value = "id")
	private Integer id;
	
	@JsonProperty(value = "userId")
	private Integer userId;
	
	@JsonProperty(value = "eventId")
	private Integer eventId;
	
	@JsonProperty(value = "cancelled")
	private Boolean cancelled;
	
	@JsonProperty(value = "seatNumber")
	private Integer seatNumber;
}