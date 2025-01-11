package com.spring.flightreservation.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/flights")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getFlights() {
        return flightService.getFlights();
    }

    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        flightService.createFlight(flight);
        return flight;
    }

    @DeleteMapping
    public Flight deleteFlight(@RequestBody Long id) {
        return flightService.deleteFlight(id);
    }

    @PutMapping
    public Flight updateFlight(@RequestBody Long id, @RequestBody String name) {
        return flightService.updateFlight(id, name);
    }

}
