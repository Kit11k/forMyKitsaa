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

        Log.i("MainActivity1", "OnCreate");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")
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

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "OnStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity", "OnRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "OnResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity", "OnDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity", "OnStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity", "OnPause");
    }


}
/*public interface MessageAPI{
        @GET("http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=5a185bebc490568bc569eb2c3ef1236d")
        Call<String> message();
}*/

