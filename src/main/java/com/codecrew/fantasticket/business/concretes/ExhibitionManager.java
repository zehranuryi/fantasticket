package com.codecrew.fantasticket.business.concretes;

import com.codecrew.fantasticket.business.abstracts.ExhibitionService;
import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.core.utilities.results.SuccessDataResult;
import com.codecrew.fantasticket.core.utilities.results.SuccessResult;
import com.codecrew.fantasticket.dataAccess.abstracts.ExhibitionDao;
import com.codecrew.fantasticket.entities.eventTypes.Exhibition;
import com.codecrew.fantasticket.enums.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExhibitionManager implements ExhibitionService {

    private ExhibitionDao exhibitionDao;

    @Autowired
    public ExhibitionManager(ExhibitionDao exhibitionDao) {
        super();
        this.exhibitionDao = exhibitionDao;
    }

    @Override
    public Result add(Exhibition exhibition) {
        this.exhibitionDao.save(exhibition);
        return new SuccessResult("Exhibition added.");
    }

    @Override
    public DataResult<List<Exhibition>> getAll() {
        return new SuccessDataResult<List<Exhibition>>
                (this.exhibitionDao.findAll(),"Exhibitions listed.");
    }

    @Override
    public DataResult<Exhibition> getByExhibitionName(String exhibitionName) {
        return new SuccessDataResult<Exhibition>
                (this.exhibitionDao.getByExhibitionName(exhibitionName),"Exhibition listed.");
    }


    @Override
    public DataResult<List<Exhibition>> getByDate(LocalDate date) {
        return new SuccessDataResult<List<Exhibition>>
                (this.exhibitionDao.getByDate(date),"Exhibitions listed.");
    }

    @Override
    public DataResult<List<Exhibition>> getByCity(City city) {
        return new SuccessDataResult<List<Exhibition>>
                (this.exhibitionDao.getByCity(city),"Exhibitions listed.");
    }
}
