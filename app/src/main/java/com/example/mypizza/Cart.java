package com.example.mypizza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {

    RecyclerView recycler_view;
    CartAdapter adapter;

    String pizzaName;
    int pizCount;
    double price;
    double netAmount;
    String delBy;



    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recycler_view = findViewById(R.id.recycler_view);
        setRecyclerView();
    }

    private void setRecyclerView() {
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CartAdapter(this, getList());
        recycler_view.setAdapter(adapter);
    }

    private List<CartModel> getList() {

        List<CartModel> cart_list = new ArrayList<>();
//        cart_list.add(new CartModel(pizzaName,pizCount,price,netAmount, delBy));
        cart_list.add(new CartModel("Farmhouse",2,20,22,"John"));
        cart_list.add(new CartModel("Pepperoni",2,20,22,"Peter"));
        cart_list.add(new CartModel("Margherita",2,20,22,"Nathan"));
        return  cart_list;

    }

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