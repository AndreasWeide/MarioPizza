package com.company;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Jaan & Andreas
 */

public class Menu {
    ArrayList<Pizza> Pizzaer;
    String name;
    ArrayList<Order> Orders = new ArrayList<>();


    public Menu(String name) {
        this.name = name;
        this.Pizzaer = new ArrayList<>();
        Pizzaer.add(new Pizza("Margherita", new ArrayList<String>(Arrays.asList("Tomatsauce", "ost")),49));
        Pizzaer.add(new Pizza("Vesuvio", new ArrayList<String>(Arrays.asList("Tomatsauce", "ost", "skinke")), 59));
        Pizzaer.add(new Pizza("Hawaii", new ArrayList<String>(Arrays.asList("Tomatsauce", "ost", "skinke", "ananas")), 69));
        Pizzaer.add(new Pizza("Pepperoni", new ArrayList<String>(Arrays.asList("Tomatsauce", "ost", "Pepperoni")), 59));
        Pizzaer.add(new Pizza("Milano", new ArrayList<String>(Arrays.asList("Tomatsauce", "ost", "Pepperoni", "oksekød", "skinke")), 69));
        Pizzaer.add(new Pizza("Carbonara", new ArrayList<String>(Arrays.asList("Tomatsauce", "ost", "kødsauce", "løg")), 69));
    }


    public void addNewPizza(String name, String Ingredients1,String Ingredients2,String Ingredients3,int price) {
        ArrayList<String> Ing = new ArrayList<>();
        Ing.add(Ingredients1); Ing.add(Ingredients2); Ing.add(Ingredients3);
        Pizza newPizza = new Pizza(name,Ing,price);
        Pizzaer.add(newPizza);
    }

    public void newOrder(int pizzaIndex, int Min, int Seconds, String OrderType){
        // OrderType can be Walk-in or order over phone
        Order o = new Order(Pizzaer.get(pizzaIndex), OrderType);
        o.setPickUp(Min,Seconds);
        Orders.add(o);
        System.out.println(o);
    }

    public void OrderPickedUp(String namePizza){
        for(Order o : Orders){
            if (o.name.equals(namePizza)){
                o.isPickedup();
                Orders.remove(o);
            }
        }
    }

    @Override
    public String toString() {
        return Pizzaer.toString();
    }
}
