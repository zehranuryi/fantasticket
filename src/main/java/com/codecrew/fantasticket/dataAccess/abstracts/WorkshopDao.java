package com.codecrew.fantasticket.dataAccess.abstracts;

import com.codecrew.fantasticket.entities.eventTypes.Workshop;
import com.codecrew.fantasticket.enums.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface WorkshopDao extends JpaRepository<Workshop, Integer> {

    Workshop getByWorkshopName(String workshopName);

    List<Workshop> getByDate(LocalDate date);
    List<Workshop> getByCity(City city);
}
