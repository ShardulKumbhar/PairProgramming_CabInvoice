package com.bridgelabzInvoice;

public class InvoiceSummary {
    private final int noOfRides;
    private final double totalFare;
    private final double averageFare;
    /*
    Generate Constructor With Number Of Rides, Total Fare As Parameters
     */
    public InvoiceSummary(int noOfRides, double totalFare) {
        this.noOfRides = noOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare / this.noOfRides;
    }
    /*
    Generate equals() Method
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return noOfRides == that.noOfRides &&
                Double.compare(that.totalFare, totalFare) == 0 &&
                Double.compare(that.averageFare, averageFare) == 0;
    }
    /*
    Generate toString() Method

     */
    @Override
    public String toString() {
        return "InvoiceSummary{" +
                "noOfRides=" + noOfRides +
                ", totalFare=" + totalFare +
                ", averageFare=" + averageFare +
                '}';
    }
}
