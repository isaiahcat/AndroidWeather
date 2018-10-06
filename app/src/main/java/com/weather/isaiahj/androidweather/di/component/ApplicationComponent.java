package com.weather.isaiahj.androidweather.di.component;

import android.app.Application;
import android.content.Context;

import com.weather.isaiahj.androidweather.WeatherApp;
import com.weather.isaiahj.androidweather.data.DataManager;
import com.weather.isaiahj.androidweather.di.ApplicationContext;
import com.weather.isaiahj.androidweather.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by isaiahj on 05/10/2018.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(WeatherApp app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}