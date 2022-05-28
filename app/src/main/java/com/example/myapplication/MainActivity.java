package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        Log.i("MainActivity1", "OnCreate");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        EditText edt;
        edt = findViewById(R.id.сity);
        Button but1 = findViewById(R.id.button1);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("Key", edt.getText().toString());
                startActivity(intent);
            }
        });
        MessageAPI messageAPI = retrofit.create(MessageAPI.class);
        Call<String> message = messageAPI.message();
        message.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Jane", "" + response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("Jane", "Failure" + t);
            }
        });


        Button but2 = findViewById(R.id.button2);

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = findViewById(R.id.imageView);
                new ImageDownloader(imageView).execute("https://i.ebayimg.com/images/g/fkwAAMXQya1Q7h1o/s-l400.jpg ");
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
        @GET("https://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=5a185bebc490568bc569eb2c3ef1236d")
        Call<String> message();
}*/

