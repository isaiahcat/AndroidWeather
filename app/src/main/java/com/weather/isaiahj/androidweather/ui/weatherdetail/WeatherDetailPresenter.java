package com.weather.isaiahj.androidweather.ui.weatherdetail;

import com.weather.isaiahj.androidweather.data.DataManager;
import com.weather.isaiahj.androidweather.ui.base.BasePresenter;
import com.weather.isaiahj.androidweather.ui.base.MvpView;
import com.weather.isaiahj.androidweather.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by isaiahj on 07/10/2018.
 */

public class WeatherDetailPresenter<V extends MvpView> extends BasePresenter<V> implements
        WeatherDetailMvpPresenter<V> {

    private static final String TAG = "WeatherDetailPresenter";

    @Inject
    public WeatherDetailPresenter(DataManager dataManager,
                                  SchedulerProvider schedulerProvider,
                                  CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
