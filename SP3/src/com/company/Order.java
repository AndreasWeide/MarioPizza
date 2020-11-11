package com.company;
import java.time.Duration;
import java.util.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.io.*;

/**
 * @author Jaan & Andreas
 */


public class Order extends Pizza {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm");
    private static float duration = ((59 * 60) + 59) * 1000; //default is 1 hour till pickup
    Timestamp OrderTime;
    Timestamp pickupTime = new Timestamp((long) (System.currentTimeMillis() + duration));
    boolean PickedUp = false;
    String orderType;


    public Order(Pizza p,String orderType) {
        super(p.name,p.IngredientsList,p.price);
        this.OrderTime = new Timestamp(System.currentTimeMillis());
        sdf.format(this.OrderTime);
        sdf.format(this.pickupTime);
        this.orderType = orderType;

    }

    public void setPickUp(int Min,int Seconds){
        this.duration = ((Min * 60) + Seconds) * 1000;
        this.pickupTime.setTime((long) (OrderTime.getTime() + this.duration));
    }

    public void isPickedup(){
        this.PickedUp = true;
        try {
            FileWriter fw = new FileWriter("Data.txt");
            fw.write(this.toString());
            fw.close();
        }catch(Exception e){
            System.out.println(e);
        }

    }

    public Timestamp getPickupTime(){
        return pickupTime;
    }

    @Override
    public String toString() {
            return "\n" +
                    name + "\n" +
                    "Ingredienser: " + IngredientsList + "\n" +
                    "Pris: " + price + ",-" + "\n" + "Afhentingstidspunkt: " + pickupTime + "\n"
                    + "Order type: " + orderType;

    }
}
