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
        WeatherOneDayApiService WeatherOneDayApi;
        WeatherOneDayApi=retrofit.create(WeatherOneDayApiService.class);//создали объект, с его помощью будем отправлять запросыN
        WeatherOneDayApi.getWeatherByCityName(getText().toString(),"3d822b9dce4e57f12b9b3400d480a358").
                enqueue(new Callback<Example>() {//aссинхронный вызов (для синхронного был бы метод execute() )
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