package com.weather.isaiahj.androidweather.ui.main;

import com.weather.isaiahj.androidweather.data.db.model.Question;
import com.weather.isaiahj.androidweather.ui.base.MvpView;

import java.util.List;

/**
 * Created by isaiahj on 05/10/2018.
 */

public interface MainMvpView extends MvpView {

    void openLoginActivity();

    void showAboutFragment();

    void refreshQuestionnaire(List<Question> questionList);

    void reloadQuestionnaire(List<Question> questionList);

    void updateUserName(String currentUserName);

    void updateUserEmail(String currentUserEmail);

    void updateUserProfilePic(String currentUserProfilePicUrl);

    void updateAppVersion();

    void showRateUsDialog();

    void openMyFeedActivity();

    void closeNavigationDrawer();

    void lockDrawer();

    void unlockDrawer();
}
