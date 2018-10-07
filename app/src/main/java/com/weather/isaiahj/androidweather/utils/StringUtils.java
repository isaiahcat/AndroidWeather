package com.weather.isaiahj.androidweather.utils;

import com.weather.isaiahj.androidweather.data.network.model.currentweather.CurrentWeather;

/**
 * Created by isaiahj on 05/10/2018.
 */

public final class StringUtils {

    private StringUtils() {
        // This utility class is not publicly instantiable
    }

    public static String getFormattedWeatherLocation(CurrentWeather currentWeather) {
        if (currentWeather == null || currentWeather.getName() == null) return "";
        if (currentWeather.getName() != null && currentWeather.getSys() == null)
            return currentWeather.getName();
        return String.format("%s, %s", currentWeather.getName(), currentWeather.getSys().getCountry());
    }

    public static String getFormattedWeatherDescription(CurrentWeather currentWeather) {
        if (currentWeather == null || currentWeather.getWeather() == null ||
                currentWeather.getWeather().isEmpty()) return "";
        return currentWeather.getWeather().get(0).getDescription();
    }

    public static String getFormattedWeatherTemperature(CurrentWeather currentWeather) {
        if (currentWeather == null || currentWeather.getMain() == null) return "";
        return String.format("%s \u00B0C", currentWeather.getMain().getTemp());
    }
}
