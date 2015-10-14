package co.iyubinest.weatherapp.weather.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Bind;
import butterknife.ButterKnife;
import co.iyubinest.weatherapp.R;
import co.iyubinest.weatherapp.weather.domain.Weather;
import co.iyubinest.weatherapp.weather.domain.WeatherInteractor;
import co.iyubinest.weatherapp.weather.repository.TestWeatherInteractor;
import java.util.List;

public class WeatherActivity extends AppCompatActivity implements WeatherView
{

    @Bind (R.id.weather_view) RecyclerView mWeatherView;

    @Bind (R.id.error_view) View mErrorView;

    @Bind (R.id.loading_view) View mLoadingView;

    private WeatherPresenter mPresenter;

    private WeatherInteractor mWeatherInteractor;

    private WeatherAdapter mWeatherAdapter;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initDependencies();
        initView();
        showView(mLoadingView);

        mPresenter = new WeatherPresenter(mWeatherInteractor);
        mPresenter.onCreate(this);
    }

    private void initView ()
    {
        mWeatherAdapter = new WeatherAdapter(this);
        mWeatherView.setAdapter(mWeatherAdapter);
        mWeatherView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initDependencies ()
    {
        mWeatherInteractor = new TestWeatherInteractor();
        mPresenter = new WeatherPresenter(mWeatherInteractor);
    }

    private void showView (View view)
    {
        mLoadingView.setVisibility(View.INVISIBLE);
        mErrorView.setVisibility(View.INVISIBLE);
        mWeatherView.setVisibility(View.INVISIBLE);
        view.setVisibility(View.VISIBLE);
    }

    @Override
    public void load (List<Weather> weatherList)
    {
        mWeatherAdapter.update(weatherList);
        showView(mWeatherView);
    }

    @Override
    public void onError (Exception e)
    {
        showView(mErrorView);
    }
}
