package com.keyin.passenger;

import com.fasterxml.jackson.annotation.JsonView;
import com.keyin.city.CityService;
import com.keyin.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@JsonView(Views.PassengerView.class)
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @Autowired
    private CityService cityService;

    @GetMapping("/passenger/all")
    public Iterable<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @GetMapping("passenger/id/{id}")
    public Passenger getPassengerById(@PathVariable int id) {
        return passengerService.getPassengerById(id);
    }

    @GetMapping("passenger/name/{name}")
    public Passenger getPassengerByName(@PathVariable String name) {
        return passengerService.getPassengerByName(name);
    }

    @PostMapping("/passenger")
    public Passenger addPassenger(@RequestBody PassengerDTO passengerDTO) {
        return passengerService.addPassenger(passengerDTO);
    }

    @PostMapping("/passenger/id/{id}")
    public Passenger updatePassengerById(@PathVariable int id, @RequestBody PassengerDTO passengerDTO) {
        return passengerService.updatePassengerById(id, passengerDTO);
    }

    @DeleteMapping("/passenger/id/{id}")
    public void deletePassengerById(@PathVariable int id) {
        passengerService.deletePassengerById(id);
    }
}
