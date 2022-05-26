package com.codecrew.fantasticket.dataAccess.abstracts;

import com.codecrew.fantasticket.entities.eventTypes.Theater;
import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.TheaterType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TheaterDao extends JpaRepository<Theater, Integer> {

    Theater getByTheaterName(String theaterName);

    List<Theater> getByTheaterType(TheaterType theaterType);
    List<Theater> getByDate(LocalDate date);
    List<Theater> getByCity(City city);
}
