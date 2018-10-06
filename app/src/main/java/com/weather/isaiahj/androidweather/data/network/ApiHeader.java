package com.weather.isaiahj.androidweather.data.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.weather.isaiahj.androidweather.di.ApiInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by isaiahj on 05/10/2018.
 */

@Singleton
public class ApiHeader {

    private PublicApiHeader mPublicApiHeader;

    @Inject
    public ApiHeader(PublicApiHeader publicApiHeader) {
        mPublicApiHeader = publicApiHeader;
    }

    public PublicApiHeader getPublicApiHeader() {
        return mPublicApiHeader;
    }

    public static final class PublicApiHeader {

        @Expose
        @SerializedName("APPID")
        private String mApiKey;

        @Inject
        public PublicApiHeader(@ApiInfo String apiKey) {
            mApiKey = apiKey;
        }
    }
}
