package com.weather.isaiahj.androidweather.ui.weatherdetail;

import com.weather.isaiahj.androidweather.data.network.model.currentweather.CurrentWeather;
import com.weather.isaiahj.androidweather.ui.base.MvpView;

/**
 * Created by isaiahj on 07/10/2018.
 */

public interface WeatherDetailMvpView extends MvpView {

    void updateWeatherDetails(CurrentWeather currentWeather);
}
