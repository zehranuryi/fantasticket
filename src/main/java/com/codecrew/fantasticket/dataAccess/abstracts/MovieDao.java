package com.codecrew.fantasticket.dataAccess.abstracts;

import com.codecrew.fantasticket.entities.eventTypes.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao  extends JpaRepository<Movie, Integer> {
}
