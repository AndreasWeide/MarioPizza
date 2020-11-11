package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalTime;
import java.time.LocalDate;

/**
 * @author Jaan
 */
public class KeyListenerEx extends Frame implements KeyListener {
    Label l;
    TextArea area;
    KeyListenerEx() {
        l = new Label();
        l.setBounds(20, 50, 100, 20);
        area = new TextArea();
        area.setBounds(20, 80, 300, 300);
        area.addKeyListener(this);
        add(l);
        add(area);
        setSize(400, 400);
        setLayout(null);
        setVisible(true);
    }
    public void keyTyped(KeyEvent e){
        l.setText("New Order");
    }

    public void keyPressed(KeyEvent e){
        Menu menu = new Menu("Menu");
        l.setText("New Order");
        if (e.getKeyCode() == KeyEvent.VK_1) {
            System.out.println();
            System.out.println("Bestilling: " + menu.Pizzaer.get(0) + '\n' + "Dato og Tidspunkt: " + LocalDate.now() + " - " + LocalTime.now());
            System.out.println("Afhentes tid: " + LocalTime.from(LocalTime.now().plusHours(1)) + "\n");
        } else if (e.getKeyCode() == KeyEvent.VK_2) {
            System.out.println();
            System.out.println("Bestilling: " + menu.Pizzaer.get(1) + '\n' + "Dato og Tidspunkt: " + LocalDate.now() + " - " + LocalTime.now());
            System.out.println("Afhentes tid: " + LocalTime.from(LocalTime.now().plusHours(1)) + "\n");
        } else if (e.getKeyCode() == KeyEvent.VK_3) {
            System.out.println();
            System.out.println("Bestilling: " + menu.Pizzaer.get(2) + '\n' + "Dato og Tidspunkt: " + LocalDate.now() + " - " + LocalTime.now()) ;
            System.out.println("Afhentes tid: " + LocalTime.from(LocalTime.now().plusHours(1)) + "\n");
        } else if (e.getKeyCode() == KeyEvent.VK_4) {
            System.out.println();
            System.out.println("Bestilling: " + menu.Pizzaer.get(3) + '\n' + "Dato og Tidspunkt: " + LocalDate.now() + " - " + LocalTime.now());
            System.out.println("Afhentes tid: " + LocalTime.from(LocalTime.now().plusHours(1)) + "\n");
        } else if (e.getKeyCode() == KeyEvent.VK_5) {
            System.out.println();
            System.out.println("Bestilling: " + menu.Pizzaer.get(4) + '\n' + "Dato og Tidspunkt: " + LocalDate.now() + " - " + LocalTime.now());
            System.out.println("Afhentes tid: " + LocalTime.from(LocalTime.now().plusHours(1)) + "\n");
        } else {
            return;
        }
    }

    public void keyReleased(KeyEvent e){
        l.setText("Awaiting Order");
    }
}