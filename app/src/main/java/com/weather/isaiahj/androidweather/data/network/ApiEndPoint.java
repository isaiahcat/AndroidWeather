package com.weather.isaiahj.androidweather.data.network;

import com.weather.isaiahj.androidweather.BuildConfig;
import com.weather.isaiahj.androidweather.data.network.model.currentweather.CurrentWeather;

/**
 * Created by amitshekhar on 01/02/17.
 */

public final class ApiEndPoint {

    public static final String ENDPOINT_CURRENT_WEATHER = BuildConfig.BASE_URL
            + "/data/2.5/weather";

    public static final String ENDPOINT_BULK_CURRENT_WEATHER = BuildConfig.BASE_URL
            + "/data/2.5/group";

    public static String getEndpointForWeatherIcons(CurrentWeather currentWeather) {
        if (currentWeather == null || currentWeather.getWeather() == null ||
                currentWeather.getWeather().isEmpty()) return "";
        return BuildConfig.ICONS_URL + "/img/w/" + currentWeather.getWeather().get(0).getIcon() + ".png";
    }

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }

}
