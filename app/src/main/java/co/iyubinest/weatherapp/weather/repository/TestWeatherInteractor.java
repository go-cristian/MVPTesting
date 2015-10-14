package co.iyubinest.weatherapp.weather.repository;

import co.iyubinest.weatherapp.interactor.InteractorListener;
import co.iyubinest.weatherapp.weather.domain.Weather;
import co.iyubinest.weatherapp.weather.domain.WeatherInteractor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristiangomez on 14/10/15.
 */
public class TestWeatherInteractor implements WeatherInteractor
{

    @Override
    public void getWeather (InteractorListener<List<Weather>> interactorListener)
    {
        List<Weather> weatherData = new ArrayList<>();
        weatherData.add(new Weather("Bogotá", "13.2º", "Nublado"));
        weatherData.add(new Weather("Barranquilla", "43.2º", "Muy Cálido"));
        interactorListener.onSuccess(weatherData);
    }
}
