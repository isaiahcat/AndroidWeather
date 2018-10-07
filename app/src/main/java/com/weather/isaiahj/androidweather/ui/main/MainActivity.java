package com.weather.isaiahj.androidweather.ui.main;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.weather.isaiahj.androidweather.R;
import com.weather.isaiahj.androidweather.data.db.model.Question;
import com.weather.isaiahj.androidweather.data.network.model.currentweather.CurrentWeather;
import com.weather.isaiahj.androidweather.ui.base.BaseActivity;
import com.weather.isaiahj.androidweather.ui.main.weatherlist.WeatherListFragment;
import com.weather.isaiahj.androidweather.ui.weatherdetail.WeatherDetailActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.provider.UserDictionary.Words.APP_ID;

/**
 * Created by isaiahj on 05/10/2018.
 */

public class MainActivity extends BaseActivity implements MainMvpView,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private static final int PERMISSION_ACCESS_COARSE_LOCATION = 100;

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private GoogleApiClient mGoogleApiClient;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        mGoogleApiClient = new GoogleApiClient.Builder(this, this, this)
                .addApi(LocationServices.API).build();

        setUp();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mGoogleApiClient != null) mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void refreshWeatherList(List<Question> questionList) {
        for (Question question : questionList) {
            if (question != null
                    && question.getOptionList() != null
                    && question.getOptionList().size() == 3) {
//                mCardsContainerView.addView(new QuestionCard(question));
            }
        }
    }

    @Override
    public void reloadWeatherList(List<Question> questionList) {
        refreshWeatherList(questionList);
        ScaleAnimation animation =
                new ScaleAnimation(
                        1.15f, 1, 1.15f, 1,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);

//        mCardsContainerView.setAnimation(animation);
        animation.setDuration(100);
        animation.start();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onFragmentAttached() {
    }

    @Override
    public void onFragmentDetached(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .remove(fragment)
                    .commitNow();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case R.id.action_refresh:
                FragmentManager fragmentManager = getSupportFragmentManager();
                Fragment fragment = fragmentManager.findFragmentById(R.id.list_container);

                if (fragment instanceof WeatherListFragment) {
                    ((WeatherListFragment) fragment).refreshWeatherList(drawable);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void setUp() {
        setSupportActionBar(mToolbar);
        setupWeatherListContainerView();
        mPresenter.onViewInitialized();
    }

    private void setupWeatherListContainerView() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.list_container, WeatherListFragment.newInstance())
                .commit();
    }

    @Override
    public void openWeatherDetailActivity(CurrentWeather currentWeather, Bundle sharedElementBundle) {
        startActivity(WeatherDetailActivity.getStartIntentWithParcelableExtra(
                MainActivity.this, currentWeather), sharedElementBundle);
    }

    @Override
    public void addCurrentLocation() {
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                    Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_ACCESS_COARSE_LOCATION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_ACCESS_COARSE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mGoogleApiClient.connect();
                } else {
                    onError(R.string.required_location);
                }
                break;
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

            if (location != null) {
                double lat = location.getLatitude(), lon = location.getLongitude();

            }
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        mGoogleApiClient.reconnect();
    }
}
