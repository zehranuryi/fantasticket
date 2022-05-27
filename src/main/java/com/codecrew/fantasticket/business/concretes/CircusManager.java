package com.codecrew.fantasticket.business.concretes;

import com.codecrew.fantasticket.business.abstracts.CircusService;
import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.core.utilities.results.SuccessDataResult;
import com.codecrew.fantasticket.core.utilities.results.SuccessResult;
import com.codecrew.fantasticket.dataAccess.abstracts.CircusDao;
import com.codecrew.fantasticket.entities.eventTypes.Circus;
import com.codecrew.fantasticket.enums.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CircusManager implements CircusService {

    private CircusDao circusDao;

    @Autowired
    public CircusManager(CircusDao circusDao) {
        super();
        this.circusDao = circusDao;
    }

    @Override
    public Result add(Circus circus) {
        this.circusDao.save(circus);
        return new SuccessResult("Circus event added.");
    }

    @Override
    public DataResult<Circus> getByCircusName(String circusName) {
        return new SuccessDataResult<Circus>
                (this.circusDao.getByCircusName(circusName),"Circus listed.");    }

    @Override
    public DataResult<List<Circus>> getAll() {
        return new SuccessDataResult<List<Circus>>
                (this.circusDao.findAll(),"Circuses listed.");
    }

    @Override
    public DataResult<List<Circus>> getByDate(LocalDate date) {
        return new SuccessDataResult<List<Circus>>
                (this.circusDao.getByDate(date),"Circuses listed.");
    }

    @Override
    public DataResult<List<Circus>> getByCity(City city) {
        return new SuccessDataResult<List<Circus>>
                (this.circusDao.getByCity(city),"Circuses listed.");
    }
}
