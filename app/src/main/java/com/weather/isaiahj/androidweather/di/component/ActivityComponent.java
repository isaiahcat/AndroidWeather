package com.weather.isaiahj.androidweather.di.component;

import com.weather.isaiahj.androidweather.di.PerActivity;
import com.weather.isaiahj.androidweather.di.module.ActivityModule;
import com.weather.isaiahj.androidweather.ui.about.AboutFragment;
import com.weather.isaiahj.androidweather.ui.feed.FeedActivity;
import com.weather.isaiahj.androidweather.ui.feed.blogs.BlogFragment;
import com.weather.isaiahj.androidweather.ui.feed.opensource.OpenSourceFragment;
import com.weather.isaiahj.androidweather.ui.login.LoginActivity;
import com.weather.isaiahj.androidweather.ui.main.MainActivity;
import com.weather.isaiahj.androidweather.ui.main.rating.RateUsDialog;
import com.weather.isaiahj.androidweather.ui.splash.SplashActivity;

import dagger.Component;

/**
 * Created by isaiahj on 05/10/2018.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

    void inject(FeedActivity activity);

    void inject(AboutFragment fragment);

    void inject(OpenSourceFragment fragment);

    void inject(BlogFragment fragment);

    void inject(RateUsDialog dialog);

}
