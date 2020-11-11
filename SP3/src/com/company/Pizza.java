package com.company;
import java.util.*;

/**
 * @author Jaan & Andreas
 */

public class Pizza{
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

    public Pizza(String name, ArrayList<String> stuff, int price){
        this.name = name;
        this.IngredientsList = stuff;
        this.price = price;
    }

    public void addIngredients(String s) {
        this.IngredientsList.add(s);
    }

    @Override
    public String toString() {
        return "\n" +
                name + "\n" +
                "Ingredienser: " + IngredientsList +
                "Pris: " + price + ",-";
    }
}
