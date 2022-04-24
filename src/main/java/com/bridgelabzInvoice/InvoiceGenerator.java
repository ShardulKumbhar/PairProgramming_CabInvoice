package com.bridgelabzInvoice;

public class InvoiceGenerator{

    private static final double MINIMUM_COST_PER_KILOMETER = 10.0;
    private static final int COST_PER_TIME = 1;
    /**
     @Purpose: Calculate Fare
     @Param: Distance, Time
     @Return: Fare
     */
    public double calculateFare(double distance, int time) {
        double fare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return fare;
    }
}
