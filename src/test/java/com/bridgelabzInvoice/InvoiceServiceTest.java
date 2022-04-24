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

}
