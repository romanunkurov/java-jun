package com.gridnine.testing;

import java.util.List;

public class FlightFilter {

    private FilterStrategy filter;
    private List<Flight> flights;

    public void setFilter(FilterStrategy filter) {
        this.filter = filter;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> filteringFlights() {
        return filter.filteringFlights(flights);
    }
}
