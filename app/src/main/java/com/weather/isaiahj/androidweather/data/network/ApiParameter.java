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
public class ApiParameter {

    private IdApiParameter mIdApiParameter;

    @Inject
    public ApiParameter(IdApiParameter idApiParameter) {
        mIdApiParameter = idApiParameter;
    }

    public IdApiParameter getIdApiParameter(String id) {
        return new IdApiParameter(id);
    }

    public static final class IdApiParameter {

        @Expose
        @SerializedName("id")
        private String id;

        @Inject
        public IdApiParameter(@ApiInfo String id) {
            this.id = id;
        }
    }
}
