package com.gridnine.testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static FlightFilter flightFilter = new FlightFilter();
    static List<Flight> flights = FlightBuilder.createFlights();

    public static void main(String[] args) throws IOException {
        String passengerChoice;
        boolean flag = true;

        while (flag) {
            System.out.print("Please, select the appropriate flight filter:" + "\n" +
                    "1 - Flights before current date" + "\n" +
                    "2 - Flights where arrivals are before departures" + "\n" +
                    "3 - Connecting flights more than 2 hours" + "\n" +
                    "4 - Show all flights without filtering" + "\n" +
                    "or type any text and press enter to exit" + "\n");

            passengerChoice = reader.readLine();

            switch (passengerChoice) {
                case "1":
                    flightFilter.setFilter(new ExcludedFlightBeforeCurrentDateFilter());
                    filterAndPrintResult(flights);
                    break;

                case "2":
                    flightFilter.setFilter(new ArrivalAfterDepartureFilter());
                    filterAndPrintResult(flights);
                    break;
                case "3":
                    flightFilter.setFilter(new OnGroundTimingFilter());
                    filterAndPrintResult(flights);
                    break;
                case "4":
                    flights.forEach(System.out::println);
                    System.out.println("----------------------------");
                    break;

                default:
                    flag = false;
                    break;
            }

        }
    }

    public static void filterAndPrintResult(List<Flight> list) {
        flightFilter.setFlights(list);
        flightFilter.filteringFlights().forEach(System.out::println);
        System.out.println("----------------------------");
    }
}