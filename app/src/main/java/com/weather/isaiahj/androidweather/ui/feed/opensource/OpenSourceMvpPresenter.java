package com.weather.isaiahj.androidweather.ui.feed.opensource;

import com.weather.isaiahj.androidweather.ui.base.MvpPresenter;

/**
 * Created by janisharali on 25/05/17.
 */

public interface OpenSourceMvpPresenter<V extends OpenSourceMvpView>
        extends MvpPresenter<V> {

    void onViewPrepared();
}
