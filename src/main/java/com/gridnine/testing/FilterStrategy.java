package com.gridnine.testing;

import com.gridnine.testing.Flight;

import java.util.List;

public interface FilterStrategy {

    List<Flight> filteringFlights(List<Flight> flights);
}
