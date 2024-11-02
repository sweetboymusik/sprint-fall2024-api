package com.keyin.city;

import com.fasterxml.jackson.annotation.JsonView;
import com.keyin.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@JsonView(Views.CityView.class)
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/city/all")
    public Iterable<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/city/id/{id}")
    public City getCity(@PathVariable int id) {
        return cityService.getCityById(id);
    }

    @GetMapping("/city/name/{name}")
    public City getCityByName(@PathVariable String name) {
        return cityService.getCityByName(name);
    }

    @PostMapping("/city")
    public City addCity(@RequestBody City city) {
        return cityService.addCity(city);
    }

    @PostMapping("/city/id/{id}")
    public City updateCityById(@PathVariable int id, @RequestBody City city) {
        return cityService.updateCityById(id, city);
    }

    @DeleteMapping("/city/id/{id}")
    public void deleteCityById(@PathVariable int id) {
        cityService.deleteCityById(id);
    }
}
