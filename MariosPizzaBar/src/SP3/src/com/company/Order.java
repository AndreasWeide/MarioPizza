package com.company;
import java.util.*;

public abstract class Order {
    double bestillingstidspunkt;
    int afhentingstidspunkt;

    public Order(double bestillingstidspunkt, int afhentingstidspunkt) {
        this.bestillingstidspunkt = bestillingstidspunkt;
        this.afhentingstidspunkt = afhentingstidspunkt;
    }
}
