package com.keyin.aircraft;

import com.keyin.airline.Airline;
import jakarta.persistence.*;

@Entity
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;
    private int passengerCapacity;

    @ManyToOne
    private Airline airline;

    // constructors
    public Aircraft() {
    }

    public Aircraft(String type, int passengerCapacity, Airline airline) {
        this.type = type;
        this.passengerCapacity = passengerCapacity;
        this.airline = airline;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}
