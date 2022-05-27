package com.codecrew.fantasticket.api.controllers;

import com.codecrew.fantasticket.business.abstracts.SportService;
import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.entities.eventTypes.Sport;
import com.codecrew.fantasticket.enums.City;
import com.codecrew.fantasticket.enums.MatchCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sport")
public class SportsController {
    private SportService sportService;

    @Autowired
    public SportsController(SportService sportService) {
        super();
        this.sportService = sportService;
    }

    @GetMapping("/getall")
    public DataResult<List<Sport>> getAll(){
        return this.sportService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Sport sport) {
        return this.sportService.add(sport);
    }

    @GetMapping("/getByMatchCategory")
    public DataResult<List<Sport>> getByCity(@RequestParam MatchCategory matchCategory) {
        return this.sportService.getByMatchCategory(matchCategory);
    }
    @GetMapping("/getByCity")
    public DataResult<List<Sport>> getByCity(@RequestParam City city) {
        return this.sportService.getByCity(city);
    }

    @GetMapping("/getByDate")
    public DataResult<List<Sport>> getByDate(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return this.sportService.getByDate(date);
    }
}
