package com.keyin.airline;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.keyin.aircraft.Aircraft;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String country;

    @OneToMany(mappedBy = "airline")
    private List<Aircraft> aircraftList;

    // constructors
    public Airline() {
    }

    public Airline(String name, String country) {
        this.name = name;
        this.country = country;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Aircraft> getAircraftList() {
        return aircraftList;
    }

    public void setAircraftList(List<Aircraft> aircraftList) {
        this.aircraftList = aircraftList;
    }
}
