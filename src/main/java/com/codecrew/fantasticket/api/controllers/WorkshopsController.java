package com.codecrew.fantasticket.api.controllers;

import com.codecrew.fantasticket.business.abstracts.WorkshopService;
import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.entities.eventTypes.Workshop;
import com.codecrew.fantasticket.enums.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/workshops")
public class WorkshopsController {

    private WorkshopService workshopService;

    @Autowired
    public WorkshopsController(WorkshopService workshopService) {
        super();
        this.workshopService = workshopService;
    }

    @GetMapping("/getall")
    public DataResult<List<Workshop>> getAll(){
        return this.workshopService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Workshop workshop) {
        return this.workshopService.add(workshop);
    }

    @GetMapping("/getByWorkshopName")
    public DataResult<Workshop> getByWorkshopName(@RequestParam String workshopName) {
        return this.workshopService.getByWorkshopName(workshopName);
    }

    @GetMapping("/getByCity")
    public DataResult<List<Workshop>> getByCity(@RequestParam City city) {
        return this.workshopService.getByCity(city);
    }

    @GetMapping("/getByDate")
    public DataResult<List<Workshop>> getByDate(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return this.workshopService.getByDate(date);
    }
}
