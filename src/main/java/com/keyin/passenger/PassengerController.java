package com.keyin.passenger;

import com.keyin.city.City;
import com.keyin.city.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/getAllPassengers")
    public Iterable<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @PostMapping("/passenger")
    public Passenger createPassenger(@RequestBody PassengerDTO passengerDTO) {
        City city = cityRepository.findById(passengerDTO.getCityId())
                .orElseThrow(() -> new RuntimeException("City not found"));

        Passenger passenger = new Passenger(passengerDTO, city);

        return passengerService.addPassenger(passenger);
    }
}
