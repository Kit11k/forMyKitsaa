package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MessageAPI{
    @GET("http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=5a185bebc490568bc569eb2c3ef1236d")
    Call<String> message();
}
