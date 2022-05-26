package com.codecrew.fantasticket.dataAccess.abstracts;

import com.codecrew.fantasticket.entities.eventTypes.Dance;
import com.codecrew.fantasticket.enums.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DanceDao extends JpaRepository<Dance, Integer> {

    Dance getByDanceShowName(String danceShowName);

    List<Dance> getByDate(LocalDate date);
    List<Dance> getByCity(City city);
}
