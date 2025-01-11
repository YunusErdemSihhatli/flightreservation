package com.spring.flightreservation.seat;

import com.spring.flightreservation.flight.Flight;
import com.spring.flightreservation.user.User;
import jakarta.persistence.*;

@Entity
@Table
public class Seat {
    @Id
    @SequenceGenerator(
            name = "seat_sequence",
            sequenceName = "seat_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seat_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinTable(name = "flight_id")
    private Flight flight;

    private String seatNumber;
    private boolean isAvailable;

    public Seat() {}

    public Seat(Long id, Flight flight, String seatNumber, boolean isAvailable) {
        this.id = id;
        this.flight = flight;
        this.seatNumber = seatNumber;
        this.isAvailable = isAvailable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
