package com.aidev.him.smartcity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_main);
    }

    public void goDrain(View v){
        Intent i = new Intent(MainActivity.this,DrainActivity.class);
        startActivity(i);
    }

    public void goParking(View v){
        Intent i =new Intent(this,ParkingActivity.class);
        startActivity(i);
    }

    public void goWaste(View v){
        Intent i =new Intent(this,WasteActivity.class);
        startActivity(i);
    }
}
