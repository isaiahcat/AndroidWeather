package com.weather.isaiahj.androidweather.utils;

import com.weather.isaiahj.androidweather.data.network.model.currentweather.CurrentWeather;
import com.weather.isaiahj.androidweather.data.network.model.currentweather.Main;

import java.util.Locale;

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

    public static String getFormattedWeatherDetails(CurrentWeather currentWeather) {
        if (currentWeather == null) return "";

        StringBuilder detailsText = new StringBuilder();

        if (currentWeather.getMain() != null) {

            Main main = currentWeather.getMain();

            if (main.getTempMin() != null && main.getTempMax() != null) {
                detailsText.append(String.format(Locale.getDefault(), "temperature from %s to %s \u00B0C\n",
                        main.getTempMin(), main.getTempMax()));
            }

            if (main.getHumidity() != null) {
                detailsText.append(String.format(Locale.getDefault(), "humidity %s\n", main.getHumidity()));
            }

            if (main.getPressure() != null) {
                detailsText.append(String.format(Locale.getDefault(), "pressure %s\n", main.getPressure()));
            }
        }

        if (currentWeather.getWind() != null && currentWeather.getWind().getSpeed() != null) {
            detailsText.append(String.format(Locale.getDefault(), "wind %s m/s\n",
                    currentWeather.getWind().getSpeed()));
        }

        if (currentWeather.getClouds() != null && currentWeather.getClouds().getAll() != null) {
            detailsText.append(String.format(Locale.getDefault(), "clouds %s %%\n",
                    currentWeather.getClouds().getAll()));
        }

        if (currentWeather.getCoord() != null && currentWeather.getCoord().getLat() != null &&
                currentWeather.getCoord().getLon() != null) {
            detailsText.append(String.format(Locale.getDefault(), "Geo coords [%s, %s]\n",
                    currentWeather.getCoord().getLat(), currentWeather.getCoord().getLon()));
        }

        return detailsText.toString();
    }
}
