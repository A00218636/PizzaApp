package com.example.mypizza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import kotlin.OverloadResolutionByLambdaReturnType;

public class Cart extends AppCompatActivity {

    RecyclerView recycler_view;
    CartAdapter adapter;

    String pizzaName;
    int pizCount;
    double price;
    double netAmount;
    String delBy;


    List<CartModel> cart_list = new ArrayList<>();

    DatabaseHelper myDb = new DatabaseHelper(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recycler_view = findViewById(R.id.recycler_view);
        setRecyclerView();

       final Button cartButton =  (Button) findViewById(R.id.paymentBtn);
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


//        cart_list.add(new CartModel("Farmhouse",2,20,22,"John"));
//        cart_list.add(new CartModel("Pepperoni",2,20,22,"Peter"));
//        cart_list.add(new CartModel("Margherita",2,20,22,"Nathan"));

//        List<Pizza> pizzaList = new ArrayList<>();
//        Pizza obj = new Pizza();

        return  cart_list;

    }

//    public void redirectToPaymentView(View view) {
//        Intent intent = new Intent(this,
//                Payment.class);
//
//        startActivity(intent);
//    }

//    public void init(){
//        TableLayout ll = findViewById(R.id.displayLinear);
//
//
//        for (int i = 0; i <5; i++) {
//
//            TableRow row= new TableRow(this);
//            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
//            row.setLayoutParams(lp);
//            CheckBox checkBox = new CheckBox(this);
//            TextView tv = new TextView(this);
////           ImageButton addBtn = new ImageButton(this);
////            addBtn.setImageResource(R.drawable.add);
////            ImageButton minusBtn = new ImageButton(this);
////            minusBtn.setImageResource(R.drawable.minus);
//           TextView qty = new TextView(this);
//
//            qty.setText("10");
//            row.addView(checkBox);
//            //row.addView(minusBtn);
//            row.addView(qty);
//            //row.addView(addBtn);
//            ll.addView(row,i);
//        }
//    }

//    public int getDeiliveredBy() {
//    }
//
//    public int getAmount() {
//    }
//
//    public int getName() {
//    }
}