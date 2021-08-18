package com.example.mypizza;

public class CartModel {

    String pizzaName;
    int pizCount;
    double price;
    double tax;
    double totalPrice;
    double netAmount;
    String delBy;

    public CartModel(String pizzaName, int pizCount, double price,double tax, double totalPrice, double netAmount, String delBy) {
        this.delBy = delBy;
        this.netAmount = netAmount;
        this.tax = tax;
        this.totalPrice = totalPrice;
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
