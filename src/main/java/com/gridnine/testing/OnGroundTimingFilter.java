package com.gridnine.testing;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class OnGroundTimingFilter implements FilterStrategy {

    @Override
    public List<Flight> filteringFlights(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight flight : flights) {
            for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                long hours = ChronoUnit.HOURS.between(flight.getSegments().get(i).getArrivalDate(),
                        flight.getSegments().get(i + 1).getDepartureDate());
                if (!(hours > 2) && !filteredFlights.contains(flight)) {
                    filteredFlights.add(flight);
                }
            }
        }
        return filteredFlights;
    }
}
