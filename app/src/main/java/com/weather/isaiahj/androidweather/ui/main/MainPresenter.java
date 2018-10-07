package com.weather.isaiahj.androidweather.ui.main;

import com.weather.isaiahj.androidweather.R;
import com.weather.isaiahj.androidweather.data.DataManager;
import com.weather.isaiahj.androidweather.data.network.AppApiCallback;
import com.weather.isaiahj.androidweather.data.network.model.currentweather.CurrentWeather;
import com.weather.isaiahj.androidweather.ui.base.BasePresenter;
import com.weather.isaiahj.androidweather.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by isaiahj on 05/10/2018.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    private static final String TAG = "MainPresenter";

    @Inject
    public MainPresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewInitialized() {

    }

    @Override
    public void onLocationReceived(double lat, double lon) {
        doApiCallForResponse(getDataManager().doGetCurrentWeatherByCoords(lat, lon), new AppApiCallback() {
            @Override
            public void onSuccess(Object response) {
                super.onSuccess(response);

                CurrentWeather currentWeather = (CurrentWeather) response;

                getDataManager().addCurrentCityId(currentWeather.getId().toString());

                getMvpView().setupWeatherListContainerView();
            }

            @Override
            public void onFailure(Throwable t) {
                super.onFailure(t);

                getMvpView().onError(R.string.unable_to_load_weather_data_please_try_again);
            }
        });
    }

}
