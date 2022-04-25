package com.bridgelabzInvoice;

import java.util.Map;

public class InvoiceGenerator {

    /**
     * Created variables
     */
    private static final int MINIMUM_COST_PER_KILOMETER = 10;
    private static final int COST_PER_TIME = 1;
    private static final int MINIMUM_FARE = 5;

    /**
     * @Purpose: Calculate Fare
     * @Param: Distance, Time
     * @Return: Fare
     */
    public double calculateFare(double distance, int time) {
        double fare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;

        return Math.max(fare, MINIMUM_FARE);
    }
    /*
  Method to get Invoice Summary
   */
    public InvoiceSummary getInvoiceSummary(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    /**
     @Purpose: Calculate Fare
     @Param: Ride Array Having Distance And Time
     @Return: Fare
     */
    public double calculateFare(Ride[] rides) {
        double fare = 0;
        for(Ride ride : rides){
            fare += this.calculateFare(ride.distance,ride.time);
        }
        return fare;
    }

    /*
   Method to get list of a user using user id
    */
    public double calculateFare(String userID, Map<String, Ride[]> rideBook) {
        double fare = calculateFare(rideBook.get(userID));
        return fare;
    }
}
