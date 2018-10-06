package com.weather.isaiahj.androidweather.ui.main.weatherlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weather.isaiahj.androidweather.R;
import com.weather.isaiahj.androidweather.data.network.model.BulkCurrentWeather;
import com.weather.isaiahj.androidweather.di.component.ActivityComponent;
import com.weather.isaiahj.androidweather.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by isaiahj on 07/10/2018.
 */

public class WeatherListFragment extends BaseFragment implements
        WeatherListMvpView, WeatherListAdapter.Callback {

    private static final String TAG = "WeatherListFragment";

    @Inject
    WeatherListMvpPresenter<WeatherListMvpView> mPresenter;

    @Inject
    WeatherListAdapter mWeatherListAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.fragment_weather_list_recycler)
    RecyclerView mRecyclerView;

    public static WeatherListFragment newInstance() {
        Bundle args = new Bundle();
        WeatherListFragment fragment = new WeatherListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_list, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
            mWeatherListAdapter.setCallback(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mWeatherListAdapter);

        mPresenter.onViewPrepared();
    }

    @Override
    public void onWeatherListEmptyViewRetryClick() {
        mPresenter.onViewPrepared();
    }

    @Override
    public void updateWeatherList(BulkCurrentWeather weatherList) {
        mWeatherListAdapter.addItems(weatherList);
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
}
