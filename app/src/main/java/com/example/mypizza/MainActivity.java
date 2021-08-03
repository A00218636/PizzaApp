package com.example.mypizza;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    ImageView myImage;
    int i=0;

    Pizza veggies = new Pizza(0,"veggies");
    Pizza pepperoni = new Pizza(0,"pepperoni");
    Pizza hawaiian = new Pizza(0,"hawaiian");
    Pizza pizza1 = new Pizza(0,"pizza1");
    Pizza pizza2 = new Pizza(0,"pizza2");






    @Override
    protected void onCreate(Bundle savedInstanceState) {


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
        //pizzaName.setText(pizza1.pizzaName);



        btprevious.setOnClickListener(this);
        btnext.setOnClickListener(this);




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
        }
    }
    private void changePizzaImg() {

        myImage = (ImageView) findViewById(R.id.img);
        EditText editText = findViewById(R.id.PizzaCount);
        TextView pizzaName = findViewById(R.id.pizzaName);



        switch(i)
        {

            case 0:
                myImage.setImageResource(R.drawable.pizza1);
                editText.setText(String.valueOf(pizza1.pizzaCount));
                pizzaName.setText(pizza1.pizzaName);

                break;

            case 1:
                myImage.setImageResource(R.drawable.pizza2);
                editText.setText(String.valueOf(pizza2.pizzaCount));
                pizzaName.setText(pizza2.pizzaName);

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
                pizza1.pizzaCount = pizza1.pizzaCount + 1;
                editText.setText(String.valueOf(pizza1.pizzaCount));

                break;

            case 1:
                pizza2.pizzaCount = pizza2.pizzaCount + 1;
                editText.setText(String.valueOf(pizza2.pizzaCount));
                break;

            case 2:
                hawaiian.pizzaCount = hawaiian.pizzaCount + 1;
                editText.setText(String.valueOf(hawaiian.pizzaCount));
                break;
            case 3:
                pepperoni.pizzaCount = pepperoni.pizzaCount + 1;
                editText.setText(String.valueOf(pepperoni.pizzaCount));
                break;
            case 4:
                veggies.pizzaCount = veggies.pizzaCount + 1;
                editText.setText(String.valueOf(veggies.pizzaCount));
                break;
        }



    }

    public void decCount(View view) {
        EditText editText = findViewById(R.id.PizzaCount);
        switch(i) {

            case 0:
                pizza1.pizzaCount = pizza1.pizzaCount -1;
                editText.setText(String.valueOf(pizza1.pizzaCount));

                break;

            case 1:
                pizza2.pizzaCount = pizza2.pizzaCount - 1;
                editText.setText(String.valueOf(pizza2.pizzaCount));
                break;

            case 2:
                hawaiian.pizzaCount = hawaiian.pizzaCount - 1;
                editText.setText(String.valueOf(hawaiian.pizzaCount));
                break;
            case 3:
                pepperoni.pizzaCount = pepperoni.pizzaCount - 1;
                editText.setText(String.valueOf(pepperoni.pizzaCount));
                break;
            case 4:
                veggies.pizzaCount = veggies.pizzaCount - 1;
                editText.setText(String.valueOf(veggies.pizzaCount));
                break;
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