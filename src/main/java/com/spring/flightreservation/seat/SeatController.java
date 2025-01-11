package com.spring.flightreservation.seat;

import com.spring.flightreservation.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/seats")
public class SeatController {

    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public Optional<List<Seat>> getSeatsByFlightId(@RequestBody Long flightId) {
        return seatService.getSeats(flightId);
    }

    @PostMapping
    public Seat createSeat(@RequestBody Seat seat) {
        seatService.createSeat(seat);
        return seat;
    }

    @PutMapping
    public Seat updateSeat(@RequestBody Long Id, @RequestBody Long flightId, @RequestBody boolean isAvailable) {
        return seatService.updateSeat(Id, flightId, isAvailable);
    }

    @DeleteMapping
    public Seat deleteSeat(@RequestBody Long id) {
        return seatService.deleteSeat(id);
    }
}
