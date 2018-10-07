package com.weather.isaiahj.androidweather.data;


import android.content.Context;

import com.weather.isaiahj.androidweather.data.network.ApiHeader;
import com.weather.isaiahj.androidweather.data.network.ApiHelper;
import com.weather.isaiahj.androidweather.data.network.model.BulkCurrentWeather;
import com.weather.isaiahj.androidweather.data.network.model.currentweather.CurrentWeather;
import com.weather.isaiahj.androidweather.data.prefs.PreferencesHelper;
import com.weather.isaiahj.androidweather.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by isaiahj on 05/10/2018.
 */

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public Observable<CurrentWeather> doGetCurrentWeatherByCoords(double lat, double lon) {
        return mApiHelper.doGetCurrentWeatherByCoords(lat, lon);
    }

    @Override
    public Observable<CurrentWeather> doGetCurrentWeatherByCityId(String cityId) {
        return mApiHelper.doGetCurrentWeatherByCityId(cityId);
    }

    @Override
    public Observable<BulkCurrentWeather> doGetBulkCurrentWeatherData(String cityIds) {
        return mApiHelper.doGetBulkCurrentWeatherData(cityIds);
    }

    @Override
    public Observable<BulkCurrentWeather> doGetBulkCurrentWeatherData() {
        return mApiHelper.doGetBulkCurrentWeatherData(mPreferencesHelper.getCityIds());
    }

    @Override
    public String getCityIds() {
        return mPreferencesHelper.getCityIds();
    }

    @Override
    public void addCurrentCityId(String cityId) {
        mPreferencesHelper.addCurrentCityId(cityId);
    }

}
