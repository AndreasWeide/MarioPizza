package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author Jaan
 */

class MenuTest {
    Menu menuTest = new Menu("Menu");
    Pizza pTest = new Pizza("Hawaii", new ArrayList<String>(Arrays.asList("Tomatsauce", "ost", "skinke", "ananas")), 69);
    Order orderTest = new Order(pTest,"OrderTest");

    @Test
    void addNewPizza() {
        menuTest.addNewPizza("Margherita","1","2","3",50);
        assertEquals("Margherita", menuTest.Pizzaer.get(0).getName());
    }

    @Test
    void NewOrder() {
        menuTest.newOrder(0,00,00,"Test");
        assertEquals("Margherita", menuTest.Pizzaer.get(0).getName());
    }


}