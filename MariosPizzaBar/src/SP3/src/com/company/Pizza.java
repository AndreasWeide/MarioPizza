package com.company;
import java.util.*;

public class Pizza extends Order{
    String name;
    ArrayList<String> IngredientsList;
    int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getIngredientsList() {
        return IngredientsList;
    }

    public void setIngredientsList(ArrayList<String> ingredientsList) {
        IngredientsList = ingredientsList;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    Pizza(String name, ArrayList<String> stuff, int price, double bestillingstidspunkt, int afhentningstidspunkt){
        super(bestillingstidspunkt, afhentningstidspunkt);
        this.name = name;
        this.IngredientsList = stuff;
        this.price = price;
    }

    public void addIngredients(String s) {
        this.IngredientsList.add(s);
    }

    //TO-DO List: save data

    @Override
    public String toString() {
        return "\n" +
                "Pizza: " + name + "\n" +
                "Ingredienser: " + IngredientsList + " " +
                "Pris: " + price + ",-";
    }
}
