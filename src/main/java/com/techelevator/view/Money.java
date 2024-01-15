package com.techelevator.view;


public class Money {
    //creates the different types of coins that the machine will use
    private  final double PENNY = 0.01;
    private  final double NICKLE =.05;
    private final double DIME = 0.10;
    private final double QUARTER= 0.25;

    private double value;

    private Money(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
