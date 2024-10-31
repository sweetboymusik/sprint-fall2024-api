package com.keyin.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public Iterable<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City addCity(City city) {
        return cityRepository.save(city);
    }

    public City getCityById(int id) {
        return cityRepository.findById(id).orElse(null);
    }

    public City getCityByName(String name) {
        return cityRepository.findByName(name);
    }

    public City updateCityById(int id, City city) {
        City cityToUpdate = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found"));

        if (city.getName() != null) cityToUpdate.setName(city.getName());
        if (city.getState() != null) cityToUpdate.setState(city.getState());
        if (city.getPopulation() != 0) cityToUpdate.setPopulation(city.getPopulation());

        return cityRepository.save(cityToUpdate);
    }

    public void deleteCityById(int id) {
        City cityToDelete = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found"));

        cityRepository.delete(cityToDelete);
    }
}
