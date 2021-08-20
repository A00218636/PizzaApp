package com.example.mypizza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {



    ImageView myImage;
    int i=0;

    //Objects are created as soon as app starts bu member variables are not assigned any count.
    Pizza veggies = new Pizza("veggies");
    Pizza pepperoni = new Pizza("pepperoni");
    Pizza hawaiian = new Pizza("hawaiian");
    Pizza farmhouse = new Pizza("Farmhouse");
    Pizza mushroom = new Pizza("Mushroom");



    int pizzaCount=0;
    List<Pizza> pizList  = new ArrayList<>();


    String[] pizzaType = { "veggies", "pepperoni",
            "hawaiian", "Farmhouse",
            "Tandoori Paneer" };



    DatabaseHelper myDb;





    @Override
    protected void onCreate(Bundle savedInstanceState) {


        myDb = new DatabaseHelper(this);
        TextView pizzaName = findViewById(R.id.pizzaName);



        Button btprevious, btnext;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //NavigationUI.setupWithNavController(navView, navController);

        btprevious = (Button) findViewById(R.id.btnPreviousImage);
        btnext = (Button) findViewById(R.id.btnNextImage);
        myImage = (ImageView) findViewById(R.id.img);
        ImageButton cartBtn =  findViewById(R.id.imageButton);
        Button addTtoCart = findViewById(R.id.btnAddToCart);
        //pizzaName.setText(pizza1.pizzaName);



        btprevious.setOnClickListener(this);
        btnext.setOnClickListener(this);
        cartBtn.setOnClickListener(this);
        addTtoCart.setOnClickListener(this);

        changePizzaImg();



        // Take the instance of Spinner and
        // apply OnItemSelectedListener on it which
        // tells which item of spinner is clicked
        Spinner spin = findViewById(R.id.pizzaSpinner);
        spin.setOnItemSelectedListener(this);

        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                pizzaType);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spin.setAdapter(ad);







    }



    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnNextImage:
                i++;

                if(i==5) // switch to 11 because you got 10 images
                {
                    i=1; // switch to 10, same reason
                }

                changePizzaImg();
                break;

            case R.id.btnPreviousImage:
                i--;

                if(i==-1)
                {
                    i=0; // you can leave it this way or improve it later
                }

                changePizzaImg();
                break;

            case R.id.imageButton:
                Intent intent = new Intent(this,
                        Cart.class);
                startActivity(intent);
                break;

            case R.id.btnAddToCart:
                addToCart();
                break;

        }
    }
    private void changePizzaImg() {

        myImage = (ImageView) findViewById(R.id.img);
        EditText editText = findViewById(R.id.PizzaCount);
        TextView pizzaName = findViewById(R.id.pizzaName);



        switch(i)
        {

            case 0:
                myImage.setImageResource(R.drawable.farmhouse);
                editText.setText(String.valueOf(farmhouse.pizzaCount));
                pizzaName.setText(farmhouse.pizzaName);

                break;

            case 1:
                myImage.setImageResource(R.drawable.mushroom);
                editText.setText(String.valueOf(mushroom.pizzaCount));
                pizzaName.setText(mushroom.pizzaName);

                break;

            case 2:
                myImage.setImageResource(R.drawable.hawaiianpizza);
                editText.setText(String.valueOf(hawaiian.pizzaCount));
                pizzaName.setText(hawaiian.pizzaName);

                break;
            case 3:
                myImage.setImageResource(R.drawable.pepperonipizza);
                editText.setText(String.valueOf(pepperoni.pizzaCount));
                pizzaName.setText(pepperoni.pizzaName);

                break;
            case 4:
                myImage.setImageResource(R.drawable.veggiespizza);
                editText.setText(String.valueOf(veggies.pizzaCount));
                pizzaName.setText(veggies.pizzaName);

                break;
// and then it goes further
        }
    }


    public void incCount(View view) {

        EditText editText = findViewById(R.id.PizzaCount);


        //Fetch the pizza type on image view currently
        switch(i) {

            case 0:
                //Create an instance of pizza and increase the member variable by 1

                farmhouse.pizzaCount = farmhouse.pizzaCount + 1;
                //Double count = (double) this.pizzaCount;
               // mushroom.netAmount = mushroom.totalPrice * (count);
                farmhouse.netAmount = farmhouse.totalPrice * (farmhouse.pizzaCount);
                BigDecimal bdUp=new BigDecimal(farmhouse.netAmount).setScale(2, RoundingMode.UP);
                farmhouse.netAmount = bdUp.doubleValue();

                editText.setText(String.valueOf(farmhouse.pizzaCount));
                //ADD TO THE CART LIST WHICH ALREADY CONTAINS OTHER PIZZAS TOO




                break;

            case 1:
                mushroom.pizzaCount = mushroom.pizzaCount + 1;
//                Double count = (double) this.pizzaCount;
//                mushroom.netAmount = mushroom.totalPrice * (count);
                mushroom.netAmount = mushroom.totalPrice * (mushroom.pizzaCount);
                BigDecimal bdUpmush=new BigDecimal(mushroom.netAmount).setScale(2, RoundingMode.UP);
                mushroom.netAmount = bdUpmush.doubleValue();

                editText.setText(String.valueOf(mushroom.pizzaCount));
                break;

            case 2:
                hawaiian.pizzaCount = hawaiian.pizzaCount + 1;
//                Double count = (double) this.pizzaCount;
//                mushroom.netAmount = mushroom.totalPrice * (count);
                hawaiian.netAmount = hawaiian.totalPrice * (hawaiian.pizzaCount);
                BigDecimal bdUphawai=new BigDecimal(hawaiian.netAmount).setScale(2, RoundingMode.UP);
                hawaiian.netAmount = bdUphawai.doubleValue();

                editText.setText(String.valueOf(hawaiian.pizzaCount));
                break;
            case 3:
                pepperoni.pizzaCount = pepperoni.pizzaCount + 1;
//                Double count = (double) this.pizzaCount;
//                mushroom.netAmount = mushroom.totalPrice * (count);
                pepperoni.netAmount = pepperoni.totalPrice * pepperoni.pizzaCount;
                BigDecimal bdUpPep=new BigDecimal(pepperoni.netAmount).setScale(2, RoundingMode.UP);
                pepperoni.netAmount = bdUpPep.doubleValue();

                editText.setText(String.valueOf(pepperoni.pizzaCount));
                break;
            case 4:
                veggies.pizzaCount = veggies.pizzaCount + 1;
//                Double count = (double) this.pizzaCount;
//                mushroom.netAmount = mushroom.totalPrice * (count);
                veggies.netAmount = veggies.totalPrice * veggies.pizzaCount;
                BigDecimal bdUpVeg=new BigDecimal(veggies.netAmount).setScale(2, RoundingMode.UP);
                veggies.netAmount = bdUpVeg.doubleValue();

                editText.setText(String.valueOf(veggies.pizzaCount));
                break;
        }



    }

    public void decCount(View view) {
        EditText editText = findViewById(R.id.PizzaCount);
        switch(i) {

            case 0:
                farmhouse.pizzaCount = farmhouse.pizzaCount -1;
                //Double count = (double) this.pizzaCount;
                farmhouse.netAmount = farmhouse.totalPrice * (farmhouse.pizzaCount);
                BigDecimal bdUp=new BigDecimal(farmhouse.netAmount).setScale(2, RoundingMode.UP);
                farmhouse.netAmount = bdUp.doubleValue();
                editText.setText(String.valueOf(farmhouse.pizzaCount));

                break;

            case 1:
                mushroom.pizzaCount = mushroom.pizzaCount - 1;
                //Double count = (double) this.pizzaCount;
                mushroom.netAmount = mushroom.totalPrice * (mushroom.pizzaCount);
                BigDecimal bdUpmush=new BigDecimal(mushroom.netAmount).setScale(2, RoundingMode.UP);
                mushroom.netAmount = bdUpmush.doubleValue();
                editText.setText(String.valueOf(mushroom.pizzaCount));
                break;

            case 2:
                hawaiian.pizzaCount = hawaiian.pizzaCount - 1;
                //Double count = (double) this.pizzaCount;
                hawaiian.netAmount = hawaiian.totalPrice * (hawaiian.pizzaCount);
                BigDecimal bdUphawai=new BigDecimal(hawaiian.netAmount).setScale(2, RoundingMode.UP);
                hawaiian.netAmount = bdUphawai.doubleValue();

                editText.setText(String.valueOf(hawaiian.pizzaCount));
                break;
            case 3:
                pepperoni.pizzaCount = pepperoni.pizzaCount - 1;
                //Double count = (double) this.pizzaCount;
                pepperoni.netAmount = pepperoni.totalPrice * pepperoni.pizzaCount;
                BigDecimal bdUpPep=new BigDecimal(pepperoni.netAmount).setScale(2, RoundingMode.UP);
                pepperoni.netAmount = bdUpPep.doubleValue();
                editText.setText(String.valueOf(pepperoni.pizzaCount));
                break;
            case 4:
                veggies.pizzaCount = veggies.pizzaCount - 1;
                //Double count = (double) this.pizzaCount;
                veggies.netAmount = veggies.totalPrice * veggies.pizzaCount;
                BigDecimal bdUpVeg=new BigDecimal(veggies.netAmount).setScale(2, RoundingMode.UP);
                veggies.netAmount = bdUpVeg.doubleValue();
                editText.setText(String.valueOf(veggies.pizzaCount));
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        // make toastof name of course
        // which is selected in spinner
        Toast.makeText(getApplicationContext(),
                pizzaType[position],
                Toast.LENGTH_LONG)
                .show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void addToCart() {
        EditText editText = findViewById(R.id.PizzaCount);
        //Check if any pizza have count greater than 0
        if(veggies.pizzaCount>0)
        {
            boolean isInserted = myDb.insertData(veggies.pizzaName, veggies.pizzaCount, veggies.price, veggies.tax,
                    veggies.totalPrice, veggies.netAmount);
                    if(isInserted){
                        Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
                    }

        }
        if(pepperoni.pizzaCount>0)
        {
            boolean isInserted = myDb.insertData(pepperoni.pizzaName, pepperoni.pizzaCount, pepperoni.price, pepperoni.tax,
                    pepperoni.totalPrice, pepperoni.netAmount);
            if(isInserted){
                Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
            }

        }
        if(hawaiian.pizzaCount>0)
        {
            boolean isInserted = myDb.insertData(hawaiian.pizzaName, hawaiian.pizzaCount, hawaiian.price, hawaiian.tax,
                    hawaiian.totalPrice, hawaiian.netAmount);
            if(isInserted){
                Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
            }

        }
        if(farmhouse.pizzaCount>0)
        {
            boolean isInserted = myDb.insertData(farmhouse.pizzaName, farmhouse.pizzaCount, farmhouse.price, farmhouse.tax,
                    farmhouse.totalPrice, farmhouse.netAmount);
            if(isInserted){
                Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
            }

        }
        if(mushroom.pizzaCount>0)
        {
            boolean isInserted = myDb.insertData(mushroom.pizzaName, mushroom.pizzaCount, mushroom.price, mushroom.tax,
                    mushroom.totalPrice, mushroom.netAmount);
            if(isInserted){
                Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
            }

        }

    }


//    public void GoToCart(View view) {
//
//        Intent intent = new Intent(this, Cart.class);
//        //EditText editText = (EditText) findViewById(R.id.edit_message);
//       // String message = editText.getText().toString();
//        //intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
//    }
}