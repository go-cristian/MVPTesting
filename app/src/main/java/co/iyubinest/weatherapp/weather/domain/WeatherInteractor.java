package co.iyubinest.weatherapp.weather.domain;

import co.iyubinest.weatherapp.interactor.InteractorListener;
import java.util.List;

/**
 * Created by cristiangomez on 14/10/15.
 */
public interface WeatherInteractor
{

    void getWeather (InteractorListener<List<Weather>> interactorListener);
}
