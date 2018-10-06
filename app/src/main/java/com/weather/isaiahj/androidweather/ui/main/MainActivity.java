package com.weather.isaiahj.androidweather.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.weather.isaiahj.androidweather.R;
import com.weather.isaiahj.androidweather.data.db.model.Question;
import com.weather.isaiahj.androidweather.data.network.model.currentweather.CurrentWeather;
import com.weather.isaiahj.androidweather.ui.about.AboutFragment;
import com.weather.isaiahj.androidweather.ui.base.BaseActivity;
import com.weather.isaiahj.androidweather.ui.feed.FeedActivity;
import com.weather.isaiahj.androidweather.ui.main.weatherlist.WeatherListFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by isaiahj on 05/10/2018.
 */

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(AboutFragment.TAG);
        if (fragment == null) {
            super.onBackPressed();
        } else {
            onFragmentDetached(AboutFragment.TAG);
        }
    }

    @Override
    public void refreshWeatherList(List<Question> questionList) {
        for (Question question : questionList) {
            if (question != null
                    && question.getOptionList() != null
                    && question.getOptionList().size() == 3) {
//                mCardsContainerView.addView(new QuestionCard(question));
            }
        }
    }

    @Override
    public void reloadWeatherList(List<Question> questionList) {
        refreshWeatherList(questionList);
        ScaleAnimation animation =
                new ScaleAnimation(
                        1.15f, 1, 1.15f, 1,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);

//        mCardsContainerView.setAnimation(animation);
        animation.setDuration(100);
        animation.start();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onFragmentAttached() {
    }

    @Override
    public void onFragmentDetached(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .remove(fragment)
                    .commitNow();
        }
    }

    @Override
    protected void setUp() {
        setupWeatherListContainerView();
        mPresenter.onViewInitialized();
    }

    private void setupWeatherListContainerView() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, WeatherListFragment.newInstance())
                .commit();
    }

    @Override
    public void openWeatherDetailActivity(CurrentWeather currentWeather) {
        startActivity(FeedActivity.getStartIntent(MainActivity.this));
    }
}
