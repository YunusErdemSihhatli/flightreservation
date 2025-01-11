package com.spring.flightreservation.reservation;

import com.spring.flightreservation.flight.Flight;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationsByFlightId(Long flightId) {
        return reservationRepository.getReservationsByFlightId(flightId);
    }

    public void createReservation(Reservation reservation) {
        if (seatReserved(reservation.getFlight().getId(), reservation.getSeat().getId())) {
            throw new RuntimeException("Seat reserved already");
        } else {
            reservationRepository.save(reservation);
        }
    }

    @Transactional
    public Reservation updateReservation(Long Id, Long flightId, Long seatId) {
        Reservation reservation = reservationRepository.findById(Id).orElseThrow(
                () -> new RuntimeException("Reservation not found")
        );
        if (!reservation.getSeat().getId().equals(seatId)) {
            if (seatReserved(flightId, seatId)) {
                throw new RuntimeException("Seat reserved already");
            } else {
                reservation.getSeat().setId(seatId);
            }
        }
        return reservation;
    }

    public Reservation deleteReservation(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new IllegalArgumentException("Reservation with id " + id + " does not exist");
        }
        reservationRepository.deleteById(id);
        return null;
    }

    private boolean seatReserved(Long flightId, Long seatId) {
        Reservation reservationExist = reservationRepository.findFirstByFlightIdAndSeatId(flightId, seatId);
        return reservationExist != null;
    }
}
