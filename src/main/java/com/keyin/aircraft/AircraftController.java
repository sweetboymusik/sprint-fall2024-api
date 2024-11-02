package com.keyin.aircraft;

import com.fasterxml.jackson.annotation.JsonView;
import com.keyin.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@JsonView(Views.AircraftView.class)
public class AircraftController {
    @Autowired
    private AircraftService aircraftService;

    @GetMapping("/aircraft/all")
    public Iterable<Aircraft> getAllAircraft() {
        return aircraftService.getAllAircraft();
    }

    @GetMapping("/aircraft/id/{id}")
    public Aircraft getAircraftById(@PathVariable int id) {
        return aircraftService.getAircraftById(id);
    }

    @PostMapping("/aircraft")
    public Aircraft addAircraft(@RequestBody AircraftDTO aircraftDTO) {
        return aircraftService.addAircraft(aircraftDTO);
    }

    @PostMapping("/aircraft/id/{id}")
    public Aircraft updateAircraftById(@PathVariable int id, @RequestBody AircraftDTO aircraftDTO) {
        return aircraftService.updateAircraftById(id, aircraftDTO);
    }

    @DeleteMapping("/aircraft/id/{id}")
    public void deleteAircraftById(@PathVariable int id) {
        aircraftService.deleteAircraftById(id);
    }
}
