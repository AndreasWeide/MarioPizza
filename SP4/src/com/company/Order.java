package com.company;
import java.sql.*;
import java.time.Duration;
import java.util.*;
import java.text.SimpleDateFormat;
import java.io.*;

/**
 * @author Jaan & Andreas
 */


public class Order {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm");
    float duration;
    Timestamp OrderTime = new Timestamp(System.currentTimeMillis());
    Timestamp pickupTime;

    ArrayList<Pizza> PizzasList;
    ArrayList<String> PizzasNameList;
    ArrayList<Integer> PizzasPriceList;

    String url = "jdbc:mysql://localhost:3306/mariopizza?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    //CHANGE THESE TWO
    String user = "";
    String password = "";


    String name;
    String ingredients;
    int price;
    int Number;


    public Order(int PhoneNumber,int Min,int Seconds,ArrayList<Pizza> Pizzas) throws SQLException {
        this.PizzasList = Pizzas;

        PizzasNameList = new ArrayList<>();
        PizzasPriceList = new ArrayList<>();
        this.duration = ((Min * 60) + Seconds) * 1000;
        this.pickupTime = new Timestamp((long) (System.currentTimeMillis() + duration));
        sdf.format(this.OrderTime);
        sdf.format(this.pickupTime);
        this.Number = PhoneNumber;
        if (PizzasList.size() < 2){
            this.name = PizzasList.get(0).name;
            this.ingredients = PizzasList.get(0).Ingredients;
            this.price = PizzasList.get(0).price;
            try{
                Connection conn = DriverManager.getConnection(url,user,password);
                String query = "INSERT INTO orders(PhoneNumber,Pizza,PizzaPrice,PickupTime)" +
                        " values (?,?,?,?)";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1,this.Number);
                preparedStmt.setString(2,this.name);
                preparedStmt.setInt(3,this.price);
                preparedStmt.setTimestamp(4,this.pickupTime);
                preparedStmt.execute();
                conn.close();
            }catch(Exception e){
                System.out.println("Something went wrong :/");
                System.out.println(e);
            }
        }else {
            for (int i = 0; i < PizzasList.size(); i++) {
                this.PizzasNameList.add(PizzasList.get(i).name);
                this.PizzasPriceList.add(PizzasList.get(i).price);
            }
            try{
                String multiplePizzaString = "";
                for (String s : PizzasNameList){
                    if (PizzasNameList.indexOf(s) != PizzasNameList.size()-1){
                        multiplePizzaString += s + ", ";
                    }else {
                        multiplePizzaString += s;
                    }
                }
                int sumPrice = 0;
                for (Integer i: PizzasPriceList){
                    sumPrice += i;
                }
                Connection conn = DriverManager.getConnection(url,user,password);
                String query = "INSERT INTO orders(PhoneNumber,Pizza,PizzaPrice,PickupTime)" +
                        " values (?,?,?,?)";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1,this.Number);
                preparedStmt.setString(2,multiplePizzaString);
                preparedStmt.setInt(3,sumPrice);
                preparedStmt.setTimestamp(4,this.pickupTime);
                preparedStmt.execute();
                conn.close();
            }catch(Exception e){
                System.out.println("Something went wrong :/");
                System.out.println(e);
            }
        }

    }

    @Override
    public String toString() {
        if(PizzasList.size()>1){
            for(int i = 0; i < PizzasList.size(); i++){
                return "\n"+ PizzasList.get(i).name + "\n" + PizzasList.get(i).Ingredients + "\n" + PizzasList.get(i).price + "\n"
                        + this.pickupTime + "\n" ;
            }
        }
            return "\n" + name + "\n" + this.ingredients + "\n" + this.price + "\n"
                    + this.pickupTime + "\n";
    }

}
