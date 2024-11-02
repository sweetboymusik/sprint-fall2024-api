package com.keyin.flight;


import com.fasterxml.jackson.annotation.JsonView;
import com.keyin.aircraft.Aircraft;
import com.keyin.aircraft.AircraftRepository;
import com.keyin.airport.Airport;
import com.keyin.airport.AirportRepository;
import com.keyin.exceptions.EntityNotFoundException;
import com.keyin.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class FlightController {
    @Autowired
    private FlightService flightService;

    @Autowired
    private AircraftRepository aircraftRepository;

    @Autowired
    private AirportRepository airportRepository;

    @GetMapping("/flight/all")
    @JsonView(Views.FlightView.class)
    public Iterable<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/flight/id/{id}")
    @JsonView(Views.FlightView.class)
    public Flight getFlightById(@PathVariable int id) {
        return flightService.getFlightById(id);
    }

    @PostMapping("/flight")
    @JsonView(Views.FlightView.class)
    public Flight addFlight(@RequestBody FlightDTO flightDTO) {
        Airport origin = airportRepository.findById(flightDTO.getOriginAirportId())
                .orElseThrow(() -> new EntityNotFoundException("Origin airport not found"));

        Airport destination = airportRepository.findById(flightDTO.getDestinationAirportId())
                .orElseThrow(() -> new EntityNotFoundException("Destination airport not found"));

        Aircraft aircraft = aircraftRepository.findById(flightDTO.getAircraftId())
                .orElseThrow(() -> new EntityNotFoundException("Aircraft not found"));

        Flight flight = new Flight(flightDTO, origin, destination, aircraft);

        return flightService.addFlight(flight);
    }

    @PostMapping("/flight/id/{flightId}/passengers/add/{passengerId}")
    @JsonView(Views.FlightView.class)
    public String addPassengerById(@PathVariable int flightId, @PathVariable int passengerId) {
        return flightService.addPassengerById(flightId, passengerId);

    }

    @PostMapping("/flight/id/{id}")
    @JsonView(Views.FlightView.class)
    public Flight updateFlightById(@PathVariable int id, @RequestBody FlightDTO flightDTO) {
        return flightService.updateFlightById(id, flightDTO);
    }

    @DeleteMapping("/flight/id/{id}")
    public void deleteFlightById(@PathVariable int id) {
        flightService.deleteFlightById(id);
    }
}
