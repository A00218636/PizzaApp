package com.example.mypizza;

public class CartModel {

    String pizzaName;
    int pizCount;
    double price;
    double netAmount;
    String delBy;

    public CartModel(String pizzaName, int pizCount, double price, double netAmount, String delBy) {
        this.delBy = delBy;
        this.netAmount = netAmount;
        this.pizCount = pizCount;
        this.pizzaName = pizzaName;
        this.price = price;
    }



    public String getDeliveredBy() {
        return delBy;
    }

    public double getAmount() {
        return netAmount;
    }

    public String getName() {
        return pizzaName;
    }
}
