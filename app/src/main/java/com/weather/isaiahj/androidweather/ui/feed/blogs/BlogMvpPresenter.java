package com.weather.isaiahj.androidweather.ui.feed.blogs;

import com.weather.isaiahj.androidweather.ui.base.MvpPresenter;

/**
 * Created by janisharali on 25/05/17.
 */

public interface BlogMvpPresenter<V extends BlogMvpView>
        extends MvpPresenter<V> {

    void onViewPrepared();
}


