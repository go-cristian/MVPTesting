package co.iyubinest.weatherapp.weather.ui;

import co.iyubinest.weatherapp.interactor.InteractorListener;
import co.iyubinest.weatherapp.weather.domain.Weather;
import co.iyubinest.weatherapp.weather.domain.WeatherInteractor;
import java.util.List;

/**
 * Created by cristiangomez on 14/10/15.
 */
public class WeatherPresenter
{

    private final WeatherInteractor mWeatherInteractor;

    private WeatherView mView;

    public WeatherPresenter (WeatherInteractor mWeatherInteractor)
    {
        this.mWeatherInteractor = mWeatherInteractor;
    }

    public void onCreate (WeatherView view)
    {
        mView = view;
        mWeatherInteractor.getWeather(new InteractorListener<List<Weather>>()
        {

            @Override
            public void onSuccess (List<Weather> weatherList)
            {
                mView.load(weatherList);
            }

            @Override
            public void onFailure (Exception e)
            {
                mView.onError(e);
            }
        });
    }
}
