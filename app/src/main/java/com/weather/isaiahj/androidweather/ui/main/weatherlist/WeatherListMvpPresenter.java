package com.weather.isaiahj.androidweather.ui.main.weatherlist;

import com.weather.isaiahj.androidweather.ui.base.MvpPresenter;

/**
 * Created by isaiahj on 07/10/2018.
 */

public interface WeatherListMvpPresenter<V extends WeatherListMvpView>
        extends MvpPresenter<V> {

    void onViewPrepared();
}


