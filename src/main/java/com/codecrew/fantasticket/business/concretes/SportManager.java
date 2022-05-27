package com.codecrew.fantasticket.business.concretes;

import com.codecrew.fantasticket.business.abstracts.SportService;
import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.core.utilities.results.SuccessDataResult;
import com.codecrew.fantasticket.core.utilities.results.SuccessResult;
import com.codecrew.fantasticket.dataAccess.abstracts.SportDao;
import com.codecrew.fantasticket.entities.eventTypes.Sport;
import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.MatchCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SportManager implements SportService {

    private SportDao sportDao;

    @Autowired
    public SportManager(SportDao sportDao) {
        super();
        this.sportDao = sportDao;
    }

    @Override
    public Result add(Sport sport) {
        this.sportDao.save(sport);
        return new SuccessResult("Sport match added.");
    }

    @Override
    public DataResult<List<Sport>> getAll() {
        return new SuccessDataResult<List<Sport>>
                (this.sportDao.findAll(),"Sport matches listed.");
    }

    @Override
    public DataResult<List<Sport>> getByMatchCategory(MatchCategory matchCategory) {
        return new SuccessDataResult<List<Sport>>
                (this.sportDao.getByMatchCategory(matchCategory),"Sport matches listed.");
    }

    @Override
    public DataResult<List<Sport>> getByDate(LocalDate date) {
        return new SuccessDataResult<List<Sport>>
                (this.sportDao.getByDate(date),"Sport matches listed.");
    }

    @Override
    public DataResult<List<Sport>> getByCity(City city) {
        return new SuccessDataResult<List<Sport>>
                (this.sportDao.getByCity(city), "Sport matches listed.");
    }
}
