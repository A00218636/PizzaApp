package com.example.mypizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    String pizzaName = "";
    int pizzaCount = 0;
    Double price=0.00;
    Double tax = 13.33;
    Double totalPrice = 0.00;
    Double netAmount =0.00;
//
//    List<Pizza> pizList  = new ArrayList<>();
    //1 argument constructor
    Pizza(String pizzaName)
    {
        //this.pizzaCount=count;
        this.pizzaName=pizzaName;
        if(pizzaName.equals("veggies"))
        {
            this.price = 15.40;

            this.totalPrice = this.price + (tax/100)*this.price;

            Double count = (double) this.pizzaCount;
            this.netAmount = this.totalPrice * (count);
        }
        if(pizzaName.equals("Mushroom"))
        {
            this.price = 17.40;
            this.totalPrice = this.price + (tax/100)*this.price;

            Double count = (double) this.pizzaCount;
            this.netAmount = this.totalPrice * (count);
        }

        if(pizzaName.equals("Farmhouse"))
        {
            this.price = 18.40;
            this.totalPrice = this.price + (tax/100)*this.price;

            Double count = (double) this.pizzaCount;
            this.netAmount = this.totalPrice * (count);
        }
        if(pizzaName.equals("pepperoni"))
        {
            this.price = 14.40;
            this.totalPrice = this.price + (tax/100)*this.price;
            Double count = (double) this.pizzaCount;
            this.netAmount = this.totalPrice * (count);
        }
        if(pizzaName.equals("hawaiian"))
        {
            this.price = 19.40;
            this.totalPrice = this.price + (tax/100)*this.price;
            Double count = (double) this.pizzaCount;
            this.netAmount = this.totalPrice * (count);
        }

    }

    public Pizza() {

    }
}
