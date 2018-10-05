package com.weather.isaiahj.androidweather.ui.feed.opensource;

import com.weather.isaiahj.androidweather.data.network.model.OpenSourceResponse;
import com.weather.isaiahj.androidweather.ui.base.MvpView;

import java.util.List;

/**
 * Created by janisharali on 25/05/17.
 */

public interface OpenSourceMvpView extends MvpView {

    void updateRepo(List<OpenSourceResponse.Repo> repoList);
}
