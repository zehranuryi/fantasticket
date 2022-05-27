package com.codecrew.fantasticket.business.concretes;

import com.codecrew.fantasticket.business.abstracts.DanceService;
import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.core.utilities.results.SuccessDataResult;
import com.codecrew.fantasticket.core.utilities.results.SuccessResult;
import com.codecrew.fantasticket.dataAccess.abstracts.DanceDao;
import com.codecrew.fantasticket.entities.eventTypes.Dance;
import com.codecrew.fantasticket.enums.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DanceManager implements DanceService {

    private DanceDao danceDao;

    @Autowired
    public DanceManager(DanceDao danceDao) {
        super();
        this.danceDao = danceDao;
    }

    @Override
    public Result add(Dance dance) {
        this.danceDao.save(dance);
        return new SuccessResult("Dance show added.");
    }

    @Override
    public DataResult<Dance> getByDanceShowName(String danceShowName) {
        return new SuccessDataResult<Dance>
                (this.danceDao.getByDanceShowName(danceShowName),"Dance show listed.");    }

    @Override
    public DataResult<List<Dance>> getAll() {
        return new SuccessDataResult<List<Dance>>
                (this.danceDao.findAll(),"Dance shows listed.");
    }

    @Override
    public DataResult<List<Dance>> getByDate(LocalDate date) {
        return new SuccessDataResult<List<Dance>>
                (this.danceDao.getByDate(date),"Dance shows listed.");
    }

    @Override
    public DataResult<List<Dance>> getByCity(City city) {
        return new SuccessDataResult<List<Dance>>
                (this.danceDao.getByCity(city),"Dance shows listed.");
    }
}
