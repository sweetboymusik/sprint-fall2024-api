package com.keyin.aircraft;

import com.fasterxml.jackson.annotation.JsonView;
import com.keyin.airline.Airline;
import com.keyin.airline.AirlineRepository;
import com.keyin.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AircraftController {
    @Autowired
    private AircraftService aircraftService;

    @Autowired
    private AirlineRepository airlineRepository;

    @GetMapping("/getAllAircraft")
    @JsonView(Views.AircraftView.class)
    public Iterable<Aircraft> getAllAircraft() {
        return aircraftService.getAllAircraft();
    }

    @PostMapping("/aircraft")
    @JsonView(Views.AircraftView.class)
    public Aircraft addAircraft(@RequestBody AircraftDTO aircraftDTO) {
        Airline airline = airlineRepository.findById(aircraftDTO.getAirlineId())
                .orElseThrow(() -> new RuntimeException("Airline not found"));

        Aircraft aircraft = new Aircraft(aircraftDTO, airline);
        return aircraftService.addAircraft(aircraft);
    }
}