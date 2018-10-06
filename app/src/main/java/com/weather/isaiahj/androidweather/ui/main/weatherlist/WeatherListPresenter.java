package com.weather.isaiahj.androidweather.ui.main.weatherlist;

import com.weather.isaiahj.androidweather.data.DataManager;
import com.weather.isaiahj.androidweather.ui.base.BasePresenter;
import com.weather.isaiahj.androidweather.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by isaiahj on 07/10/2018.
 */

public class WeatherListPresenter<V extends WeatherListMvpView> extends BasePresenter<V>
        implements WeatherListMvpPresenter<V> {

    @Inject
    public WeatherListPresenter(DataManager dataManager,
                                SchedulerProvider schedulerProvider,
                                CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {
//        getMvpView().showLoading();
//        getCompositeDisposable().add(getDataManager()
//                .getBlogApiCall()
//                .subscribeOn(getSchedulerProvider().io())
//                .observeOn(getSchedulerProvider().ui())
//                .subscribe(new Consumer<BlogResponse>() {
//                    @Override
//                    public void accept(@NonNull BlogResponse blogResponse)
//                            throws Exception {
//                        if (blogResponse != null && blogResponse.getData() != null) {
//                            getMvpView().updateBlog(blogResponse.getData());
//                        }
//                        getMvpView().hideLoading();
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(@NonNull Throwable throwable)
//                            throws Exception {
//                        if (!isViewAttached()) {
//                            return;
//                        }
//
//                        getMvpView().hideLoading();
//
//                        // handle the error here
//                        if (throwable instanceof ANError) {
//                            ANError anError = (ANError) throwable;
//                            handleApiError(anError);
//                        }
//                    }
//                }));
    }
}
