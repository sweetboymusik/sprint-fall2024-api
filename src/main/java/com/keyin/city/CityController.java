package com.keyin.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/getAllCities")
    public Iterable<City> getAllCities(){
        return cityService.getAllCities();
    }

    @PostMapping("/city")
    public City addCity(@RequestBody City city){
        return cityService.addCity(city);
    }

}
