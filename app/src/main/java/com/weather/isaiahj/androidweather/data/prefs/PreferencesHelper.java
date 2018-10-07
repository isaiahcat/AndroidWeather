package com.weather.isaiahj.androidweather.data.prefs;

import com.weather.isaiahj.androidweather.data.network.model.BulkCurrentWeather;

/**
 * Created by isaiahj on 05/10/2018.
 */

public interface PreferencesHelper {

    String getCityIds();

    void addCurrentCityId(String cityId);

    void setBulkCurrentWeather(BulkCurrentWeather bulkCurrentWeather);

    BulkCurrentWeather getBulkCurrentWeather();
}
