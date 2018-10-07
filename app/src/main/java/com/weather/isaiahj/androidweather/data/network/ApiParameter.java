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

    @Inject
    public ApiParameter() {

    }

    public IdApiParameter getIdApiParameter(String id) {
        return new IdApiParameter(id);
    }

    public LatApiParameter getLatApiParameter(double lat) {
        return new LatApiParameter(lat);
    }

    public LonApiParameter getLonApiParameter(double lon) {
        return new LonApiParameter(lon);
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

    public static final class LatApiParameter {

        @Expose
        @SerializedName("lat")
        private double lat;

        @Inject
        public LatApiParameter(@ApiInfo double lat) {
            this.lat = lat;
        }
    }

    public static final class LonApiParameter {

        @Expose
        @SerializedName("lon")
        private double lon;

        @Inject
        public LonApiParameter(@ApiInfo double lon) {
            this.lon = lon;
        }
    }
}
