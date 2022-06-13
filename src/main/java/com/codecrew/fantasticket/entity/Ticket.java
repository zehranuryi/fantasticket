package com.codecrew.fantasticket.entity;

import com.codecrew.fantasticket.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ticket")
@AllArgsConstructor
@NoArgsConstructor
public class Ticket extends BaseEntity {
	@Column(name = "seat_numbers", nullable = true)
	private String[] seatNumbers;
	
	@Column(name = "cancelled", nullable = true)
	private Boolean cancelled;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "event_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Event event;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	@Column(name = "ticket_count", nullable = false)
	private Integer ticketCount;

	@Column(name = "total_amount", nullable = false)
	private Double totalAmount;
	
	public String[] getSeatNumbers() {
		return seatNumbers;
	}
	
	public void setSeatNumbers(String[] seatNumbers) {
		this.seatNumbers = seatNumbers;
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
		return cancelled;
	}
	
	public void setCancelled(Boolean cancelled) {
		this.cancelled = cancelled;
	}


	public Integer getTicketCount() {
		return this.ticketCount;
	}

	public void setTicketCount(Integer ticketCount) {
		this.ticketCount = ticketCount;
	}

	public Double getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

}