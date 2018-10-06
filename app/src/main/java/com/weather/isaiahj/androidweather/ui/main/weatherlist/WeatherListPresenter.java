package com.weather.isaiahj.androidweather.ui.main.weatherlist;

import com.weather.isaiahj.androidweather.data.DataManager;
import com.weather.isaiahj.androidweather.data.network.AppApiCallback;
import com.weather.isaiahj.androidweather.data.network.model.BulkCurrentWeather;
import com.weather.isaiahj.androidweather.ui.base.BasePresenter;
import com.weather.isaiahj.androidweather.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by isaiahj on 07/10/2018.
 */

public class WeatherListPresenter<V extends WeatherListMvpView> extends BasePresenter<V>
        implements WeatherListMvpPresenter<V> {

    @Inject
    public WeatherListPresenter(DataManager dataManager,
                                SchedulerProvider schedulerProvider,
                                CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {
        doApiCallForResponse(getDataManager().doGetBulkCurrentWeatherData(), new AppApiCallback() {
            @Override
            public void onSuccess(Object response) {
                super.onSuccess(response);

                getMvpView().updateWeatherList((BulkCurrentWeather) response);
            }

            @Override
            public void onFailure(Throwable t) {
                super.onFailure(t);

                getMvpView().updateWeatherList(null);
            }
        });
    }
}
