package com.company;
import java.util.*;

/**
 * @author Jaan & Andreas
 */

public class Pizza{
    String name;
    String Ingredients;
    int price;

    public Pizza(String name, String stuff, int price){
        this.name = name;
        this.Ingredients = stuff;
        this.price = price;
    }

    @Override
    public String toString() {
        return "\n" +
                name + "\n" +
                "Ingredienser: " + Ingredients + "\n" +
                "Pris: " + price + ",-" + "\n" ;
    }

}
