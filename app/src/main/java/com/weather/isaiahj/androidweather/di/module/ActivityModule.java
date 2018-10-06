package com.weather.isaiahj.androidweather.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.weather.isaiahj.androidweather.data.network.model.BlogResponse;
import com.weather.isaiahj.androidweather.data.network.model.OpenSourceResponse;
import com.weather.isaiahj.androidweather.di.ActivityContext;
import com.weather.isaiahj.androidweather.di.PerActivity;
import com.weather.isaiahj.androidweather.ui.about.AboutMvpPresenter;
import com.weather.isaiahj.androidweather.ui.about.AboutMvpView;
import com.weather.isaiahj.androidweather.ui.about.AboutPresenter;
import com.weather.isaiahj.androidweather.ui.feed.FeedMvpPresenter;
import com.weather.isaiahj.androidweather.ui.feed.FeedMvpView;
import com.weather.isaiahj.androidweather.ui.feed.FeedPagerAdapter;
import com.weather.isaiahj.androidweather.ui.feed.FeedPresenter;
import com.weather.isaiahj.androidweather.ui.feed.blogs.BlogAdapter;
import com.weather.isaiahj.androidweather.ui.feed.blogs.BlogMvpPresenter;
import com.weather.isaiahj.androidweather.ui.feed.blogs.BlogMvpView;
import com.weather.isaiahj.androidweather.ui.feed.blogs.BlogPresenter;
import com.weather.isaiahj.androidweather.ui.feed.opensource.OpenSourceAdapter;
import com.weather.isaiahj.androidweather.ui.feed.opensource.OpenSourceMvpPresenter;
import com.weather.isaiahj.androidweather.ui.feed.opensource.OpenSourceMvpView;
import com.weather.isaiahj.androidweather.ui.feed.opensource.OpenSourcePresenter;
import com.weather.isaiahj.androidweather.ui.main.MainMvpPresenter;
import com.weather.isaiahj.androidweather.ui.main.MainMvpView;
import com.weather.isaiahj.androidweather.ui.main.MainPresenter;
import com.weather.isaiahj.androidweather.ui.splash.SplashMvpPresenter;
import com.weather.isaiahj.androidweather.ui.splash.SplashMvpView;
import com.weather.isaiahj.androidweather.ui.splash.SplashPresenter;
import com.weather.isaiahj.androidweather.utils.rx.AppSchedulerProvider;
import com.weather.isaiahj.androidweather.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by isaiahj on 05/10/2018.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    AboutMvpPresenter<AboutMvpView> provideAboutPresenter(
            AboutPresenter<AboutMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedMvpPresenter<FeedMvpView> provideFeedPresenter(
            FeedPresenter<FeedMvpView> presenter) {
        return presenter;
    }

    @Provides
    OpenSourceMvpPresenter<OpenSourceMvpView> provideOpenSourcePresenter(
            OpenSourcePresenter<OpenSourceMvpView> presenter) {
        return presenter;
    }

    @Provides
    BlogMvpPresenter<BlogMvpView> provideBlogMvpPresenter(
            BlogPresenter<BlogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedPagerAdapter provideFeedPagerAdapter(AppCompatActivity activity) {
        return new FeedPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    OpenSourceAdapter provideOpenSourceAdapter() {
        return new OpenSourceAdapter(new ArrayList<OpenSourceResponse.Repo>());
    }

    @Provides
    BlogAdapter provideBlogAdapter() {
        return new BlogAdapter(new ArrayList<BlogResponse.Blog>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
