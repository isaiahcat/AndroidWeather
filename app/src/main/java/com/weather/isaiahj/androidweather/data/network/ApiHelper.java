package com.weather.isaiahj.androidweather.data.network;


import com.weather.isaiahj.androidweather.data.network.model.BulkCurrentWeather;
import com.weather.isaiahj.androidweather.data.network.model.currentweather.CurrentWeather;

import io.reactivex.Observable;

/**
 * Created by isaiahj on 05/10/2018.
 */

public interface ApiHelper {

    ApiHeader getApiHeader();

    Observable<CurrentWeather> doGetCurrentWeatherDataForCityId(String cityId);

    Observable<BulkCurrentWeather> doGetBulkCurrentWeatherData(String cityIds);

}
