package com.weather.isaiahj.androidweather.data;


import com.weather.isaiahj.androidweather.data.network.ApiHelper;
import com.weather.isaiahj.androidweather.data.network.model.BulkCurrentWeather;
import com.weather.isaiahj.androidweather.data.prefs.PreferencesHelper;

import io.reactivex.Observable;

/**
 * Created by isaiahj on 05/10/2018.
 */

public interface DataManager extends PreferencesHelper, ApiHelper {

    Observable<BulkCurrentWeather> doGetBulkCurrentWeatherData();
}
