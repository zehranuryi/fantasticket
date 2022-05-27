package com.codecrew.fantasticket.api.controllers;


import com.codecrew.fantasticket.business.abstracts.CircusService;
import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.entities.eventTypes.Circus;
import com.codecrew.fantasticket.enums.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/circuses")
public class CircusesController {

    private CircusService circusService;

    @Autowired
    public CircusesController(CircusService circusService) {
        super();
        this.circusService = circusService;
    }

    @GetMapping("/getall")
    public DataResult<List<Circus>> getAll(){
        return this.circusService.getAll();
    }

    @GetMapping("/getByCircusName")
    public DataResult<Circus> getByCircusName(@RequestParam String circusName){
        return this.circusService.getByCircusName(circusName);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Circus circus) {
        return this.circusService.add(circus);
    }

    @GetMapping("/getByCity")
    public DataResult<List<Circus>> getByCity(@RequestParam City city) {
        return this.circusService.getByCity(city);
    }

    @GetMapping("/getByDate")
    public DataResult<List<Circus>> getByDate(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return this.circusService.getByDate(date);
    }
}
