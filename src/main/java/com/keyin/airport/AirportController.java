package com.keyin.airport;

import com.fasterxml.jackson.annotation.JsonView;
import com.keyin.city.City;
import com.keyin.city.CityRepository;
import com.keyin.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AirportController {
    @Autowired
    private AirportService airportService;

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/getAllAirports")
    @JsonView(Views.AirportView.class)
    public Iterable<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @PostMapping("/airport")
    @JsonView(Views.AirportView.class)
    public Airport addAirport(@RequestBody AirportDTO airportDTO) {
        City city = cityRepository.findById(airportDTO.getCityId())
                .orElseThrow(() -> new RuntimeException("City not found"));

        Airport airport = new Airport(airportDTO.getName(), airportDTO.getCode(), city);

        return airportService.addAirport(airport);
    }

}
