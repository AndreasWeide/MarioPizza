import java.util.*;

public class Pizza extends Order {
    String name;
    ArrayList<Ingredients> IngredientsList;
    int price;
    Pizza(String name, ArrayList<Ingredients> stuff, int price){
        this.name = name;
        this.IngredientsList = stuff;
        this.price = price;
    }
    /*
    add function
    get/set
    menu + display
    save data
     */
}
