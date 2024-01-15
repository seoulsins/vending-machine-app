package com.techelevator.view;

import java.awt.geom.Line2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Change  {
    private final Map<Money, Integer> change;

    public Change() {
        change = new HashMap<>();
    }

    public  void add(Money money, int quantity){
       //adds the coin amount and quantity to the change
        if(change.containsKey(money)){
            change.put(money, change.get(money)+ quantity);
        }else{
            change.put(money,quantity);
        }
    }
     public double getTotal() {
       //method to find the total
        //Makes the total 0
        double total =  0;
        for(Map.Entry<Money, Integer> entry : change.entrySet()){
            total = total + (entry.getKey().getValue() * (entry.getValue()));
        }
        return total;
     }

    public void makeChange(double currentMoney) {
    }
}
