package com.codecrew.fantasticket.business.concretes;

import com.codecrew.fantasticket.business.abstracts.StandUpService;
import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.core.utilities.results.SuccessDataResult;
import com.codecrew.fantasticket.core.utilities.results.SuccessResult;
import com.codecrew.fantasticket.dataAccess.abstracts.StandUpDao;
import com.codecrew.fantasticket.entities.eventTypes.StandUp;
import com.codecrew.fantasticket.enums.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StandUpManager implements StandUpService {

    private StandUpDao standUpDao;

    @Autowired
    public StandUpManager(StandUpDao standUpDao) {
        super();
        this.standUpDao = standUpDao;
    }

    @Override
    public Result add(StandUp standUp) {
        this.standUpDao.save(standUp);
        return new SuccessResult("StandUp event added.");
    }

    @Override
    public DataResult<StandUp> getByStandUpName(String standUpName) {
        return new SuccessDataResult<StandUp>
                (this.standUpDao.getByStandUpName(standUpName),"StandUp event listed.");
    }

    @Override
    public DataResult<List<StandUp>> getAll() {
        return new SuccessDataResult<List<StandUp>>
                (this.standUpDao.findAll(),"StandUp events listed.");
    }

    @Override
    public DataResult<List<StandUp>> getByArtistName(String artistName) {
        return new SuccessDataResult<List<StandUp>>
                (this.standUpDao.getByArtistName(artistName),"StandUp events listed.");
    }

    @Override
    public DataResult<List<StandUp>> getByDate(LocalDate date) {
        return new SuccessDataResult<List<StandUp>>
                (this.standUpDao.getByDate(date),"StandUp events listed.");
    }

    @Override
    public DataResult<List<StandUp>> getByCity(City city) {
        return new SuccessDataResult<List<StandUp>>
                (this.standUpDao.getByCity(city), "StandUp events listed.");
    }
}
