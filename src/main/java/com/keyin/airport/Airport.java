package com.keyin.airport;

import com.fasterxml.jackson.annotation.JsonView;
import com.keyin.city.City;
import com.keyin.views.Views;
import jakarta.persistence.*;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({Views.CityView.class, Views.AirportView.class})
    private int id;

    @JsonView({Views.CityView.class, Views.AirportView.class})
    private String name;

    @JsonView({Views.CityView.class, Views.AirportView.class})
    private String code;

    @ManyToOne
    @JsonView(Views.AirportView.class)
    private City city;

    // constructors
    public Airport() {}

    public Airport(String name, String code, City city) {
        this.name = name;
        this.code = code;
        this.city = city;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
