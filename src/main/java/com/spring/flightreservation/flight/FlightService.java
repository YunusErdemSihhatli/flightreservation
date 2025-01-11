package com.spring.flightreservation.flight;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public void createFlight(Flight flight) {
        flightRepository.save(flight);
    }

    @Transactional
    public Flight updateFlight(Long Id, String name) {
        Flight flight = flightRepository.findById(Id).orElseThrow(
                () -> new RuntimeException("Flight not found")
        );
        if (!flight.getName().equals(name)) {
            flight.setName(name);
        }
        return flight;
    }

    public Flight deleteFlight(Long id) {
        if (!flightRepository.existsById(id)) {
            throw new IllegalArgumentException("Flight with id " + id + " does not exist");
        }
        flightRepository.deleteById(id);
        return null;
    }

}
