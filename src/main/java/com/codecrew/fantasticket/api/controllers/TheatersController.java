package com.codecrew.fantasticket.api.controllers;

import com.codecrew.fantasticket.business.abstracts.TheaterService;
import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.entities.eventTypes.Theater;
import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.TheaterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/theaters")
public class TheatersController {

    private TheaterService theaterService;

    @Autowired
    public TheatersController(TheaterService theaterService) {
        super();
        this.theaterService = theaterService;
    }

    @GetMapping("/getall")
    public DataResult<List<Theater>> getAll(){
        return this.theaterService.getAll();
    }

    @GetMapping("/getByTheaterName")
    public DataResult<Theater> getByTheaterName(@RequestParam String theaterName){
        return this.theaterService.getByTheaterName(theaterName);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Theater theater) {
        return this.theaterService.add(theater);
    }

    @GetMapping("/getByTheaterType")
    public DataResult<List<Theater>> getByTheaterType(@RequestParam TheaterType theaterType) {
        return this.theaterService.getByTheaterType(theaterType);
    }

    @GetMapping("/getByCity")
    public DataResult<List<Theater>> getByCity(@RequestParam City city) {
        return this.theaterService.getByCity(city);
    }

    @GetMapping("/getByDate")
    public DataResult<List<Theater>> getByDate(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return this.theaterService.getByDate(date);
    }
}
