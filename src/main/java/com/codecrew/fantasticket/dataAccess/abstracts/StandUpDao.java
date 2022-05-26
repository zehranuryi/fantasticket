package com.codecrew.fantasticket.dataAccess.abstracts;

import com.codecrew.fantasticket.entities.eventTypes.StandUp;
import com.codecrew.fantasticket.enums.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface StandUpDao extends JpaRepository<StandUp, Integer> {

    StandUp getByStandUpName(String standUpName);

    List<StandUp> getByArtistName(String artistName);
    List<StandUp> getByDate(LocalDate date);
    List<StandUp> getByCity(City city);
}
