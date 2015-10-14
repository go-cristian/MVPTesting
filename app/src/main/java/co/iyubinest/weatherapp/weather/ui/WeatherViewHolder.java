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

package co.iyubinest.weatherapp.weather.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import co.iyubinest.weatherapp.R;

/**
 * Created by cristiangomez on 14/10/15.
 */
public class WeatherViewHolder extends RecyclerView.ViewHolder
{

    public TextView mWeatherValue;

    public TextView mWeatherCity;

    public TextView mWeatherStatus;

    public WeatherViewHolder (View itemView)
    {
        super(itemView);
        mWeatherValue = (TextView) itemView.findViewById(R.id.weather_value);
        mWeatherCity = (TextView) itemView.findViewById(R.id.weather_city);
        mWeatherStatus = (TextView) itemView.findViewById(R.id.weather_status);
    }
}
