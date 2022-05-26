package com.codecrew.fantasticket.business.concretes;

import com.codecrew.fantasticket.business.abstracts.ConcertService;
import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.core.utilities.results.SuccessDataResult;
import com.codecrew.fantasticket.core.utilities.results.SuccessResult;
import com.codecrew.fantasticket.dataAccess.abstracts.ConcertDao;
import com.codecrew.fantasticket.entities.eventTypes.Concert;
import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.MusicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ConcertManager implements ConcertService {

    private ConcertDao concertDao;

    @Autowired
    public ConcertManager(ConcertDao concertDao) {
        super();
        this.concertDao = concertDao;
    }

    @Override
    public Result add(Concert concert) {
        this.concertDao.save(concert);
        return new SuccessResult("Concert added.");
    }

    @Override
    public DataResult<List<Concert>> getAll() {
        return new SuccessDataResult<List<Concert>>
                (this.concertDao.findAll(),"Concerts listed.");
    }

    @Override
    public DataResult<Concert> getByConcertName(String concertName) {
        return new SuccessDataResult<Concert>
                (this.concertDao.getByConcertName(concertName),"Concert listed.");
    }

    @Override
    public DataResult<List<Concert>> getByMusicType(MusicType musicType) {
        return new SuccessDataResult<List<Concert>>
                (this.concertDao.getByMusicType(musicType),"Concerts listed.");
    }

    @Override
    public DataResult<List<Concert>> getByArtistName(String artistName) {
        return new SuccessDataResult<List<Concert>>
                (this.concertDao.getByArtistName(artistName),"Concerts listed.");
    }

    @Override
    public DataResult<List<Concert>> getByDate(LocalDate date) {
        return new SuccessDataResult<List<Concert>>
                (this.concertDao.getByDate(date),"Concerts listed.");
    }

    @Override
    public DataResult<List<Concert>> getByCity(City city) {
        return new SuccessDataResult<List<Concert>>
                (this.concertDao.getByCity(city),"Concerts listed.");
    }
}
