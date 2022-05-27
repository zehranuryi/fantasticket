package com.codecrew.fantasticket.api.controllers;


import com.codecrew.fantasticket.business.abstracts.CircusService;
import com.codecrew.fantasticket.business.abstracts.DanceService;
import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.entities.eventTypes.Circus;
import com.codecrew.fantasticket.entities.eventTypes.Dance;
import com.codecrew.fantasticket.enums.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/danceShows")
public class DanceShowsController {

    private DanceService danceService;

    @Autowired
    public DanceShowsController(DanceService danceService) {
        super();
        this.danceService = danceService;
    }

    @GetMapping("/getall")
    public DataResult<List<Dance>> getAll(){
        return this.danceService.getAll();
    }

    @GetMapping("/getByDanceShowName")
    public DataResult<Dance> getByDanceShowName(@RequestParam String danceShowName){
        return this.danceService.getByDanceShowName(danceShowName);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Dance dance) {
        return this.danceService.add(dance);
    }

    @GetMapping("/getByCity")
    public DataResult<List<Dance>> getByCity(@RequestParam City city) {
        return this.danceService.getByCity(city);
    }

    @GetMapping("/getByDate")
    public DataResult<List<Dance>> getByDate(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return this.danceService.getByDate(date);
    }
}
