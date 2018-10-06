package com.weather.isaiahj.androidweather.ui.weatherdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.weather.isaiahj.androidweather.R;
import com.weather.isaiahj.androidweather.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by isaiahj on 07/10/2018.
 */

public class WeatherDetailActivity extends BaseActivity implements WeatherDetailMvpView {

    @Inject
    WeatherDetailMvpPresenter<WeatherDetailMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, WeatherDetailActivity.class);
        return intent;
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

    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
