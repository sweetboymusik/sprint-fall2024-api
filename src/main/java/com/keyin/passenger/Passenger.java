package com.keyin.passenger;

import com.fasterxml.jackson.annotation.JsonView;
import com.keyin.city.City;
import com.keyin.views.Views;
import jakarta.persistence.*;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.PassengerView.class)
    private int id;

    @JsonView(Views.PassengerView.class)
    private String firstName;

    @JsonView(Views.PassengerView.class)
    private String lastName;

    @JsonView(Views.PassengerView.class)
    private String phoneNumber;

    @JsonView(Views.PassengerView.class)
    private String email;

    @ManyToOne
    @JsonView(Views.PassengerView.class)
    private City city;

    // constructors
    public Passenger() {
    }

    public Passenger(String firstName, String lastName, String phoneNumber, String email, City city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.city = city;
    }

    public Passenger(PassengerDTO passenger, City city) {
        this.firstName = passenger.getFirstName();
        this.lastName = passenger.getLastName();
        this.phoneNumber = passenger.getPhoneNumber();
        this.email = passenger.getEmail();
        this.city = city;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
