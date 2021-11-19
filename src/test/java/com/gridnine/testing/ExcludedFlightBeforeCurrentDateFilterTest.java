package com.gridnine.testing;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ExcludedFlightBeforeCurrentDateFilterTest {

    ExcludedFlightBeforeCurrentDateFilter filterStrategy;

    @Test
    public void filteringFlights_RawDataAssertion() {
        filterStrategy = new ExcludedFlightBeforeCurrentDateFilter();

        List<Segment> segments = new ArrayList<>();
        Segment one = new Segment(LocalDateTime.now().plusDays(2), LocalDateTime.now());
        Segment two = new Segment(LocalDateTime.now().plusDays(2), LocalDateTime.now());
        segments.add(one);
        segments.add(two);

        Flight flight = new Flight(segments);

        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight);

        List<Flight> flights = filterStrategy.filteringFlights(flightList);

        assertEquals(flightList, flights);
    }

    @Test
    public void filteringFlights_FilteredDataAssertion() {
        filterStrategy = new ExcludedFlightBeforeCurrentDateFilter();

        List<Segment> segments = new ArrayList<>();
        Segment one = new Segment(LocalDateTime.now().minusDays(1), LocalDateTime.now());
        Segment two = new Segment(LocalDateTime.now().minusDays(1), LocalDateTime.now());
        segments.add(one);
        segments.add(two);

        Flight flight = new Flight(segments);

        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight);

        List<Flight> flights = filterStrategy.filteringFlights(flightList);

        assertNotEquals(flightList, flights);
    }
}
