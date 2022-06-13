package com.codecrew.fantasticket.entity;

import com.codecrew.fantasticket.entity.base.BaseEntity;
import com.codecrew.fantasticket.enums.EventSubType;
import com.codecrew.fantasticket.enums.EventType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "event")
@AllArgsConstructor
@NoArgsConstructor
public class Event extends BaseEntity {
	
	@Column(name = "event_name", nullable = false)
	@JsonProperty(value = "eventName")
	@NotEmpty
	private String eventName;
	
	@Column(name = "event_description", nullable = false)
	@JsonProperty(value = "eventDescription")
	@NotEmpty
	private String eventDescription;
	
	@Column(name = "image", nullable = true)
	@JsonProperty(value = "image")
	@NotEmpty
	private String image;
	
	@Column(name = "date", nullable = false)
	@JsonProperty(value = "date")
	@NotNull
	private LocalDateTime date;
	
	@Column(name = "day_of_date", nullable = false)
	@JsonProperty(value = "dayOfDate")
	@NotEmpty
	private String dayOfDate;
	
	@Column(name = "capacity", nullable = false, updatable = true)
	@JsonProperty(value = "capacity")
	@NotNull
	private Integer capacity;
	
	@Column(name = "unit_price", nullable = false, updatable = true)
	@JsonProperty(value = "unitPrice")
	@NotNull
	private Double unitPrice;
	
	@Column(name = "place", nullable = false)
	@JsonProperty(value = "place")
	@NotEmpty
	private String place;
	
	@Column(name = "type", nullable = false)
	@Enumerated(EnumType.STRING)
	@JsonProperty(value = "type")
	@NotNull
	private EventType type;
	
	@Column(name = "sub_type", nullable = false)
	@Enumerated(EnumType.STRING)
	@JsonProperty(value = "subType")
	@NotNull
	private EventSubType subType;
	
	@Column(name = "has_seat_plan", nullable = false)
	@JsonProperty(value = "hasSeatPlan")
	@NotNull
	private Boolean hasSeatPlan;
	
	@Column(name = "is_cancelled", nullable = false)
	@JsonProperty(value = "isCancelled")
	private Boolean cancelled;
	
	@Column(name = "selled_seats", nullable = true)
	@JsonProperty(value = "selledSeats")
	private int[] selledSeats;
	
	public String getEventName() {
		return eventName;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public String getDayOfDate() {
		return dayOfDate;
	}
	
	public void setDayOfDate(String dayOfDate) {
		this.dayOfDate = dayOfDate;
	}
	
	public Integer getCapacity() {
		return capacity;
	}
	
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	
	public Double getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public String getPlace() {
		return place;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	
	public EventType getType() {
		return type;
	}
	
	public void setType(EventType type) {
		this.type = type;
	}
	
	public String getEventDescription() {
		return eventDescription;
	}
	
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public Boolean getHasSeatPlan() {
		return hasSeatPlan;
	}
	
	public void setHasSeatPlan(Boolean hasSeatPlan) {
		this.hasSeatPlan = hasSeatPlan;
	}
	
	public EventSubType getSubType() {
		return subType;
	}
	
	public void setSubType(EventSubType subType) {
		this.subType = subType;
	}
	
	public Boolean getCancelled() {
		return cancelled;
	}
	
	public void setCancelled(Boolean cancelled) {
		this.cancelled = cancelled;
	}
	
	public int[] getSelledSeats() {
		return selledSeats;
	}
	
	public void setSelledSeats(int[] selledSeats) {
		this.selledSeats = selledSeats;
	}
}