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

package co.iyubinest.weatherapp;

import co.iyubinest.weatherapp.interactor.InteractorListener;
import co.iyubinest.weatherapp.weather.domain.Weather;
import co.iyubinest.weatherapp.weather.domain.WeatherInteractor;
import co.iyubinest.weatherapp.weather.ui.WeatherPresenter;
import co.iyubinest.weatherapp.weather.ui.WeatherView;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ConverterPresenterTest
{

    @Mock private WeatherView weatherView;

    @Mock private WeatherInteractor weatherInteractor;

    @Captor private ArgumentCaptor<InteractorListener<List<Weather>>> callbackArgumentCaptor;

    private WeatherPresenter presenter;

    private ArrayList<Weather> weatherData;

    @Before
    public void setUp ()
    {
        MockitoAnnotations.initMocks(this);
        presenter = new WeatherPresenter(weatherInteractor);

        weatherData = new ArrayList<>();
        weatherData.add(new Weather("Bogotá", "13.2º", "Nublado"));
        weatherData.add(new Weather("Barranquilla", "43.2º", "Muy Cálido"));
    }

    @Test
    public void testExecution ()
    {
        presenter.onCreate(weatherView);
        verify(weatherInteractor, times(1)).getWeather(callbackArgumentCaptor.capture());
        callbackArgumentCaptor.getValue().onSuccess(weatherData);
        verify(weatherView, times(1)).load(weatherData);
    }

    @Test
    public void testFailExecution ()
    {
        presenter.onCreate(weatherView);
        verify(weatherInteractor, times(1)).getWeather(callbackArgumentCaptor.capture());
        callbackArgumentCaptor.getValue().onFailure(new Exception("can not get info."));
        verify(weatherView, times(1)).onError(any(Exception.class));
    }
}
