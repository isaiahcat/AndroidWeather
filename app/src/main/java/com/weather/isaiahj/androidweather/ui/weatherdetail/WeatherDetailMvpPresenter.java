package com.weather.isaiahj.androidweather.ui.weatherdetail;

import com.weather.isaiahj.androidweather.ui.base.MvpPresenter;
import com.weather.isaiahj.androidweather.ui.base.MvpView;

/**
 * Created by isaiahj on 07/10/2018.
 */

public interface WeatherDetailMvpPresenter<V extends WeatherDetailMvpView> extends MvpPresenter<V> {

    void onViewRefreshed(String cityId);
}
