package com.weather.isaiahj.androidweather.ui.main;

import android.os.Bundle;

import com.weather.isaiahj.androidweather.data.network.model.currentweather.CurrentWeather;
import com.weather.isaiahj.androidweather.ui.base.MvpView;

/**
 * Created by isaiahj on 05/10/2018.
 */

public interface MainMvpView extends MvpView {

    void addCurrentLocation();

    void setupWeatherListContainerView();

    void openWeatherDetailActivity(CurrentWeather currentWeather, Bundle sharedElementBundle);

}
