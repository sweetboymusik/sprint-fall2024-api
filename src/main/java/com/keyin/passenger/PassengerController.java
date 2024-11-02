package com.keyin.passenger;

import com.fasterxml.jackson.annotation.JsonView;
import com.keyin.city.City;
import com.keyin.city.CityRepository;
import com.keyin.city.CityService;
import com.keyin.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @Autowired
    private CityService cityService;

    @GetMapping("/passenger/all")
    @JsonView(Views.PassengerView.class)
    public Iterable<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @GetMapping("passenger/id/{id}")
    @JsonView(Views.PassengerView.class)
    public Passenger getPassengerById(@PathVariable int id) {
        return passengerService.getPassengerById(id);
    }

    @GetMapping("passenger/name/{name}")
    @JsonView(Views.PassengerView.class)
    public Passenger getPassengerByName(@PathVariable String name) {
        String[] names = name.split("_");
        String firstName = names[0];
        String lastName = names[1];

        return passengerService.getPassengerByName(firstName, lastName);
    }

    @PostMapping("/passenger")
    @JsonView(Views.PassengerView.class)
    public Passenger createPassenger(@RequestBody PassengerDTO passengerDTO) {
        City city = cityService.getCityById(passengerDTO.getCityId());
        Passenger passenger = new Passenger(passengerDTO, city);

        return passengerService.addPassenger(passenger);
    }

    @PostMapping("/passenger/id/{id}")
    @JsonView(Views.PassengerView.class)
    public Passenger updatePassengerById(@PathVariable int id, @RequestBody PassengerDTO passengerDTO) {
        return passengerService.updatePassengerById(id, passengerDTO);
    }

    @DeleteMapping("/passenger/id/{id}")
    @JsonView(Views.PassengerView.class)
    public void deletePassengerById(@PathVariable int id) {
        passengerService.deletePassengerById(id);
    }
}
