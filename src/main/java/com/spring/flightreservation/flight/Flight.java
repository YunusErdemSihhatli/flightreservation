package com.spring.flightreservation.flight;

import com.spring.flightreservation.seat.Seat;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Flight {
    @Id
    @SequenceGenerator(
            name = "flight_sequence",
            sequenceName = "flight_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "flight_sequence"
    )
    private Long id;
    private String name;
    private String description;
    private String flightNumber;
    private String departure;
    private String arrival;
    private Double price;
    @OneToMany
    private List<Seat> seats;
    @OneToMany
    private List<Seat> availableSeats;

    public Flight() {
    }

    public Flight(Long id, String name, String description, String flightNumber, String departure, String arrival, Double price, List<Seat> seats, List<Seat> availableSeats) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
        this.seats = seats;
        this.availableSeats = availableSeats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }
}
