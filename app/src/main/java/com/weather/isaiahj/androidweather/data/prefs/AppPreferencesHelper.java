package com.weather.isaiahj.androidweather.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.weather.isaiahj.androidweather.data.network.model.BulkCurrentWeather;
import com.weather.isaiahj.androidweather.di.ApplicationContext;
import com.weather.isaiahj.androidweather.di.PreferenceInfo;
import com.weather.isaiahj.androidweather.utils.AppConstants;

import java.util.Iterator;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by isaiahj on 05/10/2018.
 */

@Singleton
public class AppPreferencesHelper implements PreferencesHelper {

    private final SharedPreferences mPrefs;

    private static final String PREF_BULK_CURRENT_WEATHER = "PREF_BULK_CURRENT_WEATHER";

    private static final String PREF_CITY_IDS = "PREF_CITY_IDS";

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);

        mPrefs.edit().putString(PREF_CITY_IDS, AppConstants.DEFAULT_CITY_IDS).apply();
    }

    @Override
    public String getCityIds() {
        return mPrefs.getString(PREF_CITY_IDS, "");
    }

    @Override
    public void addCurrentCityId(String cityId) {
        mPrefs.edit().putString(PREF_CITY_IDS, getCityIds() + "," + cityId).apply();
    }

    @Override
    public void setBulkCurrentWeather(BulkCurrentWeather bulkCurrentWeather) {
        mPrefs.edit().putString(PREF_BULK_CURRENT_WEATHER, new Gson().toJson(bulkCurrentWeather)).apply();
    }

    @Override
    public BulkCurrentWeather getBulkCurrentWeather() {
        String prefBulkCurrentWeather = mPrefs.getString(PREF_BULK_CURRENT_WEATHER, "");
        return prefBulkCurrentWeather.equals("") ? null :
                new Gson().fromJson(prefBulkCurrentWeather, BulkCurrentWeather.class);
    }

}
