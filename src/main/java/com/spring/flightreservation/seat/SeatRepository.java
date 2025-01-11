package com.spring.flightreservation.seat;

import com.spring.flightreservation.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Query("SELECT s FROM Seat s WHERE s.flight.id = ?1")
    Optional<List<Seat>> getSeatsByFlightId(Long id);

    @Query("SELECT s FROM Seat s WHERE s.flight.id = ?1 AND s.seatNumber = ?2")
    Optional<Seat> getSeatByFlightIdAndSeatNumber(Long flightId, String seatNumber);

}
