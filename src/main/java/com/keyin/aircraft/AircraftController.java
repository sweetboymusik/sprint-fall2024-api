package com.keyin.aircraft;

import com.fasterxml.jackson.annotation.JsonView;
import com.keyin.airline.Airline;
import com.keyin.airline.AirlineRepository;
import com.keyin.airline.AirlineService;
import com.keyin.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AircraftController {
    @Autowired
    private AircraftService aircraftService;

    @Autowired
    private AirlineService airlineService;
    @Autowired
    private AirlineRepository airlineRepository;

    @GetMapping("/aircraft/all")
    @JsonView(Views.AircraftView.class)
    public Iterable<Aircraft> getAllAircraft() {
        return aircraftService.getAllAircraft();
    }

    @GetMapping("/aircraft/id/{id}")
    @JsonView(Views.AircraftView.class)
    public Aircraft getAircraftById(@PathVariable int id) {
        return aircraftService.getAircraftById(id);
    }

    @PostMapping("/aircraft")
    @JsonView(Views.AircraftView.class)
    public Aircraft addAircraft(@RequestBody AircraftDTO aircraftDTO) {
        Airline airline = airlineService.getAirlineById(aircraftDTO.getAirlineId());
        Aircraft aircraft = new Aircraft(aircraftDTO, airline);

        return aircraftService.addAircraft(aircraft);
    }

    @PostMapping("/aircraft/id/{id}")
    @JsonView(Views.AircraftView.class)
    public Aircraft updateAircraftById(@PathVariable int id, @RequestBody AircraftDTO aircraftDTO) {
        return aircraftService.updateAircraftById(id, aircraftDTO);
    }

    @DeleteMapping("/aircraft/id/{id}")
    @JsonView(Views.AircraftView.class)
    public void deleteAircraftById(@PathVariable int id) {
        aircraftService.deleteAircraftById(id);
    }
}
