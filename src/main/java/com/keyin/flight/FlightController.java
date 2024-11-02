package com.keyin.flight;

import com.fasterxml.jackson.annotation.JsonView;
import com.keyin.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@JsonView(Views.FlightView.class)
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/flight/all")
    public Iterable<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/flight/id/{id}")
    public Flight getFlightById(@PathVariable int id) {
        return flightService.getFlightById(id);
    }

    @PostMapping("/flight")
    public Flight addFlight(@RequestBody FlightDTO flightDTO) {
        return flightService.addFlight(flightDTO);
    }

    @PostMapping("/flight/id/{flightId}/passengers/add/{passengerId}")
    public String addPassengerById(@PathVariable int flightId, @PathVariable int passengerId) {
        return flightService.addPassengerById(flightId, passengerId);

    }

    @PostMapping("/flight/id/{id}")
    public Flight updateFlightById(@PathVariable int id, @RequestBody FlightDTO flightDTO) {
        return flightService.updateFlightById(id, flightDTO);
    }

    @DeleteMapping("/flight/id/{id}")
    public void deleteFlightById(@PathVariable int id) {
        flightService.deleteFlightById(id);
    }
}
