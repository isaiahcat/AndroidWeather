package com.weather.isaiahj.androidweather.ui.about;

import com.weather.isaiahj.androidweather.data.DataManager;
import com.weather.isaiahj.androidweather.ui.base.BasePresenter;
import com.weather.isaiahj.androidweather.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by isaiahj on 05/10/2018.
 */

public class AboutPresenter<V extends AboutMvpView> extends BasePresenter<V>
        implements AboutMvpPresenter<V> {

    @Inject
    public AboutPresenter(DataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
