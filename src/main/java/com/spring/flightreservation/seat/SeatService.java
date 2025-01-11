package com.spring.flightreservation.seat;

import com.spring.flightreservation.flight.Flight;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public Optional<List<Seat>> getSeats(Long flightId) {
        return seatRepository.getSeatsByFlightId(flightId);
    }

    public void createSeat(Seat seat) {
        seatRepository.getSeatByFlightIdAndSeatNumber(seat.getFlight().getId(), seat.getSeatNumber()).orElseThrow(
                () -> new RuntimeException("Seat is exist")
        );
        seatRepository.save(seat);
    }

    @Transactional
    public Seat updateSeat(Long Id, Long flightId, boolean isAvailable) {
        Seat seat = seatRepository.findById(Id).orElseThrow(
                () -> new RuntimeException("Seat not found")
        );
        if (!seat.getFlight().getId().equals(flightId)) {
            seat.getFlight().setId(flightId);
        }
        if (seat.isAvailable() != isAvailable) {
            seat.setAvailable(isAvailable);
        }
        return seat;
    }

    public Seat deleteSeat(Long id) {
        if (!seatRepository.existsById(id)) {
            throw new IllegalArgumentException("Seat with id " + id + " does not exist");
        }
        seatRepository.deleteById(id);
        return null;
    }

}
