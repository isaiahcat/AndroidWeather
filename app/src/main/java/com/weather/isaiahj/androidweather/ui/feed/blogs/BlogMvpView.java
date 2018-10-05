package com.weather.isaiahj.androidweather.ui.feed.blogs;

import com.weather.isaiahj.androidweather.data.network.model.BlogResponse;
import com.weather.isaiahj.androidweather.ui.base.MvpView;

import java.util.List;

/**
 * Created by janisharali on 25/05/17.
 */

public interface BlogMvpView extends MvpView {

    void updateBlog(List<BlogResponse.Blog> blogList);
}
