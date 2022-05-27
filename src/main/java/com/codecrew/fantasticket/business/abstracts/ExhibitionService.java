package com.codecrew.fantasticket.business.abstracts;

import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.entities.eventTypes.Concert;
import com.codecrew.fantasticket.entities.eventTypes.Exhibition;
import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.MusicType;

import java.time.LocalDate;
import java.util.List;

public interface ExhibitionService {

    Result add(Exhibition exhibition);

    DataResult<List<Exhibition>> getAll();

    DataResult<Exhibition> getByExhibitionName(String exhibitionName);

    DataResult<List<Exhibition>> getByDate(LocalDate date);
    DataResult<List<Exhibition>> getByCity(City city);
}
