package com.keyin.airline;

import com.fasterxml.jackson.annotation.JsonView;
import com.keyin.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AirlineController {
    @Autowired
    private AirlineService airlineService;

    @GetMapping("/getAllAirlines")
    @JsonView(Views.AirlineView.class)
    public Iterable<Airline> getAllAirlines() {
        return airlineService.getAllAirlines();
    }

    @PostMapping("/airline")
    @JsonView(Views.AirlineView.class)
    public Airline addAirline(@RequestBody Airline airline) {
        return airlineService.addAirline(airline);
    }
}
