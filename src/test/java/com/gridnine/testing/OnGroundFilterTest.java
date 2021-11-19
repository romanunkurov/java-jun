package com.gridnine.testing;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class OnGroundFilterTest {
    OnGroundTimingFilter filterStrategy;

    @Test
    public void filteringFlights_RawDataAssertion() {
        filterStrategy = new OnGroundTimingFilter();

        List<Segment> segments = new ArrayList<>();
        Segment one = new Segment(LocalDateTime.now().minusDays(1), LocalDateTime.now());
        Segment two = new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(5));
        Segment three = new Segment(LocalDateTime.now().plusHours(6), LocalDateTime.now().plusHours(10));
        segments.add(one);
        segments.add(two);
        segments.add(three);

        Flight flight = new Flight(segments);

        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight);

        List<Flight> flights = filterStrategy.filteringFlights(flightList);

        assertEquals(flightList, flights);
    }

    @Test
    public void filteringFlights_FilteredDataAssertion() {
        filterStrategy = new OnGroundTimingFilter();

        List<Segment> segments = new ArrayList<>();
        Segment one = new Segment(LocalDateTime.now().minusDays(1), LocalDateTime.now());
        Segment two = new Segment(LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(5));
        Segment three = new Segment(LocalDateTime.now().plusHours(8), LocalDateTime.now().plusHours(10));
        segments.add(one);
        segments.add(two);
        segments.add(three);

        Flight flight = new Flight(segments);

        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight);

        List<Flight> flights = filterStrategy.filteringFlights(flightList);

        assertNotEquals(flightList, flights);
    }


}
