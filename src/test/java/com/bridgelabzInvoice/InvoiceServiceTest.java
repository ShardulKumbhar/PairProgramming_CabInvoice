package com.bridgelabzInvoice;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class InvoiceServiceTest {

    public static InvoiceGenerator invoiceGenerator = new InvoiceGenerator();


    /**
     * Step 1 -Calculating the fair
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
     *Step 1-  Rigorous Test :- Given Less Distance And Less Time Return Minimum Fare Equality Check
     */
    @Test
    public void givenLessDistanceAndTimeShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(5, fare, 0.0);
    }

    /**
     * Step 2-Rigorous Test :- Given Multiple Rides Return Total Fare Equality Check
     */
    @Test
    public void givenMultipleRidesShouldReturnTotalFare() {
        Ride[] rides = {new Ride(CategoryRide.REGULAR, 2.0, 5), new Ride(CategoryRide.REGULAR, 0.1, 1)};
        double fare = invoiceGenerator.calculateFare(rides);
        assertEquals(30, fare, 0.0);
    }
    /*
    Step 3 - Enhanced Invoice
    calculating total number of rides
    total fare
    Avrage fare per Ride
     */
    @Test
    public void givenMultipleRidesShouldReturnRideSummary() {

        Ride[] rides = {new Ride(CategoryRide.REGULAR, 2.0, 5),
                new Ride(CategoryRide.REGULAR, 0.1, 1)};

       InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(rides);
        InvoiceSummary expectedInvoicesummary = new InvoiceSummary(2, 30.0);
        assertEquals(expectedInvoicesummary, summary);
    }
    /*
    Test Case - 4 (Given UserID And Rides should return invoice generator)
     */
    @Test
    public void givenUserIDAndRides_ShouldReturnInvoiceSummary() {
        Map<String, Ride[]> rideBook = new HashMap<>();
        Ride[] rides = {
                new Ride(CategoryRide.REGULAR, 2.0, 5),
                new Ride(CategoryRide.REGULAR, 0.1, 1)
        };
        Ride[] rides1 = {
                new Ride(CategoryRide.REGULAR, 3.0, 5),
                new Ride(CategoryRide.REGULAR, 0.1, 1)
        };
        rideBook.put("Shardul", rides);
        rideBook.put("Akshay", rides1);
        String userID = "Shardul";
        double summary = invoiceGenerator.calculateFare(userID, rideBook);
        //InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(30, 2.0);
        assertEquals(30, summary);
    }

    /*
    Test Case - 5 (Given UserId And Rides of different categories of ride Should return invoice generator)
     */
    @Test
    public void givenNormalAndPremiumRideRate_ShouldReturnTotalFare() {
        Map<String, Ride[]> rideBook = new HashMap<>();
        Ride[] rides = {
                new Ride(CategoryRide.PREMIUM, 2.0, 5),
                new Ride(CategoryRide.REGULAR, 0.1, 1)
        };
        Ride[] rides1 = {
                new Ride(CategoryRide.PREMIUM, 3.0, 5),
                new Ride(CategoryRide.REGULAR, 0.1, 1)
        };
        rideBook.put("Shardul", rides);
        rideBook.put("Akshay", rides1);
        String userID = "Shardul";
        InvoiceSummary summary = invoiceGenerator.calculateFare(userID, rideBook);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(60.0, 2);
        assertEquals(expectedInvoiceSummary, summary);
    }	    }
}
