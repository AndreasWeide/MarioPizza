package com.company;
import java.util.ArrayList;

public class Menu {
    ArrayList<Pizza> Pizzaer;
    String name;

    public Menu(String name) {
        this.name = name;
        this.Pizzaer = new ArrayList<>();
    }

    public void addPizza(Pizza p) {
        Pizzaer.add(p);
    }

    @Override
    public String toString() {
        for (Pizza p: Pizzaer) {
            return Pizzaer.toString();
        }
        return null;
    }
}
