package com.codecrew.fantasticket.business.concretes;

import com.codecrew.fantasticket.business.abstracts.TheaterService;
import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.core.utilities.results.SuccessDataResult;
import com.codecrew.fantasticket.core.utilities.results.SuccessResult;
import com.codecrew.fantasticket.dataAccess.abstracts.TheaterDao;
import com.codecrew.fantasticket.entities.eventTypes.Theater;
import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.TheaterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TheaterManager implements TheaterService {

    private TheaterDao theaterDao;

    @Autowired
    public TheaterManager(TheaterDao theaterDao) {
        super();
        this.theaterDao = theaterDao;
    }

    @Override
    public Result add(Theater theater) {
            this.theaterDao.save(theater);
            return new SuccessResult("Theater event added.");
    }

    @Override
    public DataResult<Theater> getByTheaterName(String theaterName) {
        return new SuccessDataResult<Theater>
                (this.theaterDao.getByTheaterName(theaterName),"Theater event listed.");
    }

    @Override
    public DataResult<List<Theater>> getAll() {
        return new SuccessDataResult<List<Theater>>
                (this.theaterDao.findAll(),"Theater events listed.");
    }

    @Override
    public DataResult<List<Theater>> getByTheaterType(TheaterType theaterType) {
        return new SuccessDataResult<List<Theater>>
                (this.theaterDao.getByTheaterType(theaterType),"Theater events listed.");
    }

    @Override
    public DataResult<List<Theater>> getByDate(LocalDate date) {
        return new SuccessDataResult<List<Theater>>
                (this.theaterDao.getByDate(date),"Theater events listed.");
    }

    @Override
    public DataResult<List<Theater>> getByCity(City city) {
        return new SuccessDataResult<List<Theater>>
                (this.theaterDao.getByCity(city),"Theater events listed.");
    }
}
