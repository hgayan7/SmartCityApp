package com.aidev.him.smartcity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.aidev.him.smartcity.model.Channel;
import com.aidev.him.smartcity.model.Drain;
import com.aidev.him.smartcity.model.Example;
import com.aidev.him.smartcity.model.Feed;
import com.aidev.him.smartcity.rest.ApiClient;
import com.aidev.him.smartcity.rest.ApiClient2;
import com.aidev.him.smartcity.rest.ApiInterface;
import com.aidev.him.smartcity.rest.ApiInterface2;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WasteActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView wasteHeight,wasteStatus;
    CardView wasteCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_waste);

        progressBar  = findViewById(R.id.simpleProgressBar3);
        wasteHeight = findViewById(R.id.wasteHeight);
        wasteStatus =findViewById(R.id.wasteStatus);
        wasteCard=findViewById(R.id.wasteCard);

        final ApiInterface2 apiService2= ApiClient2.getClient().create(ApiInterface2.class);

        Call<Example> call =apiService2.getExamples();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.d("Result", response.body().getFeeds().get(0).getField1());
                wasteCard.setVisibility(View.VISIBLE);
                wasteHeight.setText(response.body().getFeeds().get(0).getField1()+ " cm");
                int height = Integer.parseInt(response.body().getFeeds().get(0).getField1());
                if(height<5&&height>3){
                    wasteStatus.setText("Half filled");
                }else if(height<=3){
                    wasteStatus.setText("Almost filled");
                }else{
                    wasteStatus.setText("Empty");
                }

                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }
}
