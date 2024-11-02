package com.keyin.airline;

import com.fasterxml.jackson.annotation.JsonView;
import com.keyin.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@JsonView(Views.AirlineView.class)
public class AirlineController {
    @Autowired
    private AirlineService airlineService;

    @GetMapping("/airline/all")
    public Iterable<Airline> getAllAirlines() {
        return airlineService.getAllAirlines();
    }

    @GetMapping("/airline/id/{id}")
    public Airline getAirlineById(@PathVariable int id) {
        return airlineService.getAirlineById(id);
    }

    @GetMapping("/airline/name/{name}")
    public Airline getAirlineByName(@PathVariable String name) {
        return airlineService.getAirlineByName(name);
    }

    @PostMapping("/airline")
    public Airline addAirline(@RequestBody Airline airline) {
        return airlineService.addAirline(airline);
    }

    @PostMapping("/airline/id/{id}")
    public Airline updateAirlineById(@PathVariable int id, @RequestBody Airline airline) {
        return airlineService.updateAirlineById(id, airline);
    }

    @DeleteMapping("/airline/id/{id}")
    public void deleteAirlineById(@PathVariable int id) {
        airlineService.deleteAirlineById(id);
    }
}
