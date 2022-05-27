package com.codecrew.fantasticket.api.controllers;

import com.codecrew.fantasticket.business.abstracts.StandUpService;
import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.entities.eventTypes.StandUp;
import com.codecrew.fantasticket.enums.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/standUp")
public class StandUpsController {

    private StandUpService standUpService;

    @Autowired
    public StandUpsController(StandUpService standUpService) {
        super();
        this.standUpService = standUpService;
    }

    @GetMapping("/getall")
    public DataResult<List<StandUp>> getAll(){
        return this.standUpService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody StandUp standUp) {
        return this.standUpService.add(standUp);
    }

    @GetMapping("/getByStandUpName")
    public DataResult<StandUp> getByStandUpName(@RequestParam String standUpName) {
        return this.standUpService.getByStandUpName(standUpName);
    }

    @GetMapping("/getByArtistName")
    public DataResult<List<StandUp>> getByArtistName(@RequestParam String artistName) {
        return this.standUpService.getByArtistName(artistName);
    }

    @GetMapping("/getByCity")
    public DataResult<List<StandUp>> getByCity(@RequestParam City city) {
        return this.standUpService.getByCity(city);
    }

    @GetMapping("/getByDate")
    public DataResult<List<StandUp>> getByDate(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return this.standUpService.getByDate(date);
    }
}
