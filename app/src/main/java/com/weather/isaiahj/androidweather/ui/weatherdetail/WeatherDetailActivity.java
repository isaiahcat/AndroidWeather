package com.weather.isaiahj.androidweather.ui.weatherdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.weather.isaiahj.androidweather.R;
import com.weather.isaiahj.androidweather.data.network.model.currentweather.CurrentWeather;
import com.weather.isaiahj.androidweather.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by isaiahj on 07/10/2018.
 */

public class WeatherDetailActivity extends BaseActivity implements WeatherDetailMvpView {

    private static final String EXTRA_PARCELABLE = "EXTRA_PARCELABLE";

    @Inject
    WeatherDetailMvpPresenter<WeatherDetailMvpView> mPresenter;

    private CurrentWeather mCurrentWeather;

    public static Intent getStartIntentWithParcelableExtra(Context context, Parcelable parcelable) {
        return new Intent(context, WeatherDetailActivity.class).putExtra(EXTRA_PARCELABLE, parcelable);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();
    }

    @Override
    protected void setUp() {
        mCurrentWeather = getIntent().getParcelableExtra(EXTRA_PARCELABLE);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
