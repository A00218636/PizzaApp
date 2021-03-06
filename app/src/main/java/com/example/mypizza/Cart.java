package com.example.mypizza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import kotlin.OverloadResolutionByLambdaReturnType;

public class Cart extends AppCompatActivity {

    RecyclerView recycler_view;
    CartAdapter adapter;
    DatabaseHelper myDb;

    String pizzaName;
    int pizCount;
    double price;
    double netAmount;
    String delBy;


    List<CartModel> cart_list = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        myDb = new DatabaseHelper(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recycler_view = findViewById(R.id.recycler_view);
        setRecyclerView();

       final Button cartButton =  (Button) findViewById(R.id.paymentBtn);
        final Button clrCartButton =  (Button) findViewById(R.id.clrCart);

        clrCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              myDb.deleteData();
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });
       cartButton.setOnClickListener(new View.OnClickListener(){
           @Override

           public void onClick(View v){
               openPaymentActivity();
           }
       });
    }

    private void openPaymentActivity() {
        Intent intent = new Intent(this,
                Payment.class);
        startActivity(intent);
    }

    private void setRecyclerView() {
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CartAdapter(this, getList());
        recycler_view.setAdapter(adapter);
    }




    private List<CartModel> getList() {

        //List<CartModel> cart_list = new ArrayList<>();
       Cursor res =  myDb.getAllData();
       if(res.getCount()>0){
           while (res.moveToNext()) {
               int count = Integer.parseInt(res.getString(2));
               Double price = res.getDouble(3);
               Double tax = res.getDouble(4);
               Double totalPrice = res.getDouble(5);
               Double netAmount = res.getDouble(6);


               cart_list.add(new CartModel(res.getString(1),count,price, tax, totalPrice, netAmount,"John"));
           }
       }



        return  cart_list;

    }
}