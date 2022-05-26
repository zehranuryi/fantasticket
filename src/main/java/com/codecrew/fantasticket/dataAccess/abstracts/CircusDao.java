package com.codecrew.fantasticket.dataAccess.abstracts;

import com.codecrew.fantasticket.entities.eventTypes.Circus;
import com.codecrew.fantasticket.entities.eventTypes.Concert;
import com.codecrew.fantasticket.entities.eventTypes.Movie;
import com.codecrew.fantasticket.enums.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CircusDao extends JpaRepository<Circus, Integer> {

    Circus getByCircusName(String circusName);

    List<Circus> getByDate(LocalDate date);
    List<Circus> getByCity(City city);
}

