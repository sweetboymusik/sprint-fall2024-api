package com.keyin.airline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AirlineController {
    @Autowired
    private AirlineService airlineService;

    @GetMapping("/getAllAirlines")
    public Iterable<Airline> getAllAirlines() {
        return airlineService.getAllAirlines();
    }

    @PostMapping("/airline")
    public Airline addAirline(@RequestBody Airline airline) {
        return airlineService.addAirline(airline);
    }
}
