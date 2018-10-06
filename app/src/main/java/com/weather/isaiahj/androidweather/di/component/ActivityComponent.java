package com.weather.isaiahj.androidweather.di.component;

import com.weather.isaiahj.androidweather.di.PerActivity;
import com.weather.isaiahj.androidweather.di.module.ActivityModule;
import com.weather.isaiahj.androidweather.ui.about.AboutFragment;
import com.weather.isaiahj.androidweather.ui.weatherdetail.WeatherDetailActivity;
import com.weather.isaiahj.androidweather.ui.main.MainActivity;
import com.weather.isaiahj.androidweather.ui.main.weatherlist.WeatherListFragment;
import com.weather.isaiahj.androidweather.ui.splash.SplashActivity;

import dagger.Component;

/**
 * Created by isaiahj on 05/10/2018.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(SplashActivity activity);

    void inject(WeatherDetailActivity activity);

    void inject(AboutFragment fragment);

    void inject(WeatherListFragment fragment);

}
