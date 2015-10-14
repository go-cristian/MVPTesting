/**
 * Copyright (C) 2015 Cristian Gomez Open Source Project
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
