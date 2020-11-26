package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Jaan & Andreas
 */

public class Menu {
    ArrayList<Pizza> Pizzaer;

    String url = "jdbc:mysql://localhost:3306/mariopizza?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    // CHANGE USER AND PASSWORD

    String user = "";
    String password = "";


    Scanner sc1 = new Scanner(System.in);
    int PizzaId;
    String PizzaName;
    String PizzaIngredients;
    int PizzaPrice;

    boolean doneBoo = false;

    public Menu() {
        this.Pizzaer = new ArrayList<>();

        try{
            Connection conn = DriverManager.getConnection(url,user,password);
            Statement st = conn.createStatement();
            String query = "SELECT * FROM menu";
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                PizzaId = rs.getInt("PizzaID");
                PizzaName = rs.getString("PizzaName");
                PizzaIngredients = rs.getString("PizzaIngredients");
                PizzaPrice = rs.getInt("PizzaPrice");
                Pizzaer.add(new Pizza(PizzaName,PizzaIngredients,PizzaPrice));
            }
            conn.close();
        }catch(Exception e){
            System.out.println("Noget gik galt med menuen :/");
            System.out.println(e);

        }
    }

    public void addNewPizzaMenu(String name,int price,String ingredients) {

        String inputAddPIZZA;

        Pizza newPizza = new Pizza(name, ingredients, price);

        while (this.doneBoo == false) {
            try {
                Connection conn = DriverManager.getConnection(url,user,password);
                String query = " INSERT INTO menu (PizzaName,PizzaIngredients,PizzaPrice)"
                        + " values (?, ?, ?)";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, newPizza.name);
                preparedStmt.setString(2, newPizza.Ingredients);
                preparedStmt.setInt(3, newPizza.price);
                preparedStmt.execute();
                System.out.println("Hvis du vil lave en bestilling tast: ny");
                System.out.println("Hvis du vil fjerne en bestilling tast: fjern");
                System.out.println("Hvis du vil se alle bestillinger tast: vis");
                System.out.println("Hvis du vil se menuen tast: vis menu");
                System.out.println("Hvis du vil afslutte programmet tast: afslut");
                inputAddPIZZA = sc1.nextLine();
                if (inputAddPIZZA.toLowerCase().equals("afslut")){
                    conn.close();
                    this.doneBoo = true;
                }else if(inputAddPIZZA.toLowerCase().equals("fjern")){
                    RemoveOrder();
                }else if(inputAddPIZZA.toLowerCase().equals("vis")){
                    ShowOrders();
                }else if (inputAddPIZZA.toLowerCase().equals("ny")){
                    CreateOrder();
                }else if (inputAddPIZZA.toLowerCase().equals("vis menu")){
                    showMenu();
                }
            } catch (Exception e) {
                System.out.println("Noget gik galt ved tilføjelse af den nye pizza");
                System.out.println(e);
            }

        }
    }

    public void RemoveOrder() {
        ArrayList<String> OrderTestArr = new ArrayList<>();
        String input1;
        String input2;
        int IndexGetter;
        try {
            Connection conn = DriverManager.getConnection(url,user,password);
            Statement st = conn.createStatement();
            Statement st2 = conn.createStatement();

            String query = "SELECT * FROM orders";
            String query2 = "SELECT * FROM orders";

            ResultSet rs = st.executeQuery(query);
            ResultSet rs2 = st2.executeQuery(query2);

            Scanner sc = new Scanner(System.in);


            while (this.doneBoo==false) {
                System.out.println("Hvilken bestilling vil du fjerne? :D");
                System.out.println("Her er en liste af alle vores ordre");
                while (rs.next()) {
                    IndexGetter = rs.getInt(2);
                    System.out.println("Telefonnummer: " + IndexGetter);
                    OrderTestArr.add(String.valueOf(IndexGetter));
                }
                while (rs2.next()) {
                    input1 = sc.nextLine();
                    if (input1.toLowerCase().equals(OrderTestArr.get(OrderTestArr.indexOf(input1)))) {
                        int PhoneNumberToREMOVE = Integer.parseInt(input1);
                        String tmpPizzaName = rs2.getString(3);
                        PreparedStatement PreSt = conn.prepareStatement("DELETE FROM Orders WHERE PhoneNumber = ?");
                        PreSt.setInt(1, PhoneNumberToREMOVE);
                        System.out.println("DU HAR SLETTET BESTILLINGEN FRA " + "TELEFONNUMMER: " + PhoneNumberToREMOVE + " Pizza/Pizzaer:" + tmpPizzaName);
                        PreSt.executeUpdate();
                        System.out.println("Hvis du vil fjerne endnu en ordre, så tast: fjern");
                        System.out.println("For at se alle bestillinger tast: vis");
                        System.out.println("For at lave en ny bestilling tast: ny");
                        System.out.println("Hvis du vil se menuen tast: vis menu");
                        System.out.println("Ellers tast afslut for at stoppe programmet");
                        input2 = sc.nextLine();
                        if (input2.toLowerCase().equals("afslut")){
                            conn.close();
                            this.doneBoo = true;
                        }else if(input2.toLowerCase().equals("fjern")){
                            RemoveOrder();
                        }else if(input2.toLowerCase().equals("vis")){
                            ShowOrders();
                        }else if (input2.toLowerCase().equals("ny")){
                            CreateOrder();
                        }else if (input2.toLowerCase().equals("vis menu")){
                            showMenu();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Det er sket en fejl - kontakt administrator");
            System.out.println(e);
        }
    }

    public void CreateOrder() {
        String[] inputBestil;
        int inputPickupMin;
        int inputPickupSec;
        int inputPhone;
        ArrayList<Integer> OrderIndexTest = new ArrayList<>();
        ArrayList<Pizza> OrderPizzaTestArr = new ArrayList<>();
        String input2;
        Scanner sc = new Scanner(System.in);
        while (this.doneBoo == false) {
            try {
                System.out.println("Hvilken/Hvilke Pizza/Pizzaer er bestilt?");
                System.out.println("Indtast indeks af pizza/pizzaerne med komma efter hvert nyt indeks");
                for (Pizza p : this.Pizzaer) {
                    System.out.format("%s, %s, %s, %s,\n", this.Pizzaer.indexOf(p), p.name, p.Ingredients, p.price);
                }
                inputBestil = this.sc1.nextLine().split(",");

                for (String s : inputBestil) {
                    OrderIndexTest.add(Integer.parseInt(s));
                }
                for (Integer i : OrderIndexTest) {
                    OrderPizzaTestArr.add(this.Pizzaer.get(i));
                }

                System.out.println(OrderIndexTest);
                System.out.println("Hvad er nummeret?" + "\n" + "Hvis der ikke er noget nummer, så giv den et 1-cifret tal :)");

                inputPhone = this.sc1.nextInt();
                System.out.println("Hvor mange minutter til afhentning?");

                inputPickupMin = this.sc1.nextInt();
                System.out.println("Hvor mange sekunder?");
                inputPickupSec = this.sc1.nextInt();


                Order o = new Order(inputPhone, inputPickupMin, inputPickupSec, OrderPizzaTestArr);
                System.out.println("Du har lavet en ordre for telefonnummer: " + inputPhone);
                System.out.println("Hvis du vil lave endnu en bestilling tast: ny");
                System.out.println("Hvis du vil fjerne en bestilling tast: fjern");
                System.out.println("Hvis du vil se alle bestillinger tast: vis");
                System.out.println("Hvis du vil se menuen tast: vis menu");
                System.out.println("Hvis du vil afslutte programmet tast: afslut");
                input2 = sc.nextLine();
                if (input2.toLowerCase().equals("vis")) {
                    ShowOrders();
                } else if (input2.toLowerCase().equals("ny")) {
                    CreateOrder();
                } else if (input2.toLowerCase().equals("fjern")) {
                    RemoveOrder();
                } else if (input2.toLowerCase().equals("vis menu")) {
                    showMenu();
                }else if (input2.toLowerCase().equals("afslut")) {
                    this.doneBoo = true;
                }

            } catch (Exception e) {
                System.out.println("Noget er gået galt med bestillingen :/ - kontakt administrator");
                System.out.println(e);
            }
        }
    }

    public void ShowOrders(){
        int OrderID;
        int PhoneNumber;
        String PizzaNames;
        int OrderPrice;
        Timestamp pickupTime;
        String input2;
        Scanner sc = new Scanner(System.in);
        while(this.doneBoo == false){
            try{
                Connection conn = DriverManager.getConnection(url,user,password);
                Statement st3 = conn.createStatement();
                String query3 = "SELECT * FROM orders";
                ResultSet rs3 = st3.executeQuery(query3);
                while(rs3.next()){
                    OrderID = rs3.getInt("OrderID");
                    PhoneNumber = rs3.getInt("PhoneNumber");
                    PizzaNames = rs3.getString("Pizza");
                    OrderPrice = rs3.getInt("PizzaPrice");
                    pickupTime = rs3.getTimestamp("PickupTime");
                    System.out.format("%s, %s, %s, %s,%s,\n",OrderID,PhoneNumber,PizzaNames,OrderPrice,pickupTime);
                }
                System.out.println("Hvis du vil lave en bestilling tast: ny");
                System.out.println("Hvis du vil fjerne en bestilling tast: fjern");
                System.out.println("Hvis du vil se alle bestillinger igen tast: vis");
                System.out.println("Hvis du vil se menuen tast: vis menu");
                System.out.println("Ellers tast afslut for at stoppe programmet");
                input2 = sc.nextLine();
                if (input2.toLowerCase().equals("afslut")) {
                    this.doneBoo = true;
                }else if(input2.toLowerCase().equals("fjern")){
                    RemoveOrder();
                }else if(input2.toLowerCase().equals("vis")){
                    ShowOrders();
                }else if (input2.toLowerCase().equals("ny")){
                    CreateOrder();
                }else if (input2.toLowerCase().equals("vis menu")){
                    showMenu();
                }
            } catch(Exception e){
                System.out.println("Noget er gået galt med præsentation - hvor pinligt! :O");
                System.out.println(e);
            }
        }
    }

    public void showMenu() {
        int PizzaId1;
        String PizzaName1;
        String PizzaIngredients1;
        int PizzaPrice1;
        String inputMenu;
        while (this.doneBoo == false) {
            try {
                Connection conn = DriverManager.getConnection(url,user,password);
                Statement st = conn.createStatement();
                String query = "SELECT * FROM menu";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    PizzaId1 = rs.getInt("PizzaID");
                    PizzaName1 = rs.getString("PizzaName");
                    PizzaIngredients1 = rs.getString("PizzaIngredients");
                    PizzaPrice1 = rs.getInt("PizzaPrice");
                    System.out.format("%s, %s, %s, %s,\n", PizzaId1, PizzaName1, PizzaIngredients1, PizzaPrice1);
                }
                System.out.println("Hvis du vil lave en bestilling tast: ny");
                System.out.println("Hvis du vil fjerne en bestilling tast: fjern");
                System.out.println("Hvis du vil se alle bestillinger igen tast: vis");
                System.out.println("Hvis du vil se menuen tast: vis menu");
                System.out.println("Ellers tast afslut for at stoppe programmet");
                inputMenu = this.sc1.nextLine();
                if (inputMenu.toLowerCase().equals("afslut")) {
                    this.doneBoo = true;
                }else if(inputMenu.toLowerCase().equals("fjern")){
                    RemoveOrder();
                }else if(inputMenu.toLowerCase().equals("vis")){
                    ShowOrders();
                }else if (inputMenu.toLowerCase().equals("ny")){
                    CreateOrder();
                }else if (inputMenu.toLowerCase().equals("vis menu")){
                    showMenu();
                }
                    conn.close();
            } catch (Exception e) {
                System.out.println("Noget gik galt med menuen :/");
                System.out.println(e);

            }
        }
    }
    @Override
    public String toString() {
        return Pizzaer.toString();
    }
}
