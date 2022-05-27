package com.codecrew.fantasticket.business.concretes;

import com.codecrew.fantasticket.business.abstracts.WorkshopService;
import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.core.utilities.results.SuccessDataResult;
import com.codecrew.fantasticket.core.utilities.results.SuccessResult;
import com.codecrew.fantasticket.dataAccess.abstracts.WorkshopDao;
import com.codecrew.fantasticket.entities.eventTypes.Workshop;
import com.codecrew.fantasticket.enums.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WorkshopManager implements WorkshopService {

    private WorkshopDao workshopDao;

    @Autowired
    public WorkshopManager(WorkshopDao workshopDao) {
        super();
        this.workshopDao = workshopDao;
    }

    @Override
    public Result add(Workshop workshop) {
        this.workshopDao.save(workshop);
        return new SuccessResult("Workshop event added.");
    }

    @Override
    public DataResult<Workshop> getByWorkshopName(String workshopName) {
        return new SuccessDataResult<Workshop>
                (this.workshopDao.getByWorkshopName(workshopName),"Workshop event listed.");
    }

    @Override
    public DataResult<List<Workshop>> getAll() {
        return new SuccessDataResult<List<Workshop>>
                (this.workshopDao.findAll(),"Workshop events listed.");
    }

    @Override
    public DataResult<List<Workshop>> getByDate(LocalDate date) {
        return new SuccessDataResult<List<Workshop>>
                (this.workshopDao.getByDate(date),"Workshop events listed.");
    }

    @Override
    public DataResult<List<Workshop>> getByCity(City city) {
        return new SuccessDataResult<List<Workshop>>
                (this.workshopDao.getByCity(city),"Workshop events listed.");
    }
}
