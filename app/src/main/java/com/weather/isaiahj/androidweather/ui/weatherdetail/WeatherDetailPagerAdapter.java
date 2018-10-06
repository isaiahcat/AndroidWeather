package com.weather.isaiahj.androidweather.ui.weatherdetail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Janisharali on 25/05/2017.
 */

public class WeatherDetailPagerAdapter extends FragmentStatePagerAdapter {

    private int mTabCount;

    public WeatherDetailPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mTabCount = 0;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
//                return BlogFragment.newInstance();
            case 1:
//                return OpenSourceFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setCount(int count) {
        mTabCount = count;
    }
}
