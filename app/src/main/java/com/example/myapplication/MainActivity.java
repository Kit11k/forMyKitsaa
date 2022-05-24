package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i(tag: "MainActivity1", msg "OnCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://x-colors.herokuapp.com")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        MessageAPI messageAPI=retrofit.create(MessageAPI.class);
        Call<String> message=messageAPI.message();
        message.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Jane",""+response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("Jane","Failure"+t);
            }
        });
    }
        







    }
    public interface MessageAPI{
        @GET("https://x-colors.herokuapp.com/api/random")
        Call<String> message();
    }

}