package com.spring.flightreservation.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.flight.id = ?1")
    List<Reservation> getReservationsByFlightId(Long flightId);

    @Query("SELECT r FROM Reservation r WHERE r.flight.id = ?1 AND r.seat.id = ?2")
    Reservation findFirstByFlightIdAndSeatId(Long flightId, Long seatId);

}
