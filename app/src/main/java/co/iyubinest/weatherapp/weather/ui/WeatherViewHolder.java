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
