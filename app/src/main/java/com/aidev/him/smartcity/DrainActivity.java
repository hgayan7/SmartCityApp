package com.aidev.him.smartcity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aidev.him.smartcity.model.Drain;
import com.aidev.him.smartcity.rest.ApiClient;
import com.aidev.him.smartcity.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DrainActivity extends AppCompatActivity {

    TextView id,clogging,gas;
    ProgressBar progressBar;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_drain);

        id= findViewById(R.id.drainID);
        clogging = findViewById(R.id.cloggingText);
        gas = findViewById(R.id.gasText);
        progressBar =findViewById(R.id.simpleProgressBar);
        cardView=findViewById(R.id.drainCard);
        progressBar.setVisibility(View.VISIBLE);

        final ApiInterface apiService= ApiClient.getClient().create(ApiInterface.class);

        Call<List<Drain>> call =apiService.getDrains();
        call.enqueue(new Callback<List<Drain>>() {
            @Override
            public void onResponse(Call<List<Drain>> call, Response<List<Drain>> response) {
                id.setText(response.body().get(0).getId().toString());
                clogging.setText(response.body().get(0).getClogging().toString());
                gas.setText(response.body().get(0).getGas().toString());
                progressBar.setVisibility(View.GONE);
                cardView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<List<Drain>> call, Throwable t) {

            }
        });
    }
}
