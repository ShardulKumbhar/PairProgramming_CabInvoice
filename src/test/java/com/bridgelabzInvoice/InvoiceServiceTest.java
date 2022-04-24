package com.bridgelabzInvoice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class InvoiceServiceTest {

    public static InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
    ;

    /**
     * Calculating the fair
     */
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        /*
        Checking by Assert Equals
         */
        assertEquals(25.0, fare, 0.0);
    }

    /**
     * Rigorous Test :- Given Less Distance And Less Time Return Minimum Fare Equality Check
     */
    @Test
    public void givenLessDistanceAndTimeShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(5, fare, 0.0);
    }

    /**
     * Rigorous Test :- Given Multiple Rides Return Total Fare Equality Check
     */
    @Test
    public void givenMultipleRidesShouldReturnTotalFare() {
        Ride[] rides = {new Ride(2.0, 5), new Ride(0.1, 1)};
        double fare = invoiceGenerator.calculateFare(rides);
        assertEquals(30, fare, 0.0);
    }
}
