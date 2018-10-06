package com.weather.isaiahj.androidweather.ui.main;

import com.weather.isaiahj.androidweather.data.db.model.Question;
import com.weather.isaiahj.androidweather.data.network.model.currentweather.CurrentWeather;
import com.weather.isaiahj.androidweather.ui.base.MvpView;

import java.util.List;

/**
 * Created by isaiahj on 05/10/2018.
 */

public interface MainMvpView extends MvpView {

    void refreshWeatherList(List<Question> questionList);

    void reloadWeatherList(List<Question> questionList);

    void openWeatherDetailActivity(CurrentWeather currentWeather);

}
