package com.keyin.airport;

import com.keyin.city.City;
import com.keyin.city.CityRepository;
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
    public Iterable<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @PostMapping("/airport")
    public Airport addAirport(@RequestBody AirportDTO airportDTO) {
        City city = cityRepository.findById(airportDTO.getCityId())
                .orElseThrow(() -> new RuntimeException("City not found"));

        Airport airport = new Airport(airportDTO.getName(), airportDTO.getCode(), city);

        return airportService.addAirport(airport);
    }

}
