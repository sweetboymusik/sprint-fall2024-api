package com.keyin.airport;

import com.fasterxml.jackson.annotation.JsonView;
import com.keyin.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@JsonView(Views.AirportView.class)
public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping("/airport/all")
    public Iterable<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/airport/id/{id}")
    public Airport getAirportById(@PathVariable int id) {
        return airportService.getAirportById(id);
    }

    @GetMapping("airport/name/{name}")
    public Airport getAirportByName(@PathVariable String name) {
        return airportService.getAirportByName(name);
    }

    @PostMapping("/airport")
    public Airport addAirport(@RequestBody AirportDTO airportDTO) {
        return airportService.addAirport(airportDTO);
    }

    @PostMapping("/airport/id/{id}")
    public Airport updateAirportById(@PathVariable int id, @RequestBody AirportDTO airportDTO) {
        return airportService.updateAirportById(id, airportDTO);
    }

    @DeleteMapping("/airport/id/{id}")
    public void deleteAirportById(@PathVariable int id) {
        airportService.deleteAirportById(id);
    }
}
