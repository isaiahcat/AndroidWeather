package com.weather.isaiahj.androidweather.di.module;

import android.app.Application;
import android.content.Context;

import com.weather.isaiahj.androidweather.BuildConfig;
import com.weather.isaiahj.androidweather.R;
import com.weather.isaiahj.androidweather.data.AppDataManager;
import com.weather.isaiahj.androidweather.data.DataManager;
import com.weather.isaiahj.androidweather.data.db.AppDbHelper;
import com.weather.isaiahj.androidweather.data.db.DbHelper;
import com.weather.isaiahj.androidweather.data.network.ApiHeader;
import com.weather.isaiahj.androidweather.data.network.ApiHelper;
import com.weather.isaiahj.androidweather.data.network.AppApiHelper;
import com.weather.isaiahj.androidweather.data.prefs.AppPreferencesHelper;
import com.weather.isaiahj.androidweather.data.prefs.PreferencesHelper;
import com.weather.isaiahj.androidweather.di.ApiInfo;
import com.weather.isaiahj.androidweather.di.ApplicationContext;
import com.weather.isaiahj.androidweather.di.DatabaseInfo;
import com.weather.isaiahj.androidweather.di.PreferenceInfo;
import com.weather.isaiahj.androidweather.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by isaiahj on 05/10/2018.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
