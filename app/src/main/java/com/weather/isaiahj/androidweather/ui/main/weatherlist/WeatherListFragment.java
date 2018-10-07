package com.weather.isaiahj.androidweather.ui.main.weatherlist;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weather.isaiahj.androidweather.R;
import com.weather.isaiahj.androidweather.data.network.model.BulkCurrentWeather;
import com.weather.isaiahj.androidweather.data.network.model.currentweather.CurrentWeather;
import com.weather.isaiahj.androidweather.di.component.ActivityComponent;
import com.weather.isaiahj.androidweather.ui.base.BaseFragment;
import com.weather.isaiahj.androidweather.ui.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by isaiahj on 07/10/2018.
 */

public class WeatherListFragment extends BaseFragment implements
        WeatherListMvpView, WeatherListAdapter.Callback {

    public static final String TAG = "WeatherListFragment";

    private MainActivity mMainActivity;

    @Inject
    WeatherListMvpPresenter<WeatherListMvpView> mPresenter;

    @Inject
    WeatherListAdapter mWeatherListAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.fragment_weather_list_recycler)
    RecyclerView mRecyclerView;

    private Drawable mRefreshIcon;

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

            if (container != null && container.getContext() instanceof MainActivity) {
                mMainActivity = (MainActivity) container.getContext();
            }
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
    public void onWeatherListItemClick(CurrentWeather currentWeather, Pair<View, String>... sharedElements) {
        if (mMainActivity != null) {
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    mMainActivity, sharedElements);
            mMainActivity.openWeatherDetailActivity(currentWeather, options.toBundle());
        }
    }

    @Override
    public void onWeatherListEmptyViewRetryClick() {
        mPresenter.onViewPrepared();
    }

    @Override
    public void updateWeatherList(BulkCurrentWeather weatherList) {
        if (mRefreshIcon instanceof Animatable) ((Animatable) mRefreshIcon).stop();
        mWeatherListAdapter.addItems(weatherList);
    }

    @Override
    public void refreshWeatherList(Drawable refreshIcon) {
        mRefreshIcon = refreshIcon;
        mPresenter.onViewPrepared();
    }

    @Override
    public void onDestroyView() {
        mRefreshIcon = null;
        mPresenter.onDetach();
        super.onDestroyView();
    }
}
