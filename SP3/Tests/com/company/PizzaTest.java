package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * @author Andreas
 */

class PizzaTest {

    @Test
    void getName() throws Exception{
        Pizza pizzatest = new Pizza("Margherita", new ArrayList<String>(Arrays.asList("Tomatsauce", "ost")),49);
        assertEquals("Margherita",pizzatest.getName());
    }

    @Test
    void setName() {
        Pizza pizzatest = new Pizza("Margherita", new ArrayList<String>(Arrays.asList("Tomatsauce", "ost")),49);
        pizzatest.setName("Newname");
        assertEquals("Newname",pizzatest.getName());
    }

    @Test
    void getIngredientsList() {
        Pizza pizzatest = new Pizza("Margherita", new ArrayList<String>(Arrays.asList("Tomatsauce", "ost")),49);
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("Tomatsauce", "ost"));
        assertEquals(expected,pizzatest.getIngredientsList());
    }

    @Test
    void setIngredientsList() {
        Pizza pizzatest = new Pizza("Margherita", new ArrayList<String>(Arrays.asList("Tomatsauce", "ost")),49);
        ArrayList<String> newList = new ArrayList<String>(Arrays.asList("Tomatsauce", "ost","kebab"));
        pizzatest.setIngredientsList(newList);
        assertEquals(newList,pizzatest.getIngredientsList());
    }

    @Test
    void getPrice() {
        Pizza pizzatest = new Pizza("Margherita", new ArrayList<String>(Arrays.asList("Tomatsauce", "ost")),49);
        assertEquals(49,pizzatest.getPrice());
    }

    @Test
    void setPrice() {
        Pizza pizzatest = new Pizza("Margherita", new ArrayList<String>(Arrays.asList("Tomatsauce", "ost")),49);
        pizzatest.setPrice(55);
        assertEquals(55,pizzatest.getPrice());
    }

    @Test
    void addIngredients() {
        Pizza pizzatest = new Pizza("Margherita", new ArrayList<String>(Arrays.asList("Tomatsauce", "ost")),49);
        pizzatest.addIngredients("kebab");
        ArrayList<String> expectedList = new ArrayList<String>(Arrays.asList("Tomatsauce", "ost","kebab"));
        assertEquals(expectedList,pizzatest.getIngredientsList());
    }
}