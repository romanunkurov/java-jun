package com.gridnine.testing;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ArrivalAfterDepartureFilterStrategyTest {
    ArrivalAfterDepartureFilter filterStrategy;

    @Test
    public void filteringFlights_RawDataAssertion() {
        filterStrategy = new ArrivalAfterDepartureFilter();

        List<Segment> segments = new ArrayList<>();
        Segment one = new Segment(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(2));
        Segment two = new Segment(LocalDateTime.now().minusDays(2), LocalDateTime.now().plusDays(3));
        segments.add(one);
        segments.add(two);

        Flight flight = new Flight(segments);

        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(flight);

        List<Flight> flightList = filterStrategy.filteringFlights(flights);

        assertEquals(flightList.size(), flights.size());

    }

    @Test
    public void filteringFlights_FilteredDataAssertion() {
        filterStrategy = new ArrivalAfterDepartureFilter();

        List<Segment> segments = new ArrayList<>();
        Segment one = new Segment(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(2));
        Segment two = new Segment(LocalDateTime.now().plusDays(2), LocalDateTime.now().plusDays(1));
        segments.add(one);
        segments.add(two);

        Flight flight = new Flight(segments);
        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(flight);

        List<Flight> actual = filterStrategy.filteringFlights(flights);
        assertNotEquals(flights, actual);
    }
}
