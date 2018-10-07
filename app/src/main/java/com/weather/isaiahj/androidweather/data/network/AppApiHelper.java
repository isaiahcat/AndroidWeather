package com.weather.isaiahj.androidweather.data.network;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.weather.isaiahj.androidweather.data.network.model.BulkCurrentWeather;
import com.weather.isaiahj.androidweather.data.network.model.currentweather.CurrentWeather;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by janisharali on 28/01/17.
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    private ApiParameter mApiParameter;

    @Inject
    public AppApiHelper(ApiHeader apiHeader, ApiParameter apiParameter) {
        mApiHeader = apiHeader;
        mApiParameter = apiParameter;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Observable<CurrentWeather> doGetCurrentWeatherByCoords(double lat, double lon) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_CURRENT_WEATHER)
                .addQueryParameter(mApiHeader.getPublicApiHeader())
                .addQueryParameter(mApiParameter.getLatApiParameter(lat))
                .addQueryParameter(mApiParameter.getLonApiParameter(lon))
                .build()
                .getObjectObservable(CurrentWeather.class);
    }

    @Override
    public Observable<CurrentWeather> doGetCurrentWeatherByCityId(String cityId) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_CURRENT_WEATHER)
                .addQueryParameter(mApiHeader.getPublicApiHeader())
                .addQueryParameter(mApiParameter.getIdApiParameter(cityId))
                .build()
                .getObjectObservable(CurrentWeather.class);
    }

    @Override
    public Observable<BulkCurrentWeather> doGetBulkCurrentWeatherData(String cityIds) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_BULK_CURRENT_WEATHER)
                .addQueryParameter(mApiHeader.getPublicApiHeader())
                .addQueryParameter(mApiParameter.getIdApiParameter(cityIds))
                .build()
                .getObjectObservable(BulkCurrentWeather.class);
    }
}

