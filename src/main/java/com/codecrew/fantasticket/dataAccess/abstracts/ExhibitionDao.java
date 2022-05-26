package com.codecrew.fantasticket.dataAccess.abstracts;

import com.codecrew.fantasticket.entities.eventTypes.Exhibition;
import com.codecrew.fantasticket.enums.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExhibitionDao extends JpaRepository<Exhibition, Integer> {

    Exhibition getByExhibitionName(String exhibitionName);

    List<Exhibition> getByArtistName(String artistName);
    List<Exhibition> getByDate(LocalDate date);
    List<Exhibition> getByCity(City city);
}
