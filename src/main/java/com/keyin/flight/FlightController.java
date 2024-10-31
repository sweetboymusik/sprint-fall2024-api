package com.keyin.flight;


import com.fasterxml.jackson.annotation.JsonView;
import com.keyin.aircraft.Aircraft;
import com.keyin.aircraft.AircraftRepository;
import com.keyin.airport.Airport;
import com.keyin.airport.AirportRepository;
import com.keyin.city.City;
import com.keyin.passenger.Passenger;
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

    @GetMapping("/getAllFlights")
    @JsonView(Views.FlightView.class)
    public Iterable<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @PostMapping("/flight")
    @JsonView(Views.FlightView.class)
    public Flight addFlight(@RequestBody FlightDTO flightDTO) {
        Airport origin = airportRepository.findById(flightDTO.getOriginAirportId())
                .orElseThrow(() -> new RuntimeException("Origin airport not found"));

        Airport destination = airportRepository.findById(flightDTO.getDestinationAirportId())
                .orElseThrow(() -> new RuntimeException("Destination airport not found"));

        Aircraft aircraft = aircraftRepository.findById(flightDTO.getAircraftId())
                .orElseThrow(() -> new RuntimeException("Aircraft not found"));

        Flight flight = new Flight(flightDTO, origin, destination, aircraft);

        return flightService.addFlight(flight);

    }
}
