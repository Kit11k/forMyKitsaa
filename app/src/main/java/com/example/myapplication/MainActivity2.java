package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText edt = findViewById(R.id.City);
        edt.setText(getIntent().getExtras().get("Key").toString());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")//базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create())//конвертер
                .build();
        WeatherOneDayApiService weatherOneDayApi;
        weatherOneDayApi=retrofit.create(WeatherOneDayApiService.class);//создали объект, с его помощью будем отправлять запросыN
        weatherOneDayApi.getWeatherByCityName("Kiev,ua","5a185bebc490568bc569eb2c3ef1236d");
                enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        if (response.isSuccessful()) {
                            Log.i("Jane", response.body().getWind().getSpeed().toString());
                            EditText edt1 = findViewById(R.id.wind);
                            edt1.setText(response.body().getWind().getSpeed().toString());
                            EditText edt2 = findViewById(R.id.temp);
                            edt2.setText(response.body().getMain().getTemp().toString());
                            Log.i("Jane", "OK");
                        } else Log.i("Jane", "no reponse");
                    }
                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Log.i("Jane","Failure "+t);
                    }
                });

    }

    }

