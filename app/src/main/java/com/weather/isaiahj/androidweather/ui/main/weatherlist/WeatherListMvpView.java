package com.weather.isaiahj.androidweather.ui.main.weatherlist;

import android.graphics.drawable.Drawable;

import com.weather.isaiahj.androidweather.data.network.model.BulkCurrentWeather;
import com.weather.isaiahj.androidweather.ui.base.MvpView;

/**
 * Created by isaiahj on 07/10/2018.
 */

public interface WeatherListMvpView extends MvpView {

    void updateWeatherList(BulkCurrentWeather weatherList);

    void refreshWeatherList(Drawable refreshIcon);
}
