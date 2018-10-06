package com.weather.isaiahj.androidweather.ui.splash;

import android.os.Handler;

import com.weather.isaiahj.androidweather.R;
import com.weather.isaiahj.androidweather.data.DataManager;
import com.weather.isaiahj.androidweather.ui.base.BasePresenter;
import com.weather.isaiahj.androidweather.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by isaiahj on 05/10/2018.
 */

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V>
        implements SplashMvpPresenter<V> {

    private static final int SPLASH_DELAY_MS = 2000;

    @Inject
    public SplashPresenter(DataManager dataManager,
                           SchedulerProvider schedulerProvider,
                           CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getMvpView().openMainActivity();
            }
        }, SPLASH_DELAY_MS);
    }
}
