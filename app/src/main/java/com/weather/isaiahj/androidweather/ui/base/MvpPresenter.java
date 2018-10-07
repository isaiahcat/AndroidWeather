package com.weather.isaiahj.androidweather.ui.base;

/**
 * Created by isaiahj on 05/10/2018.
 */

import com.androidnetworking.error.ANError;
import com.weather.isaiahj.androidweather.data.network.ApiCallback;

import io.reactivex.Observable;

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

    void handleApiError(ANError error);

    void doApiCallForResponse(Observable observable, final ApiCallback callback);

}
