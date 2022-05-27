package com.codecrew.fantasticket.business.abstracts;

import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.entities.eventTypes.Sport;
import com.codecrew.fantasticket.entities.eventTypes.StandUp;
import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.MatchCategory;

import java.time.LocalDate;
import java.util.List;

public interface SportService {

    Result add(Sport sport);

    DataResult<List<Sport>> getAll();

    DataResult<List<Sport>> getByMatchCategory(MatchCategory matchCategory);
    DataResult<List<Sport>> getByDate(LocalDate date);
    DataResult<List<Sport>> getByCity(City city);
}
