package com.keyin.airline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineService {
    @Autowired
    private AirlineRepository airlineRepository;

    public Iterable<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }

    public Airline addAirline(Airline airline) {
        return airlineRepository.save(airline);
    }
}
