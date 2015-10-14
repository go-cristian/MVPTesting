package co.iyubinest.weatherapp.weather.ui;

import co.iyubinest.weatherapp.weather.domain.Weather;
import java.util.List;

/**
 * Created by cristiangomez on 14/10/15.
 */
public interface WeatherView
{

    void load (List<Weather> weatherList);

    void onError (Exception e);
}
