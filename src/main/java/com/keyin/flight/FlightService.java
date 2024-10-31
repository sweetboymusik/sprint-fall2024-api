package com.keyin.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public Iterable<Flight> getAllFlights() { return flightRepository.findAll(); }

    public Flight addFlight(Flight flight) { return flightRepository.save(flight); }
}
