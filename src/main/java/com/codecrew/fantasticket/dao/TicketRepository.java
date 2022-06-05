package com.codecrew.fantasticket.dao;

import com.codecrew.fantasticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	List<Ticket> findByEventId(Integer eventId);
	List<Ticket> findByUserId(Integer userId);
}