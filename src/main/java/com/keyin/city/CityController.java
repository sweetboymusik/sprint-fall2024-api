package com.keyin.city;

import com.fasterxml.jackson.annotation.JsonView;
import com.keyin.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/getAllCities")
    @JsonView(Views.CityView.class)
    public Iterable<City> getAllCities(){
        return cityService.getAllCities();
    }

    @PostMapping("/city")
    @JsonView(Views.CityView.class)
    public City addCity(@RequestBody City city){
        return cityService.addCity(city);
    }

}
