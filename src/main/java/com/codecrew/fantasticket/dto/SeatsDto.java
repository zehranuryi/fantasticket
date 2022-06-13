package com.codecrew.fantasticket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SeatsDto {
	@JsonProperty(value = "seats")
	private int[] seats;
	
	public int[] getSeats() {
		return seats;
	}
	
	public void setSeats(int[] seats) {
		this.seats = seats;
	}
}