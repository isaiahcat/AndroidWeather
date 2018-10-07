package com.weather.isaiahj.androidweather.ui.main;


import com.weather.isaiahj.androidweather.di.PerActivity;
import com.weather.isaiahj.androidweather.ui.base.MvpPresenter;

/**
 * Created by isaiahj on 05/10/2018.
 */

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void onViewInitialized();

    void onLocationReceived(double lat, double lon);
}
