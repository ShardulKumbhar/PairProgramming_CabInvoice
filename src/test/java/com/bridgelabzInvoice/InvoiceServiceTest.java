package com.bridgelabzInvoice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertEquals(5, fare, 0.0);
    }
}
