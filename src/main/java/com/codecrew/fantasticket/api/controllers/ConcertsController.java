package com.codecrew.fantasticket.api.controllers;

import com.codecrew.fantasticket.business.abstracts.ConcertService;
import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.entities.eventTypes.Concert;
import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.MusicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/concerts")
public class ConcertsController {

    private ConcertService concertService;

    @Autowired
        public ConcertsController(ConcertService concertService) {
        super();
        this.concertService = concertService;
    }

    @GetMapping("/getall")
    public DataResult<List<Concert>> getAll(){
        return this.concertService.getAll();
    }

    @GetMapping("/getByConcertName")
    public DataResult<Concert> getByConcertName(@RequestParam String concertName){
        return this.concertService.getByConcertName(concertName);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Concert concert) {
        return this.concertService.add(concert);
    }

    @GetMapping("/getByArtistName")
    public DataResult<List<Concert>> getByArtistName(@RequestParam String artisName) {
        return this.concertService.getByArtistName(artisName);
    }

    @GetMapping("/getByMusicType")
    public DataResult<List<Concert>> getByMusicType(@RequestParam MusicType musicType) {
        return this.concertService.getByMusicType(musicType);
    }

    @GetMapping("/getByCity")
    public DataResult<List<Concert>> getByCity(@RequestParam City city) {
        return this.concertService.getByCity(city);
    }

    @GetMapping("/getByDate")
    public DataResult<List<Concert>> getByDate(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return this.concertService.getByDate(date);
    }
}
