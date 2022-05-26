import com.example.myapplication.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherOneDayApiService {

        @GET("/data/2.5/weather")
        Call<com.example.myapplication.Example> getWeatherByCityName(@Query("q") String city, @Query("appid") String appID);

    }


