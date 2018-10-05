package com.weather.isaiahj.androidweather.data.network;

import com.weather.isaiahj.androidweather.data.network.model.BlogResponse;
import com.weather.isaiahj.androidweather.data.network.model.LoginRequest;
import com.weather.isaiahj.androidweather.data.network.model.LoginResponse;
import com.weather.isaiahj.androidweather.data.network.model.LogoutResponse;
import com.weather.isaiahj.androidweather.data.network.model.OpenSourceResponse;

import io.reactivex.Single;

/**
 * Created by isaiahj on 05/10/2018.
 */

public interface ApiHelper {

    ApiHeader getApiHeader();

    Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Single<LogoutResponse> doLogoutApiCall();

    Single<BlogResponse> getBlogApiCall();

    Single<OpenSourceResponse> getOpenSourceApiCall();
}
