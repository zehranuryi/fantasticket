package com.codecrew.fantasticket.business.abstracts;

import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.entities.eventTypes.Dance;
import com.codecrew.fantasticket.enums.City;

import java.time.LocalDate;
import java.util.List;

public interface DanceService {

    Result add(Dance dance);

    DataResult<Dance> getByDanceShowName(String danceShowName);
    DataResult<List<Dance>> getAll();
    DataResult<List<Dance>> getByDate(LocalDate date);
    DataResult<List<Dance>> getByCity(City city);
}
