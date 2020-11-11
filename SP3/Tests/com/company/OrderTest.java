package com.company;
import java.util.*;
import org.junit.jupiter.api.Test;
import java.sql.Timestamp;


import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jaan & Andreas
 */


class OrderTest {
    Pizza pTest = new Pizza("Hawaii", new ArrayList<String>(Arrays.asList("Tomatsauce", "ost", "skinke", "ananas")), 69);
    Order orderTest = new Order(pTest,"OrderTest");
    float durationTest;
     // = ((59 * 60) + 59) * 1000; //default is 1 hour till pickup


    @Test
    void setPickUp() {
        orderTest.setPickUp(30,50);
        durationTest = ((30 * 60) + 50) * 1000;
        Timestamp pickupTimeTest = new Timestamp((long) (System.currentTimeMillis() + durationTest));
        assertEquals(pickupTimeTest,orderTest.getPickupTime());
    }

    @Test
    void isPickedup() {
        orderTest.isPickedup();
        assertEquals(true,orderTest.PickedUp);
    }

    @Test
    void getPickupTime() {
        assertEquals(orderTest.pickupTime,orderTest.getPickupTime());
    }
}