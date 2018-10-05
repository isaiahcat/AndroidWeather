package com.weather.isaiahj.androidweather.ui.feed;

import com.weather.isaiahj.androidweather.data.DataManager;
import com.weather.isaiahj.androidweather.ui.base.BasePresenter;
import com.weather.isaiahj.androidweather.ui.base.MvpView;
import com.weather.isaiahj.androidweather.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by janisharali on 25/05/17.
 */

public class FeedPresenter<V extends MvpView> extends BasePresenter<V> implements
        FeedMvpPresenter<V> {

    private static final String TAG = "FeedPresenter";

    @Inject
    public FeedPresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
