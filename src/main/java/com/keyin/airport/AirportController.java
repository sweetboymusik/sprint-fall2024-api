package com.keyin.airport;

import com.fasterxml.jackson.annotation.JsonView;
import com.keyin.city.City;
import com.keyin.city.CityService;
import com.keyin.exceptions.EntityNotFoundException;
import com.keyin.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AirportController {
    @Autowired
    private AirportService airportService;

    @Autowired
    private CityService cityService;

    @GetMapping("/airport/all")
    @JsonView(Views.AirportView.class)
    public Iterable<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/airport/id/{id}")
    @JsonView(Views.AirportView.class)
    public Airport getAirportById(@PathVariable int id) {
        return airportService.getAirportById(id);
    }

    @GetMapping("airport/name/{name}")
    @JsonView(Views.AirportView.class)
    public Airport getAirportByName(@PathVariable String name) {
        return airportService.getAirportByName(name);
    }

    @PostMapping("/airport")
    @JsonView(Views.AirportView.class)
    public Airport addAirport(@RequestBody AirportDTO airportDTO) {
        City city = cityService.getCityById(airportDTO.getCityId());

        if (city != null) {
            Airport airport = new Airport(airportDTO, city);
            return airportService.addAirport(airport);
        } else {
            throw new EntityNotFoundException("City id is not valid");
        }
    }

    @PostMapping("/airport/id/{id}")
    @JsonView(Views.AirportView.class)
    public Airport updateAirportById(@PathVariable int id, @RequestBody AirportDTO airportDTO) {
        City city = cityService.getCityById(airportDTO.getCityId());

        if (city != null) {
            Airport airport = new Airport(airportDTO, city);
            return airportService.updateAirportById(id, airport);
        } else {
            throw new EntityNotFoundException("City id is not valid");
        }
    }

    @DeleteMapping("/airport/id/{id}")
    public void deleteAirportById(@PathVariable int id) {
        airportService.deleteAirportById(id);
    }
}
