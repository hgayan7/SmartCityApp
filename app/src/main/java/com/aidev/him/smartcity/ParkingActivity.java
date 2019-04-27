package com.aidev.him.smartcity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.aidev.him.smartcity.model.Parking;
import com.aidev.him.smartcity.rest.ApiClient;
import com.aidev.him.smartcity.rest.ApiInterface;

import java.sql.ResultSet;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ParkingActivity extends AppCompatActivity {

    private static final String TAG=ParkingActivity.class.getSimpleName();

    ProgressBar progressBar;
    CardView card1,card2,card3,card4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_parking);
        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        card3=findViewById(R.id.card3);
        card4=findViewById(R.id.card4);
        progressBar=findViewById(R.id.simpleProgressBar2);
        progressBar.setVisibility(View.VISIBLE);
        final ApiInterface apiService= ApiClient.getClient().create(ApiInterface.class);

        Call<List<Parking>> call=apiService.getParkings();

        call.enqueue(new Callback<List<Parking>>() {
            @Override
            public void onResponse(Call<List<Parking>> call, Response<List<Parking>> response) {

                for(int i=0;i<4;i++){
                    if((response.body().get(i).getId() == 1)&&(response.body().get(i).getAvailable())){
                        card1.setVisibility(View.VISIBLE);
                        card1.setCardBackgroundColor(Color.GREEN);}


                    if((response.body().get(i).getId() == 2)&&(response.body().get(i).getAvailable())){
                        card2.setVisibility(View.VISIBLE);
                        card2.setCardBackgroundColor(Color.GREEN);}


                    if((response.body().get(i).getId() == 3)&&(response.body().get(i).getAvailable())){
                        card2.setVisibility(View.VISIBLE);
                        card3.setCardBackgroundColor(Color.GREEN);}


                    if((response.body().get(i).getId() == 4)&&(response.body().get(i).getAvailable())){
                        card2.setVisibility(View.VISIBLE);
                        card4.setCardBackgroundColor(Color.GREEN);}



                }
                card1.setVisibility(View.VISIBLE);
                card2.setVisibility(View.VISIBLE);
                card3.setVisibility(View.VISIBLE);
                card4.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<List<Parking>> call, Throwable t) {

            }
        });
    }
}
