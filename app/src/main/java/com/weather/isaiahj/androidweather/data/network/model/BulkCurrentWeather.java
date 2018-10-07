package com.weather.isaiahj.androidweather.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.weather.isaiahj.androidweather.data.network.model.currentweather.CurrentWeather;

import java.util.List;

public class BulkCurrentWeather {

    @SerializedName("cnt")
    @Expose
    private Integer cnt;
    @SerializedName("list")
    @Expose
    private List<CurrentWeather> list = null;

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public List<CurrentWeather> getList() {
        return list;
    }

    public void setList(List<CurrentWeather> list) {
        this.list = list;
    }

}