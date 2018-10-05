package com.weather.isaiahj.androidweather.di.component;

import android.app.Application;
import android.content.Context;

import com.weather.isaiahj.androidweather.MvpApp;
import com.weather.isaiahj.androidweather.data.DataManager;
import com.weather.isaiahj.androidweather.di.ApplicationContext;
import com.weather.isaiahj.androidweather.di.module.ApplicationModule;
import com.weather.isaiahj.androidweather.service.SyncService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by isaiahj on 05/10/2018.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);

    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}