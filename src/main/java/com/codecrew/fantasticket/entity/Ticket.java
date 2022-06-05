package com.codecrew.fantasticket.entity;

import com.codecrew.fantasticket.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
@AllArgsConstructor
@NoArgsConstructor
public class Ticket extends BaseEntity {
	@Column(name = "seat_number", nullable = false)
	private Integer seatNumber;
	
	@Column(name = "is_cancelled", nullable = false)
	private Boolean isCancelled;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "event_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Event event;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	public Integer getSeatNumber() {
		return seatNumber;
	}
	
	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	public Event getEvent() {
		return event;
	}
	
	public void setEvent(Event event) {
		this.event = event;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Boolean getCancelled() {
		return isCancelled;
	}
	
	public void setCancelled(Boolean cancelled) {
		isCancelled = cancelled;
	}
}