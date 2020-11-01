package com.company;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        /* Creating instances
        pizzas and a menu  */
        Menu menu = new Menu("Menu");
        Pizza Margherita = new Pizza("Margherita", new ArrayList<String>(Arrays.asList("Tomatsauce", "ost")),49, 19.3, 1);
        Pizza Vesuvio = new Pizza("Vesuvio", new ArrayList<String>(Arrays.asList("Tomatsauce", "ost", "skinke")), 59, 19.3, 1);
        Pizza Hawaii = new Pizza("Hawaii", new ArrayList<String>(Arrays.asList("Tomatsauce", "ost", "skinke", "ananas")), 69, 19.3, 1);
        Pizza Pepperoni = new Pizza("Pepperoni", new ArrayList<String>(Arrays.asList("Tomatsauce", "ost", "Pepperoni")), 59, 19.3, 1);
        Pizza Milano = new Pizza("Milano", new ArrayList<String>(Arrays.asList("Tomatsauce", "ost", "Pepperoni", "oksekød", "skinke")), 69, 19.3, 1);
        Pizza Carbonara = new Pizza("Carbonara", new ArrayList<String>(Arrays.asList("Tomatsauce", "ost", "kødsauce", "løg")), 69, 19.3, 1);


        /*Add-function for adding pizzas
        to the menu and printing them in
        the console */
        menu.addPizza(Hawaii);
        menu.addPizza(Margherita);
        menu.addPizza(Vesuvio);
        menu.addPizza(Pepperoni);
        menu.addPizza(Milano);
        menu.addPizza(Carbonara);
        System.out.println(menu.toString());
    }
}
