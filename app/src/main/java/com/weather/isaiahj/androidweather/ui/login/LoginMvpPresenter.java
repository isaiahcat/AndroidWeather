package com.weather.isaiahj.androidweather.ui.login;


import com.weather.isaiahj.androidweather.di.PerActivity;
import com.weather.isaiahj.androidweather.ui.base.MvpPresenter;

/**
 * Created by isaiahj on 05/10/2018.
 */

@PerActivity
public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {

    void onServerLoginClick(String email, String password);

    void onGoogleLoginClick();

    void onFacebookLoginClick();

}
