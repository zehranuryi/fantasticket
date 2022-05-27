package com.codecrew.fantasticket.api.controllers;

import com.codecrew.fantasticket.business.abstracts.ExhibitionService;
import com.codecrew.fantasticket.core.utilities.results.DataResult;
import com.codecrew.fantasticket.core.utilities.results.Result;
import com.codecrew.fantasticket.entities.eventTypes.Exhibition;
import com.codecrew.fantasticket.enums.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/exhibitions")
public class ExhibitionsController {

    private ExhibitionService exhibitionService;

    @Autowired
    public ExhibitionsController(ExhibitionService exhibitionService) {
        super();
        this.exhibitionService = exhibitionService;
    }

    @GetMapping("/getall")
    public DataResult<List<Exhibition>> getAll(){
        return this.exhibitionService.getAll();
    }

    @GetMapping("/getByExhibitionName")
    public DataResult<Exhibition> getByExhibitionName(@RequestParam String exhibitionName){
        return this.exhibitionService.getByExhibitionName(exhibitionName);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Exhibition exhibition) {
        return this.exhibitionService.add(exhibition);
    }

    @GetMapping("/getByCity")
    public DataResult<List<Exhibition>> getByCity(@RequestParam City city) {
        return this.exhibitionService.getByCity(city);
    }

    @GetMapping("/getByDate")
    public DataResult<List<Exhibition>> getByDate(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return this.exhibitionService.getByDate(date);
    }
}
