package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ExcludedFlightBeforeCurrentDateFilter implements FilterStrategy {

    @Override
    public List<Flight> filteringFlights(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight flight : flights) {
            int count = 0;
            for (Segment segment : flight.getSegments()) {
                if (!segment.getDepartureDate().isBefore(LocalDateTime.now())) {
                    count++;
                }
            }
            if (count == flight.getSegments().size()) {
                filteredFlights.add(flight);
            }
        }

        return filteredFlights;
    }
}
