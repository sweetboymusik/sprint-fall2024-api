package com.keyin.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AircraftService {
    @Autowired
    AircraftRepository aircraftRepository;

    public Iterable<Aircraft> getAllAircraft() {
        return aircraftRepository.findAll();
    }

    public Aircraft addAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }
}
