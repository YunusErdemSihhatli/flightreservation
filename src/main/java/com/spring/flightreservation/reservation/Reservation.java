package com.spring.flightreservation.reservation;

import com.spring.flightreservation.flight.Flight;
import com.spring.flightreservation.seat.Seat;
import com.spring.flightreservation.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Reservation {
    @Id
    @SequenceGenerator(
            name = "reservation_sequence",
            sequenceName = "reservation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reservation_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinTable(name = "flight_id")
    private Flight flight;

    @ManyToOne
    @JoinTable(name = "user_id")
    private User user;

    @ManyToOne
    @JoinTable(name = "seat_id")
    private Seat seat;

    private LocalDateTime reservationDate;

    public Reservation() {}

    public Reservation(Long id, Flight flight, User user, Seat seat, LocalDateTime reservationDate) {
        this.id = id;
        this.flight = flight;
        this.user = user;
        this.seat = seat;
        this.reservationDate = reservationDate;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }
}
