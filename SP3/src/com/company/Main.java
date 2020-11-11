package com.company;
import java.io.FileWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Create new orders by calling menu.newOrder and the index of which pizza is ordered and
        // time until pickup in min and seconds. OrderType can be a Walk-in or a PhoneOrder.

        /*
        0 = Margherita
        1 = Vesuvio
        2 = Hawaii
        3 = Pepperoni
        4 = Milano
        5 = Carbonara
         */
        new KeyListenerEx();
        Menu menu = new Menu("Menu");
        System.out.println(menu.toString()); // Display Menu every time

        menu.newOrder(1,30,00,"PhoneOrder");
        menu.newOrder(4,10,00,"Walk-in");

        menu.OrderPickedUp(menu.Orders.get(0).name);

    }
}
