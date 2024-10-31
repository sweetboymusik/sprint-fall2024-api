package com.keyin.city;

import com.fasterxml.jackson.annotation.JsonView;
import com.keyin.airport.Airport;
import com.keyin.views.Views;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({Views.CityView.class, Views.AirportView.class, Views.PassengerView.class, Views.FlightView.class})
    private int id;

    @JsonView({Views.CityView.class, Views.AirportView.class, Views.PassengerView.class, Views.FlightView.class})
    private String name;

    @JsonView({Views.CityView.class, Views.AirportView.class, Views.PassengerView.class, Views.FlightView.class})
    private String state;

    @JsonView({Views.CityView.class, Views.AirportView.class, Views.PassengerView.class, Views.FlightView.class})
    private int population;

    @OneToMany(mappedBy = "city")
    @JsonView(Views.CityView.class)
    private List<Airport> airports;

    // constructors
    public City() {
    }

    public City(String name, String state, int population) {
        this.name = name;
        this.state = state;
        this.population = population;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }
}
