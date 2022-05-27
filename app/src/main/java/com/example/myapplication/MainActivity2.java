package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Callback;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.myapplication.R.layout.activity_main2);
        android.widget.EditText edt = findViewById(com.example.myapplication.R.id.City);
        edt.setText(getIntent().getExtras().get("Key").toString());
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")//базовая часть адреса
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())//конвертер
                .build();
        com.example.myapplication.WeatherOneDayApiService weatherOneDayApi;
        weatherOneDayApi=retrofit.create(com.example.myapplication.WeatherOneDayApiService.class);//создали объект, с его помощью будем отправлять запросыN
        weatherOneDayApi.getWeatherByCityName("Kiev,ua","5a185bebc490568bc569eb2c3ef1236d").
                enqueue (new Callback<Example>() {
                    @Override
                    public void onResponse(retrofit2.Call<com.example.myapplication.Example> call, retrofit2.Response<com.example.myapplication.Example> response) {
                        if (response.isSuccessful()) {
                            android.util.Log.i("Jane", response.body().getWind().getSpeed().toString());
                            android.widget.EditText edt1 = findViewById(com.example.myapplication.R.id.wind);
                            edt1.setText(response.body().getWind().getSpeed().toString());
                            android.widget.EditText edt2 = findViewById(com.example.myapplication.R.id.temp);
                            edt2.setText(response.body().getMain().getTemp().toString());
                            android.util.Log.i("Jane", "OK");
                        } else android.util.Log.i("Jane", "no reponse");
                    }
                    @Override
                    public void onFailure(retrofit2.Call<com.example.myapplication.Example> call, Throwable t) {
                        android.util.Log.i("Jane","Failure "+t);
                    }
                });

    }



}

