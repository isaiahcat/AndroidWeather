package com.weather.isaiahj.androidweather.data.network;

import com.weather.isaiahj.androidweather.BuildConfig;

/**
 * Created by amitshekhar on 01/02/17.
 */

public final class ApiEndPoint {

    public static final String ENDPOINT_CURRENT_WEATHER = BuildConfig.BASE_URL
            + "/data/2.5/weather";

    public static final String ENDPOINT_BULK_CURRENT_WEATHER = BuildConfig.BASE_URL
            + "/data/2.5/group";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }

}
