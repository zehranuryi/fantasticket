package com.codecrew.fantasticket.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ImageRequestDto {
	@NotEmpty
	private String imageUrl;
	
	@NotNull
	private Integer eventId;
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public Integer getEventId() {
		return eventId;
	}
	
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
}