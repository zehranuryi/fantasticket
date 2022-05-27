package com.codecrew.fantasticket.business.abstracts;

import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.entities.eventTypes.Theater;
import com.codecrew.fantasticket.entities.eventTypes.Workshop;
import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.TheaterType;

import java.time.LocalDate;
import java.util.List;

public interface WorkshopService {

    Result add(Workshop workshop);

    DataResult<Workshop> getByWorkshopName(String workshopName);

    DataResult<List<Workshop>> getAll();
    DataResult<List<Workshop>> getByDate(LocalDate date);
    DataResult<List<Workshop>> getByCity(City city);
}
