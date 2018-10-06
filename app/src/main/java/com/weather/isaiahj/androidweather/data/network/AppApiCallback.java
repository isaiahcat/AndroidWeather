package com.weather.isaiahj.androidweather.data.network;

import com.weather.isaiahj.androidweather.utils.AppLogger;

import java.util.List;

/**
 * Created by Ayi on 05/06/2017.
 */

public class AppApiCallback implements ApiCallback {

    @Override
    public void onSuccess() {
        AppLogger.d("inside onSuccess()");
    }

    @Override
    public void onSuccess(Object response) {
        AppLogger.d("inside onSuccess(Object response)");
    }

    @Override
    public void onSuccess(List<?> response) {
        AppLogger.d("inside onSuccess(List<?> response)");
    }

    @Override
    public void onFailure(Throwable t) {
        AppLogger.d("inside onFailure(Throwable t) ");
    }
}
