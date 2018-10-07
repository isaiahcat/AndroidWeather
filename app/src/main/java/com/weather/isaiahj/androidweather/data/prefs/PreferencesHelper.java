package com.weather.isaiahj.androidweather.data.prefs;

/**
 * Created by isaiahj on 05/10/2018.
 */

public interface PreferencesHelper {

    String getCityIds();

    void addCurrentCityId(String cityId);
}
