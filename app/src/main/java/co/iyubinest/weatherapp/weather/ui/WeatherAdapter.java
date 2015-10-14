package co.iyubinest.weatherapp.weather.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import co.iyubinest.weatherapp.R;
import co.iyubinest.weatherapp.weather.domain.Weather;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristiangomez on 14/10/15.
 */
public class WeatherAdapter extends RecyclerView.Adapter<WeatherViewHolder>
{

    private final Context mContext;

    private List<Weather> mData;

    public WeatherAdapter (Context context)
    {
        mContext = context;
        mData = new ArrayList<>();
    }

    @Override
    public WeatherViewHolder onCreateViewHolder (ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_item, parent,
                                                                     false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder (WeatherViewHolder holder, int position)
    {
        Weather weather = mData.get(position);
        holder.mWeatherCity.setText(weather.getCity());
        holder.mWeatherValue.setText(weather.getValue());
        holder.mWeatherStatus.setText(weather.getStatus());
    }

    @Override
    public int getItemCount ()
    {
        return mData.size();
    }

    public void update (List<Weather> weatherList)
    {
        mData.clear();
        mData.addAll(weatherList);
        notifyDataSetChanged();
    }
}
