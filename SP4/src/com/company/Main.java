package com.company;
import java.sql.*;
import java.util.*;
import java.util.Scanner;

public class Main {

    static String inputGetter;
    static String[] inputNewPizza;
    static String[] inputNewPizzaIngre;
    static String newPizzaIngreString = "";

    static ArrayList<String> PizzaIngreList = new ArrayList<>();

    public static void main(String[] args) {
        /*
        HUSK AT ÆNDRE USER OG PASSWORD INDE I MENU OG ORDER KLASSERNE :D
         */

        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        System.out.println("For at lave en ny bestilling, tast: ny bestilling");
        System.out.println("For at fjerne en bestilling, tast: fjern bestilling");
        System.out.println("For at se alle bestillinger, tast: vis bestilling");
        System.out.println("For at se menuen, tast: vis menu");
        System.out.println("For at tilføje en pizza til menuen, tast: tilføj ny pizza");

        inputGetter = sc.nextLine();

        if (inputGetter.toLowerCase().equals("ny bestilling")){
            menu.CreateOrder();
        }else if(inputGetter.toLowerCase().equals("fjern bestilling")){
            menu.RemoveOrder();
        }else if (inputGetter.toLowerCase().equals("vis bestillinger")){
            menu.ShowOrders();
        }else if(inputGetter.toLowerCase().equals("vis menu")){
            menu.showMenu();
        }else if(inputGetter.toLowerCase().equals("tilføj ny pizza")){
            System.out.println("Indtast dataen om pizzaen:");
            System.out.println("Indtast navn og pris på pizzaen med komma imellem de to værdier");
            inputNewPizza = sc.nextLine().split(",");
            String PizzaNavn = inputNewPizza[0];
            int PizzaPris = Integer.parseInt(inputNewPizza[1]);
            System.out.println("Indtast ingredienserne med komma imellem hver ingrediens");
            inputNewPizzaIngre = sc.nextLine().split(",");
            for (String s : inputNewPizzaIngre) {
                PizzaIngreList.add(s);
            }
            for (String j : PizzaIngreList){
                if (PizzaIngreList.indexOf(j)!=PizzaIngreList.size()-1){
                    newPizzaIngreString += j + ", ";
                }else{
                    newPizzaIngreString += j;
                }
            }
            menu.addNewPizzaMenu(PizzaNavn,PizzaPris,newPizzaIngreString);
        }
    }
}
