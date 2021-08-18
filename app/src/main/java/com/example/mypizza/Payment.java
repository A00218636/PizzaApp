package com.example.mypizza;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Payment extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);

        final Button cartButton =  (Button) findViewById(R.id.buttonOk);
        cartButton.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v){
                openPaymentActivity();
            }
        });
    }

    public static final String TABLE_NAME = "CartList_table";

    private void openPaymentActivity() {

        DatabaseHelper db = new DatabaseHelper(this);
        db.deleteData();

        Intent intent = new Intent(this,
                MainActivity.class);
        startActivity(intent);
    }


//    public void ReturnToMain(View view) {
//
//        Intent intent = new Intent(this, MainActivity.class);
//
//        startActivity(intent);
//    }
}
