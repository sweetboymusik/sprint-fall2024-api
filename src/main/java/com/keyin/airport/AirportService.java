package com.keyin.airport;

import com.keyin.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;

    public Iterable<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    ;

    public Airport addAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public Airport getAirportById(int id) {
        return airportRepository.findById(id).orElse(null);
    }

    public Airport getAirportByName(String name) {
        return airportRepository.findByName(name);
    }

    public Airport updateAirportById(int id, Airport airport) {
        Airport airportToUpdate = airportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Airport not found"));

        if (airport.getName() != null) airportToUpdate.setName(airport.getName());
        if (airport.getCode() != null) airportToUpdate.setCode(airport.getCode());
        if (airport.getCity() != null) airportToUpdate.setCity(airport.getCity());

        return airportRepository.save(airportToUpdate);
    }

    public void deleteAirportById(int id) {
        Airport airportToDelete = airportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Airport not found"));

        airportRepository.delete(airportToDelete);
    }
}
