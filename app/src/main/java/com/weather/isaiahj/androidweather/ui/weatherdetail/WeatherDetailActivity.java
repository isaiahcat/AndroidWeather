package com.weather.isaiahj.androidweather.ui.weatherdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weather.isaiahj.androidweather.R;
import com.weather.isaiahj.androidweather.data.network.ApiEndPoint;
import com.weather.isaiahj.androidweather.data.network.model.currentweather.CurrentWeather;
import com.weather.isaiahj.androidweather.ui.base.BaseActivity;
import com.weather.isaiahj.androidweather.utils.StringUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by isaiahj on 07/10/2018.
 */

public class WeatherDetailActivity extends BaseActivity implements WeatherDetailMvpView {

    private static final String EXTRA_PARCELABLE = "EXTRA_PARCELABLE";

    @Inject
    WeatherDetailMvpPresenter<WeatherDetailMvpView> mPresenter;

    @BindView(R.id.icon_image_view)
    ImageView mIconImageView;

    @BindView(R.id.location_text_view)
    TextView mLocationTextView;

    @BindView(R.id.weather_text_view)
    TextView mWeatherTextView;

    @BindView(R.id.temperature_text_view)
    TextView mTemperatureTextView;

    @BindView(R.id.details_text_view)
    TextView mDetailsTextView;

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

        mLocationTextView.setText(StringUtils.getFormattedWeatherLocation(mCurrentWeather));

        mWeatherTextView.setText(StringUtils.getFormattedWeatherDescription(mCurrentWeather));

        mTemperatureTextView.setText(StringUtils.getFormattedWeatherTemperature(mCurrentWeather));

        mDetailsTextView.setText(StringUtils.getFormattedWeatherDetails(mCurrentWeather));

        Glide.with(WeatherDetailActivity.this)
                .load(ApiEndPoint.getEndpointForWeatherIcons(mCurrentWeather))
                .fitCenter()
                .into(mIconImageView);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
