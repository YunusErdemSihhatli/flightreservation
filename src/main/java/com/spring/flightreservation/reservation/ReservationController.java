package com.spring.flightreservation.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getReservations(@RequestParam(required = false) Long flightId) {
        if (flightId != null) {
            return reservationService.getReservationsByFlightId(flightId);
        }
        return reservationService.getReservations();
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        reservationService.createReservation(reservation);
        return reservation;
    }

    @PutMapping
    public Reservation updateReservation(@RequestBody Long id, @RequestBody Long flightId, @RequestBody Long seatId) {
        return reservationService.updateReservation(id, flightId, seatId);
    }

    @DeleteMapping
    public Reservation deleteReservation(@PathVariable Long id) {
        return reservationService.deleteReservation(id);
    }
}
