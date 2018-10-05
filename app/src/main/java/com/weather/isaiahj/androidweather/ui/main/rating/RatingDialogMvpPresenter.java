package com.weather.isaiahj.androidweather.ui.main.rating;

import com.weather.isaiahj.androidweather.ui.base.MvpPresenter;

/**
 * Created by janisharali on 22/03/17.
 */

public interface RatingDialogMvpPresenter<V extends RatingDialogMvpView> extends MvpPresenter<V> {

    void onRatingSubmitted(float rating, String message);

    void onCancelClicked();

    void onLaterClicked();

    void onPlayStoreRatingClicked();
}
