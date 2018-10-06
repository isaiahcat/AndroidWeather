package com.weather.isaiahj.androidweather.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

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

}
